package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysjob.SysJobBO;

import java.util.List;

/**
 * <p>系统管理-定时任务调度表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysJobService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-定时任务调度表 实体
     */
    SysJobBO getById(Integer id);
    
    /**
     * 保存
     * @param sysJob 系统管理-定时任务调度表 实体
     * @return 系统管理-定时任务调度表 实体
     */
    SysJobBO save(SysJobBO sysJob);

    /**
     * 批量保存
     * @param sysJobList 批量数据
     */
    List<SysJobBO> saveBatch(List<SysJobBO> sysJobList);
    
    /**
     * 根据主键更新
     * @param sysJob 系统管理-定时任务调度表 实体
     */
    void update(SysJobBO sysJob);

    /**
     * 批量更新
     * @param sysJobList 批量数据
     */
    void updateBatch(List<SysJobBO> sysJobList);

    /**
     * 根据主键删除
     * @param id 主键
     */
    void deleteById(Integer id);

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    void deleteByIds(List<Integer> idList);
}
