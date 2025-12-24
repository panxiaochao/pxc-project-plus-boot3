package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysuserpost.SysUserPostBO;

import java.util.List;

/**
 * <p>
 * 系统管理-用户岗位关联表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysUserPostService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-用户岗位关联表 实体
     */
    SysUserPostBO getById(Integer id);

    /**
     * 保存
     * @param sysUserPost 系统管理-用户岗位关联表 实体
     * @return 系统管理-用户岗位关联表 实体
     */
    SysUserPostBO save(SysUserPostBO sysUserPost);

    /**
     * 批量保存
     * @param sysUserPostList 批量数据
     */
    List<SysUserPostBO> saveBatch(List<SysUserPostBO> sysUserPostList);

    /**
     * 根据主键更新
     * @param sysUserPost 系统管理-用户岗位关联表 实体
     */
    void update(SysUserPostBO sysUserPost);

    /**
     * 批量更新
     * @param sysUserPostList 批量数据
     */
    void updateBatch(List<SysUserPostBO> sysUserPostList);

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
