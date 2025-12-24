package ${domain}.service;

import ${domain}.entity.${entity?lower_case}.${entity}BO;
import ${domain}.repository.I${entity}Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>${table.comment!} Domain服务类.</p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@RequiredArgsConstructor
public class ${entity}DomainService {

    /**
     * ${table.comment!} Domain接口服务类
     */
    private final I${entity}Service ${entity?uncap_first}Service;

    public ${entity}BO getById(<#if keyPropertyType="Long">String<#else>${keyPropertyType}</#if> id) {
        return ${entity?uncap_first}Service.getById(id);
    }

    public ${entity}BO save(${entity}BO ${entity?uncap_first}) {
        return ${entity?uncap_first}Service.save(${entity?uncap_first});
    }

    public List<${entity}BO> saveBatch(List<${entity}BO> ${entity?uncap_first}List) {
        return ${entity?uncap_first}Service.saveBatch(${entity?uncap_first}List);
    }

    public void update(${entity}BO ${entity?uncap_first}) {
        ${entity?uncap_first}Service.update(${entity?uncap_first});
    }

    public void updateBatch(List<${entity}BO> ${entity?uncap_first}List) {
        ${entity?uncap_first}Service.updateBatch(${entity?uncap_first}List);
    }

    public void deleteById(<#if keyPropertyType="Long">String<#else>${keyPropertyType}</#if> id) {
        ${entity?uncap_first}Service.deleteById(id);
    }

    public void deleteByIds(List<<#if keyPropertyType="Long">String<#else>${keyPropertyType}</#if>> idList) {
        ${entity?uncap_first}Service.deleteByIds(idList);
    }

}
