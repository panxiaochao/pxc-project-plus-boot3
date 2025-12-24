package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysorg.SysOrgBO;

import java.util.List;

/**
 * <p>
 * 系统管理-机构部门表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysOrgService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-机构部门表 实体
     */
    SysOrgBO getById(Integer id);

    /**
     * 保存
     * @param sysOrg 系统管理-机构部门表 实体
     * @return 系统管理-机构部门表 实体
     */
    SysOrgBO save(SysOrgBO sysOrg);

    /**
     * 批量保存
     * @param sysOrgList 批量数据
     */
    List<SysOrgBO> saveBatch(List<SysOrgBO> sysOrgList);

    /**
     * 根据主键更新
     * @param sysOrg 系统管理-机构部门表 实体
     */
    void update(SysOrgBO sysOrg);

    /**
     * 批量更新
     * @param sysOrgList 批量数据
     */
    void updateBatch(List<SysOrgBO> sysOrgList);

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
