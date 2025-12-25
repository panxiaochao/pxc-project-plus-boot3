package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.systenantpackage.SysTenantPackageBO;

import java.util.List;

/**
 * <p>
 * 系统管理-租户套餐表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysTenantPackageService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-租户套餐表 实体
     */
    SysTenantPackageBO getById(Integer id);

    /**
     * 保存
     * @param sysTenantPackage 系统管理-租户套餐表 实体
     * @return 系统管理-租户套餐表 实体
     */
    SysTenantPackageBO save(SysTenantPackageBO sysTenantPackage);

    /**
     * 批量保存
     * @param sysTenantPackageList 批量数据
     */
    List<SysTenantPackageBO> saveBatch(List<SysTenantPackageBO> sysTenantPackageList);

    /**
     * 根据主键更新
     * @param sysTenantPackage 系统管理-租户套餐表 实体
     */
    void update(SysTenantPackageBO sysTenantPackage);

    /**
     * 批量更新
     * @param sysTenantPackageList 批量数据
     */
    void updateBatch(List<SysTenantPackageBO> sysTenantPackageList);

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
