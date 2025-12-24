package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysuserauths.SysUserAuthsBO;

import java.util.List;

/**
 * <p>系统管理-用户授权信息表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysUserAuthsService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-用户授权信息表 实体
     */
    SysUserAuthsBO getById(Integer id);
    
    /**
     * 保存
     * @param sysUserAuths 系统管理-用户授权信息表 实体
     * @return 系统管理-用户授权信息表 实体
     */
    SysUserAuthsBO save(SysUserAuthsBO sysUserAuths);

    /**
     * 批量保存
     * @param sysUserAuthsList 批量数据
     */
    List<SysUserAuthsBO> saveBatch(List<SysUserAuthsBO> sysUserAuthsList);
    
    /**
     * 根据主键更新
     * @param sysUserAuths 系统管理-用户授权信息表 实体
     */
    void update(SysUserAuthsBO sysUserAuths);

    /**
     * 批量更新
     * @param sysUserAuthsList 批量数据
     */
    void updateBatch(List<SysUserAuthsBO> sysUserAuthsList);

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
