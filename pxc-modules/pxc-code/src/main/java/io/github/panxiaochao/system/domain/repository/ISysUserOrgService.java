package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysuserorg.SysUserOrgBO;

import java.util.List;

/**
 * <p>系统管理-用户机构/部门表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysUserOrgService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-用户机构/部门表 实体
     */
    SysUserOrgBO getById(Integer id);
    
    /**
     * 保存
     * @param sysUserOrg 系统管理-用户机构/部门表 实体
     * @return 系统管理-用户机构/部门表 实体
     */
    SysUserOrgBO save(SysUserOrgBO sysUserOrg);

    /**
     * 批量保存
     * @param sysUserOrgList 批量数据
     */
    List<SysUserOrgBO> saveBatch(List<SysUserOrgBO> sysUserOrgList);
    
    /**
     * 根据主键更新
     * @param sysUserOrg 系统管理-用户机构/部门表 实体
     */
    void update(SysUserOrgBO sysUserOrg);

    /**
     * 批量更新
     * @param sysUserOrgList 批量数据
     */
    void updateBatch(List<SysUserOrgBO> sysUserOrgList);

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
