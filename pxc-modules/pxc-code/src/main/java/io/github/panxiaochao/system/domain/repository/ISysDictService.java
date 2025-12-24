package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysdict.SysDictBO;

import java.util.List;

/**
 * <p>系统管理-数据字典表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysDictService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-数据字典表 实体
     */
    SysDictBO getById(Integer id);
    
    /**
     * 保存
     * @param sysDict 系统管理-数据字典表 实体
     * @return 系统管理-数据字典表 实体
     */
    SysDictBO save(SysDictBO sysDict);

    /**
     * 批量保存
     * @param sysDictList 批量数据
     */
    List<SysDictBO> saveBatch(List<SysDictBO> sysDictList);
    
    /**
     * 根据主键更新
     * @param sysDict 系统管理-数据字典表 实体
     */
    void update(SysDictBO sysDict);

    /**
     * 批量更新
     * @param sysDictList 批量数据
     */
    void updateBatch(List<SysDictBO> sysDictList);

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
