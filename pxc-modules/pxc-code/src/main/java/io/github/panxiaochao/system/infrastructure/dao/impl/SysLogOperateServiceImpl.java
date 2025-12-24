package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.syslogoperate.SysLogOperatePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.syslogoperate.SysLogOperateQueryDTO;
import io.github.panxiaochao.system.application.api.vo.syslogoperate.SysLogOperateQueryVO;
import io.github.panxiaochao.system.application.repository.ISysLogOperateReadModelService;
import io.github.panxiaochao.system.domain.entity.syslogoperate.SysLogOperateBO;
import io.github.panxiaochao.system.domain.repository.ISysLogOperateService;
import io.github.panxiaochao.system.infrastructure.convert.ISysLogOperatePOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysLogOperateMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysLogOperatePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-系统日志操作表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysLogOperateServiceImpl implements ISysLogOperateService, ISysLogOperateReadModelService {

    /**
     * 系统管理-系统日志操作表 持久化接口
     */
    private final SysLogOperateMapper sysLogOperateMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-系统日志操作表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysLogOperateQueryVO> page(Pagination pagination, SysLogOperatePageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysLogOperatePO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysLogOperatePO> page = sysLogOperateMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysLogOperatePOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-系统日志操作表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysLogOperateQueryVO> selectList(SysLogOperateQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysLogOperatePO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysLogOperatePOConvert.INSTANCE.toQueryVO(sysLogOperateMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-系统日志操作表 查询请求对象
     * @return 系统管理-系统日志操作表 查询响应对象
     */
    @Override
    public SysLogOperateQueryVO getOne(SysLogOperateQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysLogOperatePO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysLogOperatePO sysLogOperatePO = sysLogOperateMapper.selectOne(lqw);
            return ISysLogOperatePOConvert.INSTANCE.toQueryVO(sysLogOperatePO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-系统日志操作表 分页查询请求对象
     * @return 系统管理-系统日志操作表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysLogOperatePO> lambdaQuery(SysLogOperatePageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysLogOperatePO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysLogOperatePO::getId);
            // 如果 操作标题 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOpTitle())) {
                lqw.eq(SysLogOperatePO::getOpTitle, pageQueryDto.getOpTitle());
            }
            // 如果 日志内容 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getLogContent())) {
                lqw.eq(SysLogOperatePO::getLogContent, pageQueryDto.getLogContent());
            }
            // 如果 操作类型 不为空
            if (pageQueryDto.getOperateType() != null) {
                lqw.eq(SysLogOperatePO::getOperateType, pageQueryDto.getOperateType());
            }
            // 如果 IP 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getIp())) {
                lqw.eq(SysLogOperatePO::getIp, pageQueryDto.getIp());
            }
            // 如果 请求地址 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAddress())) {
                lqw.eq(SysLogOperatePO::getAddress, pageQueryDto.getAddress());
            }
            // 如果 请求java方法 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getMethod())) {
                lqw.eq(SysLogOperatePO::getMethod, pageQueryDto.getMethod());
            }
            // 如果 请求路径 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRequestUrl())) {
                lqw.eq(SysLogOperatePO::getRequestUrl, pageQueryDto.getRequestUrl());
            }
            // 如果 请求参数 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRequestParams())) {
                lqw.eq(SysLogOperatePO::getRequestParams, pageQueryDto.getRequestParams());
            }
            // 如果 请求类型 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRequestMethod())) {
                lqw.eq(SysLogOperatePO::getRequestMethod, pageQueryDto.getRequestMethod());
            }
            // 如果 耗时 不为空
            if (pageQueryDto.getCostTime() != null) {
                lqw.eq(SysLogOperatePO::getCostTime, pageQueryDto.getCostTime());
            }
            // 如果 是否成功 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysLogOperatePO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 浏览器 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getBrowser())) {
                lqw.eq(SysLogOperatePO::getBrowser, pageQueryDto.getBrowser());
            }
            // 如果 操作系统 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOs())) {
                lqw.eq(SysLogOperatePO::getOs, pageQueryDto.getOs());
            }
            // 如果 操作用户 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOpUser())) {
                lqw.eq(SysLogOperatePO::getOpUser, pageQueryDto.getOpUser());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysLogOperatePO::getCreateAt, pageQueryDto.getCreateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysLogOperateBO 实体
     */
    @Override
    public SysLogOperateBO getById(Integer id) {
        SysLogOperatePO sysLogOperatePO = sysLogOperateMapper.selectById(id);
        return ISysLogOperatePOConvert.INSTANCE.toEntityBO(sysLogOperatePO);
    }

    /**
     * 保存 系统管理-系统日志操作表 对象
     * @param sysLogOperate SysLogOperateBO 实体
     * @return SysLogOperateBO 实体
     */
    @Override
    public SysLogOperateBO save(SysLogOperateBO sysLogOperate) {
        SysLogOperatePO sysLogOperatePO = ISysLogOperatePOConvert.INSTANCE.fromEntity(sysLogOperate);
        sysLogOperateMapper.insert(sysLogOperatePO);
        return ISysLogOperatePOConvert.INSTANCE.toEntityBO(sysLogOperatePO);
    }

    /**
     * 批量 保存 系统管理-系统日志操作表 对象
     * @param sysLogOperateList 批量数据
     */
    @Override
    public List<SysLogOperateBO> saveBatch(List<SysLogOperateBO> sysLogOperateList) {
        List<SysLogOperatePO> sysLogOperatePOList = ISysLogOperatePOConvert.INSTANCE.fromEntity(sysLogOperateList);
        Db.saveBatch(sysLogOperatePOList);
        return ISysLogOperatePOConvert.INSTANCE.toEntityBO(sysLogOperatePOList);
    }

    /**
     * 根据主键更新
     * @param sysLogOperate SysLogOperateBO 实体
     */
    @Override
    public void update(SysLogOperateBO sysLogOperate) {
        SysLogOperatePO sysLogOperatePO = ISysLogOperatePOConvert.INSTANCE.fromEntity(sysLogOperate);
        sysLogOperateMapper.updateById(sysLogOperatePO);
    }

    /**
     * 根据主键 批量更新 系统管理-系统日志操作表 对象
     * @param sysLogOperateList 批量数据
     */
    @Override
    public void updateBatch(List<SysLogOperateBO> sysLogOperateList) {
    List<SysLogOperatePO> sysLogOperatePOList = ISysLogOperatePOConvert.INSTANCE.fromEntity(sysLogOperateList);
        Db.updateBatchById(sysLogOperatePOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysLogOperateMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysLogOperateMapper.deleteByIds(idList);
    }

}
