package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.systenantuser.SysTenantUserBO;

import java.util.List;

/**
 * <p>
 * 系统管理-租户用户表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysTenantUserService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-租户用户表 实体
     */
    SysTenantUserBO getById(Integer id);

    /**
     * 保存
     * @param sysTenantUser 系统管理-租户用户表 实体
     * @return 系统管理-租户用户表 实体
     */
    SysTenantUserBO save(SysTenantUserBO sysTenantUser);

    /**
     * 批量保存
     * @param sysTenantUserList 批量数据
     */
    List<SysTenantUserBO> saveBatch(List<SysTenantUserBO> sysTenantUserList);

    /**
     * 根据主键更新
     * @param sysTenantUser 系统管理-租户用户表 实体
     */
    void update(SysTenantUserBO sysTenantUser);

    /**
     * 批量更新
     * @param sysTenantUserList 批量数据
     */
    void updateBatch(List<SysTenantUserBO> sysTenantUserList);

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
