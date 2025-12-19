package ${infrastructure}.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import ${application}.api.dto.${entity?lower_case}.${entity}PageQueryDTO;
import ${application}.api.dto.${entity?lower_case}.${entity}QueryDTO;
import ${application}.api.vo.${entity?lower_case}.${entity}QueryVO;
import ${application}.repository.I${entity}ReadModelService;
import ${domain}.entity.${entity?lower_case}.${entity}BO;
import ${domain}.repository.I${entity}Service;
import ${infrastructure}.convert.I${entity}POConvert;
import ${infrastructure}.dao.mapper.${entity}Mapper;
import ${infrastructure}.dao.po.${entity}PO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>${table.comment!} Dao服务实现类.</p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@RequiredArgsConstructor
public class ${table.serviceImplName} implements I${entity}Service, I${entity}ReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final ${table.mapperName} ${table.mapperName?uncap_first};

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO ${table.comment!} 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<${entity}QueryVO> page(Pagination pagination, ${entity}PageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<${entity}PO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<${entity}PO> page = ${entity?uncap_first}Mapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return I${entity}POConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto ${table.comment!} 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<${entity}QueryVO> selectList(${entity}QueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<${entity}PO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return I${entity}POConvert.INSTANCE.toQueryVO(${entity?uncap_first}Mapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto ${table.comment!} 查询请求对象
     * @return ${table.comment!} 查询响应对象
     */
    @Override
    public ${entity}QueryVO getOne(${entity}QueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<${entity}PO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            ${entity}PO ${entity?uncap_first}PO = ${entity?uncap_first}Mapper.selectOne(lqw);
            return I${entity}POConvert.INSTANCE.toQueryVO(${entity?uncap_first}PO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto ${table.comment!} 分页查询请求对象
     * @return ${table.comment!} Lambda表达式查询条件
     */
    private LambdaQueryWrapper<${entity}PO> lambdaQuery(${entity}PageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<${entity}PO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            <#list table.fields as field>
            <#if field.keyFlag>
            // 默认按照主键倒序排序
            lqw.orderByDesc(${entity}PO::get${field.propertyName?cap_first});
            <#-- 普通字段 -->
            <#elseif field.propertyName != logicDeletePropertyName!''>
            // 如果 ${field.comment} 不为空
            <#if field.propertyType="Integer">
            if (pageQueryDto.get${field.propertyName?cap_first}() != null) {
            <#elseif field.propertyType="LocalDateTime">
            if (pageQueryDto.get${field.propertyName?cap_first}() != null) {
            <#elseif field.propertyType="Long">
            if (pageQueryDto.get${field.propertyName?cap_first}() != null) {
            <#elseif field.propertyType="byte[]">
            if (pageQueryDto.get${field.propertyName?cap_first}() != null) {
            <#else>
            if (StringUtils.isNotBlank(pageQueryDto.get${field.propertyName?cap_first}())) {
            </#if>
                lqw.eq(${entity}PO::get${field.propertyName?cap_first}, pageQueryDto.get${field.propertyName?cap_first}());
            }
            </#if>
            </#list>
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return ${entity}BO 实体
     */
    @Override
    public ${entity}BO getById(<#if keyPropertyType="Long">String<#else>${keyPropertyType}</#if> id) {
        ${entity}PO ${entity?uncap_first}PO = ${entity?uncap_first}Mapper.selectById(id);
        return I${entity}POConvert.INSTANCE.toEntityBO(${entity?uncap_first}PO);
    }

    /**
     * 保存 ${table.comment!} 对象
     * @param ${entity?uncap_first} ${entity}BO 实体
     * @return ${entity}BO 实体
     */
    @Override
    public ${entity}BO save(${entity}BO ${entity?uncap_first}) {
        ${entity}PO ${entity?uncap_first}PO = I${entity}POConvert.INSTANCE.fromEntity(${entity?uncap_first});
        ${entity?uncap_first}Mapper.insert(${entity?uncap_first}PO);
        return I${entity}POConvert.INSTANCE.toEntityBO(${entity?uncap_first}PO);
    }

    /**
     * 批量 保存 ${table.comment!} 对象
     * @param ${entity?uncap_first}List 批量数据
     */
    @Override
    public List<${entity}BO> saveBatch(List<${entity}BO> ${entity?uncap_first}List) {
        List<${entity}PO> ${entity?uncap_first}POList = I${entity}POConvert.INSTANCE.fromEntity(${entity?uncap_first}List);
        Db.saveBatch(${entity?uncap_first}POList);
        return I${entity}POConvert.INSTANCE.toEntityBO(${entity?uncap_first}POList);
    }

    /**
     * 根据主键更新
     * @param ${entity?uncap_first} ${entity}BO 实体
     */
    @Override
    public void update(${entity}BO ${entity?uncap_first}) {
        ${entity}PO ${entity?uncap_first}PO = I${entity}POConvert.INSTANCE.fromEntity(${entity?uncap_first});
        ${entity?uncap_first}Mapper.updateById(${entity?uncap_first}PO);
    }

    /**
     * 根据主键 批量更新 ${table.comment!} 对象
     * @param ${entity?uncap_first}List 批量数据
     */
    @Override
    public void updateBatch(List<${entity}BO> ${entity?uncap_first}List) {
    List<${entity}PO> ${entity?uncap_first}POList = I${entity}POConvert.INSTANCE.fromEntity(${entity?uncap_first}List);
        Db.updateBatchById(${entity?uncap_first}POList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(<#if keyPropertyType="Long">String<#else>${keyPropertyType}</#if> id) {
        ${entity?uncap_first}Mapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<<#if keyPropertyType="Long">String<#else>${keyPropertyType}</#if>> idList) {
        ${entity?uncap_first}Mapper.deleteByIds(idList);
    }

}
