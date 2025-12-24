package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysparam.SysParamPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysparam.SysParamQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysparam.SysParamQueryVO;
import io.github.panxiaochao.system.application.repository.ISysParamReadModelService;
import io.github.panxiaochao.system.domain.entity.sysparam.SysParamBO;
import io.github.panxiaochao.system.domain.repository.ISysParamService;
import io.github.panxiaochao.system.infrastructure.convert.ISysParamPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysParamMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysParamPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统管理-系统参数 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysParamServiceImpl implements ISysParamService, ISysParamReadModelService {

    /**
     * 系统管理-系统参数 持久化接口
     */
    private final SysParamMapper sysParamMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-系统参数 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysParamQueryVO> page(Pagination pagination, SysParamPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysParamPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysParamPO> page = sysParamMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()),
                lqw);
        pagination.setTotal(page.getTotal());
        return ISysParamPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-系统参数 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysParamQueryVO> selectList(SysParamQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysParamPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysParamPOConvert.INSTANCE.toQueryVO(sysParamMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-系统参数 查询请求对象
     * @return 系统管理-系统参数 查询响应对象
     */
    @Override
    public SysParamQueryVO getOne(SysParamQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysParamPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysParamPO sysParamPO = sysParamMapper.selectOne(lqw);
            return ISysParamPOConvert.INSTANCE.toQueryVO(sysParamPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-系统参数 分页查询请求对象
     * @return 系统管理-系统参数 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysParamPO> lambdaQuery(SysParamPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysParamPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysParamPO::getId);
            // 如果 参数名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getParamName())) {
                lqw.eq(SysParamPO::getParamName, pageQueryDto.getParamName());
            }
            // 如果 参数键 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getParamKey())) {
                lqw.eq(SysParamPO::getParamKey, pageQueryDto.getParamKey());
            }
            // 如果 参数值 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getParamValue())) {
                lqw.eq(SysParamPO::getParamValue, pageQueryDto.getParamValue());
            }
            // 如果 参数类型1-系统类 2-业务类 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getParamType())) {
                lqw.eq(SysParamPO::getParamType, pageQueryDto.getParamType());
            }
            // 如果 状态1-正常 0-不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysParamPO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateBy() != null) {
                lqw.eq(SysParamPO::getCreateBy, pageQueryDto.getCreateBy());
            }
            // 如果 更新人 不为空
            if (pageQueryDto.getUpdateBy() != null) {
                lqw.eq(SysParamPO::getUpdateBy, pageQueryDto.getUpdateBy());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysParamPO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysParamPO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysParamBO 实体
     */
    @Override
    public SysParamBO getById(Integer id) {
        SysParamPO sysParamPO = sysParamMapper.selectById(id);
        return ISysParamPOConvert.INSTANCE.toEntityBO(sysParamPO);
    }

    /**
     * 保存 系统管理-系统参数 对象
     * @param sysParam SysParamBO 实体
     * @return SysParamBO 实体
     */
    @Override
    public SysParamBO save(SysParamBO sysParam) {
        SysParamPO sysParamPO = ISysParamPOConvert.INSTANCE.fromEntity(sysParam);
        sysParamMapper.insert(sysParamPO);
        return ISysParamPOConvert.INSTANCE.toEntityBO(sysParamPO);
    }

    /**
     * 批量 保存 系统管理-系统参数 对象
     * @param sysParamList 批量数据
     */
    @Override
    public List<SysParamBO> saveBatch(List<SysParamBO> sysParamList) {
        List<SysParamPO> sysParamPOList = ISysParamPOConvert.INSTANCE.fromEntity(sysParamList);
        Db.saveBatch(sysParamPOList);
        return ISysParamPOConvert.INSTANCE.toEntityBO(sysParamPOList);
    }

    /**
     * 根据主键更新
     * @param sysParam SysParamBO 实体
     */
    @Override
    public void update(SysParamBO sysParam) {
        SysParamPO sysParamPO = ISysParamPOConvert.INSTANCE.fromEntity(sysParam);
        sysParamMapper.updateById(sysParamPO);
    }

    /**
     * 根据主键 批量更新 系统管理-系统参数 对象
     * @param sysParamList 批量数据
     */
    @Override
    public void updateBatch(List<SysParamBO> sysParamList) {
        List<SysParamPO> sysParamPOList = ISysParamPOConvert.INSTANCE.fromEntity(sysParamList);
        Db.updateBatchById(sysParamPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysParamMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysParamMapper.deleteByIds(idList);
    }

}
