package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysdictitem.SysDictItemBO;

import java.util.List;

/**
 * <p>
 * 系统管理-数据字典配置表 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysDictItemService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-数据字典配置表 实体
     */
    SysDictItemBO getById(Integer id);

    /**
     * 保存
     * @param sysDictItem 系统管理-数据字典配置表 实体
     * @return 系统管理-数据字典配置表 实体
     */
    SysDictItemBO save(SysDictItemBO sysDictItem);

    /**
     * 批量保存
     * @param sysDictItemList 批量数据
     */
    List<SysDictItemBO> saveBatch(List<SysDictItemBO> sysDictItemList);

    /**
     * 根据主键更新
     * @param sysDictItem 系统管理-数据字典配置表 实体
     */
    void update(SysDictItemBO sysDictItem);

    /**
     * 批量更新
     * @param sysDictItemList 批量数据
     */
    void updateBatch(List<SysDictItemBO> sysDictItemList);

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
