package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysjob.SysJobQueryVO;
import io.github.panxiaochao.system.domain.entity.sysjob.SysJobBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysJobPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-定时任务调度表 持久化对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysJobPOConvert {

    /**
     * 系统管理-定时任务调度表 持久化对象结构映射实例
     */
    ISysJobPOConvert INSTANCE = Mappers.getMapper(ISysJobPOConvert.class);

    /**
     * 系统管理-定时任务调度表 实体 转 系统管理-定时任务调度表 持久化对象
     * @param sysJob 系统管理-定时任务调度表 实体
     * @return 系统管理-定时任务调度表 持久化对象
     */
    SysJobPO fromEntity(SysJobBO sysJob);

    /**
     * 系统管理-定时任务调度表 实体 转 系统管理-定时任务调度表 持久化对象
     * @param sysJobList 系统管理-定时任务调度表 实体
     * @return 系统管理-定时任务调度表 持久化对象
     */
    List<SysJobPO> fromEntity(List<SysJobBO> sysJobList);

    /**
     * 系统管理-定时任务调度表 持久化对象 转 系统管理-定时任务调度表 实体
     * @param sysJobPO 系统管理-定时任务调度表 持久化对象
     * @return 系统管理-定时任务调度表 实体
     */
    SysJobBO toEntityBO(SysJobPO sysJobPO);

    /**
     * 系统管理-定时任务调度表 持久化对象 转 系统管理-定时任务调度表 实体
     * @param sysJobPOList 系统管理-定时任务调度表 持久化对象
     * @return 系统管理-定时任务调度表 实体
     */
    List<SysJobBO> toEntityBO(List<SysJobPO> sysJobPOList);

    /**
     * 系统管理-定时任务调度表 持久化对象 转 系统管理-定时任务调度表 查询响应数据传输对象
     * @param sysJobPO 系统管理-定时任务调度表 持久化对象
     * @return 系统管理-定时任务调度表 查询响应数据传输对象
     */
    SysJobQueryVO toQueryVO(SysJobPO sysJobPO);

    /**
     * 系统管理-定时任务调度表 持久化对象列表 转 系统管理-定时任务调度表 查询响应数据传输对象列表
     * @param sysJobPOList 系统管理-定时任务调度表 持久化对象列表
     * @return 系统管理-定时任务调度表 查询响应数据传输对象列表
     */
    List<SysJobQueryVO> toQueryVO(List<SysJobPO> sysJobPOList);
}
