package ${infrastructure}.dao.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import ${infrastructure}.dao.po.${entity}PO;
<#if mapperAnnotationClass??>
import ${mapperAnnotationClass.name};
</#if>

/**
 * <p>${table.comment!} 持久化接口.</p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if mapperAnnotationClass??>
@${mapperAnnotationClass.simpleName}
</#if>
public interface ${table.mapperName} extends MPJBaseMapper<${entity}PO> {

}
