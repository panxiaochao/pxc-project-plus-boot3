package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysloglogin.SysLogLoginBO;

import java.util.List;

/**
 * <p>系统管理-系统日志登录/登出表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysLogLoginService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-系统日志登录/登出表 实体
     */
    SysLogLoginBO getById(Integer id);
    
    /**
     * 保存
     * @param sysLogLogin 系统管理-系统日志登录/登出表 实体
     * @return 系统管理-系统日志登录/登出表 实体
     */
    SysLogLoginBO save(SysLogLoginBO sysLogLogin);

    /**
     * 批量保存
     * @param sysLogLoginList 批量数据
     */
    List<SysLogLoginBO> saveBatch(List<SysLogLoginBO> sysLogLoginList);
    
    /**
     * 根据主键更新
     * @param sysLogLogin 系统管理-系统日志登录/登出表 实体
     */
    void update(SysLogLoginBO sysLogLogin);

    /**
     * 批量更新
     * @param sysLogLoginList 批量数据
     */
    void updateBatch(List<SysLogLoginBO> sysLogLoginList);

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
