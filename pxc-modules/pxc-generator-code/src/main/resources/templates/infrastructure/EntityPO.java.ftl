package ${infrastructure}.dao.po;

<#list table.importPackages as pkg>
import ${pkg};
</#list>
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>${table.comment!} 持久化对象.</p>
 *
 * @author ${author}
 * @since ${date}
 */
@Getter
@Setter
@TableName("${schemaName}${table.name}")
public class ${entity}PO {
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>

    <#if field.comment!?length gt 0>
    <#if springdoc>
    @Schema(description = "${field.comment}")
    <#elseif swagger>
    @ApiModelProperty("${field.comment}")
    <#else>
    /**
     * ${field.comment}
     */
    </#if>
    </#if>
    <#if field.keyFlag>
    <#-- 主键 -->
    <#if field.keyIdentityFlag>
    @TableId(type = IdType.AUTO)
    <#elseif idType??>
    @TableId(type = IdType.${idType})
    <#elseif field.convert>
    @TableId("${field.annotationColumnName}")
    </#if>
    <#-- 普通字段 -->
    <#elseif field.fill??>
    <#-- -----   存在字段填充设置   ----->
    <#if field.convert>
    @TableField(fill = FieldFill.${field.fill})
    <#else>
    @TableField(fill = FieldFill.${field.fill})
    </#if>
    <#elseif field.convert>
    </#if>
    <#-- 乐观锁注解 -->
    <#if field.versionField>
    @Version
    </#if>
    <#-- 逻辑删除注解 -->
    <#if field.logicDeleteField>
    @TableLogic
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
}
