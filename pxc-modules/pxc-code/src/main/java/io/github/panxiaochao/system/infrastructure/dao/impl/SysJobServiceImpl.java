package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysjob.SysJobQueryVO;
import io.github.panxiaochao.system.application.repository.ISysJobReadModelService;
import io.github.panxiaochao.system.domain.entity.sysjob.SysJobBO;
import io.github.panxiaochao.system.domain.repository.ISysJobService;
import io.github.panxiaochao.system.infrastructure.convert.ISysJobPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysJobMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysJobPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-定时任务调度表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysJobServiceImpl implements ISysJobService, ISysJobReadModelService {

    /**
     * 系统管理-定时任务调度表 持久化接口
     */
    private final SysJobMapper sysJobMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-定时任务调度表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysJobQueryVO> page(Pagination pagination, SysJobPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysJobPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysJobPO> page = sysJobMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysJobPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-定时任务调度表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysJobQueryVO> selectList(SysJobQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysJobPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysJobPOConvert.INSTANCE.toQueryVO(sysJobMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-定时任务调度表 查询请求对象
     * @return 系统管理-定时任务调度表 查询响应对象
     */
    @Override
    public SysJobQueryVO getOne(SysJobQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysJobPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysJobPO sysJobPO = sysJobMapper.selectOne(lqw);
            return ISysJobPOConvert.INSTANCE.toQueryVO(sysJobPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-定时任务调度表 分页查询请求对象
     * @return 系统管理-定时任务调度表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysJobPO> lambdaQuery(SysJobPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysJobPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysJobPO::getId);
            // 如果 任务编码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getJobCode())) {
                lqw.eq(SysJobPO::getJobCode, pageQueryDto.getJobCode());
            }
            // 如果 任务名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getJobName())) {
                lqw.eq(SysJobPO::getJobName, pageQueryDto.getJobName());
            }
            // 如果 任务组 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getJobGroup())) {
                lqw.eq(SysJobPO::getJobGroup, pageQueryDto.getJobGroup());
            }
            // 如果 调用目标：可以是Bean 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getInvokeBean())) {
                lqw.eq(SysJobPO::getInvokeBean, pageQueryDto.getInvokeBean());
            }
            // 如果 调用目标方法 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getInvokeMethod())) {
                lqw.eq(SysJobPO::getInvokeMethod, pageQueryDto.getInvokeMethod());
            }
            // 如果 目标方法参数 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getMethodParams())) {
                lqw.eq(SysJobPO::getMethodParams, pageQueryDto.getMethodParams());
            }
            // 如果 参数类型：string,int,boolean,long,float 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getParamsType())) {
                lqw.eq(SysJobPO::getParamsType, pageQueryDto.getParamsType());
            }
            // 如果 cron执行表达式 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getCronExpression())) {
                lqw.eq(SysJobPO::getCronExpression, pageQueryDto.getCronExpression());
            }
            // 如果 任务状态：1=正常 0=停用 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getJobState())) {
                lqw.eq(SysJobPO::getJobState, pageQueryDto.getJobState());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysJobPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateBy() != null) {
                lqw.eq(SysJobPO::getCreateBy, pageQueryDto.getCreateBy());
            }
            // 如果  不为空
            if (pageQueryDto.getUpdateBy() != null) {
                lqw.eq(SysJobPO::getUpdateBy, pageQueryDto.getUpdateBy());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysJobPO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysJobPO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysJobBO 实体
     */
    @Override
    public SysJobBO getById(Integer id) {
        SysJobPO sysJobPO = sysJobMapper.selectById(id);
        return ISysJobPOConvert.INSTANCE.toEntityBO(sysJobPO);
    }

    /**
     * 保存 系统管理-定时任务调度表 对象
     * @param sysJob SysJobBO 实体
     * @return SysJobBO 实体
     */
    @Override
    public SysJobBO save(SysJobBO sysJob) {
        SysJobPO sysJobPO = ISysJobPOConvert.INSTANCE.fromEntity(sysJob);
        sysJobMapper.insert(sysJobPO);
        return ISysJobPOConvert.INSTANCE.toEntityBO(sysJobPO);
    }

    /**
     * 批量 保存 系统管理-定时任务调度表 对象
     * @param sysJobList 批量数据
     */
    @Override
    public List<SysJobBO> saveBatch(List<SysJobBO> sysJobList) {
        List<SysJobPO> sysJobPOList = ISysJobPOConvert.INSTANCE.fromEntity(sysJobList);
        Db.saveBatch(sysJobPOList);
        return ISysJobPOConvert.INSTANCE.toEntityBO(sysJobPOList);
    }

    /**
     * 根据主键更新
     * @param sysJob SysJobBO 实体
     */
    @Override
    public void update(SysJobBO sysJob) {
        SysJobPO sysJobPO = ISysJobPOConvert.INSTANCE.fromEntity(sysJob);
        sysJobMapper.updateById(sysJobPO);
    }

    /**
     * 根据主键 批量更新 系统管理-定时任务调度表 对象
     * @param sysJobList 批量数据
     */
    @Override
    public void updateBatch(List<SysJobBO> sysJobList) {
    List<SysJobPO> sysJobPOList = ISysJobPOConvert.INSTANCE.fromEntity(sysJobList);
        Db.updateBatchById(sysJobPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysJobMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysJobMapper.deleteByIds(idList);
    }

}
