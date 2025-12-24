package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysrole.SysRoleBO;

import java.util.List;

/**
 * <p>系统管理-角色表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysRoleService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-角色表 实体
     */
    SysRoleBO getById(Integer id);
    
    /**
     * 保存
     * @param sysRole 系统管理-角色表 实体
     * @return 系统管理-角色表 实体
     */
    SysRoleBO save(SysRoleBO sysRole);

    /**
     * 批量保存
     * @param sysRoleList 批量数据
     */
    List<SysRoleBO> saveBatch(List<SysRoleBO> sysRoleList);
    
    /**
     * 根据主键更新
     * @param sysRole 系统管理-角色表 实体
     */
    void update(SysRoleBO sysRole);

    /**
     * 批量更新
     * @param sysRoleList 批量数据
     */
    void updateBatch(List<SysRoleBO> sysRoleList);

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
