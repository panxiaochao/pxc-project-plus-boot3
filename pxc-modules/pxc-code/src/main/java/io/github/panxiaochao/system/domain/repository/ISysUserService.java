package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysuser.SysUserBO;

import java.util.List;

/**
 * <p>系统管理-用户表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysUserService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-用户表 实体
     */
    SysUserBO getById(Integer id);
    
    /**
     * 保存
     * @param sysUser 系统管理-用户表 实体
     * @return 系统管理-用户表 实体
     */
    SysUserBO save(SysUserBO sysUser);

    /**
     * 批量保存
     * @param sysUserList 批量数据
     */
    List<SysUserBO> saveBatch(List<SysUserBO> sysUserList);
    
    /**
     * 根据主键更新
     * @param sysUser 系统管理-用户表 实体
     */
    void update(SysUserBO sysUser);

    /**
     * 批量更新
     * @param sysUserList 批量数据
     */
    void updateBatch(List<SysUserBO> sysUserList);

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
