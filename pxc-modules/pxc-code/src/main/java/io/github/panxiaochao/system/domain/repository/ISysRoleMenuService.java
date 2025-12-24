package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysrolemenu.SysRoleMenuBO;

import java.util.List;

/**
 * <p>系统管理-角色菜单表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysRoleMenuService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-角色菜单表 实体
     */
    SysRoleMenuBO getById(Integer id);
    
    /**
     * 保存
     * @param sysRoleMenu 系统管理-角色菜单表 实体
     * @return 系统管理-角色菜单表 实体
     */
    SysRoleMenuBO save(SysRoleMenuBO sysRoleMenu);

    /**
     * 批量保存
     * @param sysRoleMenuList 批量数据
     */
    List<SysRoleMenuBO> saveBatch(List<SysRoleMenuBO> sysRoleMenuList);
    
    /**
     * 根据主键更新
     * @param sysRoleMenu 系统管理-角色菜单表 实体
     */
    void update(SysRoleMenuBO sysRoleMenu);

    /**
     * 批量更新
     * @param sysRoleMenuList 批量数据
     */
    void updateBatch(List<SysRoleMenuBO> sysRoleMenuList);

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
