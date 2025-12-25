package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.systenant.SysTenantBO;

import java.util.List;

/**
 * <p>
 * 系统管理-租户表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysTenantService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-租户表 实体
     */
    SysTenantBO getById(Integer id);

    /**
     * 保存
     * @param sysTenant 系统管理-租户表 实体
     * @return 系统管理-租户表 实体
     */
    SysTenantBO save(SysTenantBO sysTenant);

    /**
     * 批量保存
     * @param sysTenantList 批量数据
     */
    List<SysTenantBO> saveBatch(List<SysTenantBO> sysTenantList);

    /**
     * 根据主键更新
     * @param sysTenant 系统管理-租户表 实体
     */
    void update(SysTenantBO sysTenant);

    /**
     * 批量更新
     * @param sysTenantList 批量数据
     */
    void updateBatch(List<SysTenantBO> sysTenantList);

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
