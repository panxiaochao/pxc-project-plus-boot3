package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.syslogoperate.SysLogOperateBO;

import java.util.List;

/**
 * <p>
 * 系统管理-系统日志操作表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysLogOperateService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-系统日志操作表 实体
     */
    SysLogOperateBO getById(Integer id);

    /**
     * 保存
     * @param sysLogOperate 系统管理-系统日志操作表 实体
     * @return 系统管理-系统日志操作表 实体
     */
    SysLogOperateBO save(SysLogOperateBO sysLogOperate);

    /**
     * 批量保存
     * @param sysLogOperateList 批量数据
     */
    List<SysLogOperateBO> saveBatch(List<SysLogOperateBO> sysLogOperateList);

    /**
     * 根据主键更新
     * @param sysLogOperate 系统管理-系统日志操作表 实体
     */
    void update(SysLogOperateBO sysLogOperate);

    /**
     * 批量更新
     * @param sysLogOperateList 批量数据
     */
    void updateBatch(List<SysLogOperateBO> sysLogOperateList);

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
