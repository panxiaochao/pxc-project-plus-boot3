package io.github.panxiaochao.system.development.domain.repository;

import io.github.panxiaochao.system.development.domain.entity.gentable.GenTableBO;

import java.util.List;

/**
 * <p>代码生成表 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
public interface IGenTableService {

    /**
     * 详情
     * @param id 主键
     * @return 代码生成表 实体
     */
    GenTableBO getById(String id);
    
    /**
     * 保存
     * @param genTable 角色表 实体
     * @return 代码生成表 实体
     */
    GenTableBO save(GenTableBO genTable);

    /**
     * 批量保存
     * @param genTableList 批量数据
     */
    List<GenTableBO> saveBatch(List<GenTableBO> genTableList);
    
    /**
     * 根据主键更新
     * @param genTable 代码生成表 实体
     */
    void update(GenTableBO genTable);

    /**
     * 批量更新
     * @param genTableList 批量数据
     */
    void updateBatch(List<GenTableBO> genTableList);

    /**
     * 根据主键删除
     * @param id 主键
     */
    void deleteById(String id);

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    void deleteByIds(List<String> idList);
}
