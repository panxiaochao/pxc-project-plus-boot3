package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysdict.SysDictPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysdict.SysDictQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysdict.SysDictQueryVO;
import io.github.panxiaochao.system.application.repository.ISysDictReadModelService;
import io.github.panxiaochao.system.domain.entity.sysdict.SysDictBO;
import io.github.panxiaochao.system.domain.repository.ISysDictService;
import io.github.panxiaochao.system.infrastructure.convert.ISysDictPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysDictMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysDictPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统管理-数据字典表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysDictServiceImpl implements ISysDictService, ISysDictReadModelService {

    /**
     * 系统管理-数据字典表 持久化接口
     */
    private final SysDictMapper sysDictMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-数据字典表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysDictQueryVO> page(Pagination pagination, SysDictPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysDictPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysDictPO> page = sysDictMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysDictPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-数据字典表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysDictQueryVO> selectList(SysDictQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysDictPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysDictPOConvert.INSTANCE.toQueryVO(sysDictMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-数据字典表 查询请求对象
     * @return 系统管理-数据字典表 查询响应对象
     */
    @Override
    public SysDictQueryVO getOne(SysDictQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysDictPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysDictPO sysDictPO = sysDictMapper.selectOne(lqw);
            return ISysDictPOConvert.INSTANCE.toQueryVO(sysDictPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-数据字典表 分页查询请求对象
     * @return 系统管理-数据字典表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysDictPO> lambdaQuery(SysDictPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysDictPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysDictPO::getId);
            // 如果 字典名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getDictName())) {
                lqw.eq(SysDictPO::getDictName, pageQueryDto.getDictName());
            }
            // 如果 字典code 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getDictCode())) {
                lqw.eq(SysDictPO::getDictCode, pageQueryDto.getDictCode());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysDictPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysDictPO::getSort, pageQueryDto.getSort());
            }
            // 如果 状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysDictPO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateBy() != null) {
                lqw.eq(SysDictPO::getCreateBy, pageQueryDto.getCreateBy());
            }
            // 如果 更新人 不为空
            if (pageQueryDto.getUpdateBy() != null) {
                lqw.eq(SysDictPO::getUpdateBy, pageQueryDto.getUpdateBy());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysDictPO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysDictPO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysDictBO 实体
     */
    @Override
    public SysDictBO getById(Integer id) {
        SysDictPO sysDictPO = sysDictMapper.selectById(id);
        return ISysDictPOConvert.INSTANCE.toEntityBO(sysDictPO);
    }

    /**
     * 保存 系统管理-数据字典表 对象
     * @param sysDict SysDictBO 实体
     * @return SysDictBO 实体
     */
    @Override
    public SysDictBO save(SysDictBO sysDict) {
        SysDictPO sysDictPO = ISysDictPOConvert.INSTANCE.fromEntity(sysDict);
        sysDictMapper.insert(sysDictPO);
        return ISysDictPOConvert.INSTANCE.toEntityBO(sysDictPO);
    }

    /**
     * 批量 保存 系统管理-数据字典表 对象
     * @param sysDictList 批量数据
     */
    @Override
    public List<SysDictBO> saveBatch(List<SysDictBO> sysDictList) {
        List<SysDictPO> sysDictPOList = ISysDictPOConvert.INSTANCE.fromEntity(sysDictList);
        Db.saveBatch(sysDictPOList);
        return ISysDictPOConvert.INSTANCE.toEntityBO(sysDictPOList);
    }

    /**
     * 根据主键更新
     * @param sysDict SysDictBO 实体
     */
    @Override
    public void update(SysDictBO sysDict) {
        SysDictPO sysDictPO = ISysDictPOConvert.INSTANCE.fromEntity(sysDict);
        sysDictMapper.updateById(sysDictPO);
    }

    /**
     * 根据主键 批量更新 系统管理-数据字典表 对象
     * @param sysDictList 批量数据
     */
    @Override
    public void updateBatch(List<SysDictBO> sysDictList) {
        List<SysDictPO> sysDictPOList = ISysDictPOConvert.INSTANCE.fromEntity(sysDictList);
        Db.updateBatchById(sysDictPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysDictMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysDictMapper.deleteByIds(idList);
    }

}
