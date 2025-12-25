package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.syspost.SysPostBO;

import java.util.List;

/**
 * <p>
 * 系统管理-岗位表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysPostService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-岗位表 实体
     */
    SysPostBO getById(Integer id);

    /**
     * 保存
     * @param sysPost 系统管理-岗位表 实体
     * @return 系统管理-岗位表 实体
     */
    SysPostBO save(SysPostBO sysPost);

    /**
     * 批量保存
     * @param sysPostList 批量数据
     */
    List<SysPostBO> saveBatch(List<SysPostBO> sysPostList);

    /**
     * 根据主键更新
     * @param sysPost 系统管理-岗位表 实体
     */
    void update(SysPostBO sysPost);

    /**
     * 批量更新
     * @param sysPostList 批量数据
     */
    void updateBatch(List<SysPostBO> sysPostList);

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
