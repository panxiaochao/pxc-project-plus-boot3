package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysuserrole.SysUserRoleBO;

import java.util.List;

/**
 * <p>系统管理-用户角色表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysUserRoleService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-用户角色表 实体
     */
    SysUserRoleBO getById(Integer id);
    
    /**
     * 保存
     * @param sysUserRole 系统管理-用户角色表 实体
     * @return 系统管理-用户角色表 实体
     */
    SysUserRoleBO save(SysUserRoleBO sysUserRole);

    /**
     * 批量保存
     * @param sysUserRoleList 批量数据
     */
    List<SysUserRoleBO> saveBatch(List<SysUserRoleBO> sysUserRoleList);
    
    /**
     * 根据主键更新
     * @param sysUserRole 系统管理-用户角色表 实体
     */
    void update(SysUserRoleBO sysUserRole);

    /**
     * 批量更新
     * @param sysUserRoleList 批量数据
     */
    void updateBatch(List<SysUserRoleBO> sysUserRoleList);

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
