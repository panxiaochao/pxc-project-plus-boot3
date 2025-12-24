package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysmenu.SysMenuBO;

import java.util.List;

/**
 * <p>系统管理-菜单配置 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysMenuService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-菜单配置 实体
     */
    SysMenuBO getById(Integer id);
    
    /**
     * 保存
     * @param sysMenu 系统管理-菜单配置 实体
     * @return 系统管理-菜单配置 实体
     */
    SysMenuBO save(SysMenuBO sysMenu);

    /**
     * 批量保存
     * @param sysMenuList 批量数据
     */
    List<SysMenuBO> saveBatch(List<SysMenuBO> sysMenuList);
    
    /**
     * 根据主键更新
     * @param sysMenu 系统管理-菜单配置 实体
     */
    void update(SysMenuBO sysMenu);

    /**
     * 批量更新
     * @param sysMenuList 批量数据
     */
    void updateBatch(List<SysMenuBO> sysMenuList);

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
