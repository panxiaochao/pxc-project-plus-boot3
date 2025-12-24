package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.systenantpackagemenu.SysTenantPackageMenuBO;

import java.util.List;

/**
 * <p>系统管理-租户套餐菜单表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysTenantPackageMenuService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-租户套餐菜单表 实体
     */
    SysTenantPackageMenuBO getById(Integer id);
    
    /**
     * 保存
     * @param sysTenantPackageMenu 系统管理-租户套餐菜单表 实体
     * @return 系统管理-租户套餐菜单表 实体
     */
    SysTenantPackageMenuBO save(SysTenantPackageMenuBO sysTenantPackageMenu);

    /**
     * 批量保存
     * @param sysTenantPackageMenuList 批量数据
     */
    List<SysTenantPackageMenuBO> saveBatch(List<SysTenantPackageMenuBO> sysTenantPackageMenuList);
    
    /**
     * 根据主键更新
     * @param sysTenantPackageMenu 系统管理-租户套餐菜单表 实体
     */
    void update(SysTenantPackageMenuBO sysTenantPackageMenu);

    /**
     * 批量更新
     * @param sysTenantPackageMenuList 批量数据
     */
    void updateBatch(List<SysTenantPackageMenuBO> sysTenantPackageMenuList);

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
