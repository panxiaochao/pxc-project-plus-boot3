package ${domain}.repository;

import ${domain}.entity.${entity?lower_case}.${entity}BO;

import java.util.List;

/**
 * <p>${table.comment!} Domain接口服务类.</p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface I${entity}Service {

    /**
     * 详情
     * @param id 主键
     * @return ${table.comment!} 实体
     */
    ${entity}BO getById(String id);
    
    /**
     * 保存
     * @param ${entity?uncap_first} 角色表 实体
     * @return ${table.comment!} 实体
     */
    ${entity}BO save(${entity}BO ${entity?uncap_first});

    /**
     * 批量保存
     * @param ${entity?uncap_first}List 批量数据
     */
    List<${entity}BO> saveBatch(List<${entity}BO> ${entity?uncap_first}List);
    
    /**
     * 根据主键更新
     * @param ${entity?uncap_first} ${table.comment!} 实体
     */
    void update(${entity}BO ${entity?uncap_first});

    /**
     * 批量更新
     * @param ${entity?uncap_first}List 批量数据
     */
    void updateBatch(List<${entity}BO> ${entity?uncap_first}List);

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
