package io.github.panxiaochao.project.system.application.service;

import io.github.panxiaochao.boot3.common.constants.CommonConstant;
import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.common.response.page.PageResponse;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.boot3.component.select.Select;
import io.github.panxiaochao.boot3.component.select.SelectBuilder;
import io.github.panxiaochao.boot3.component.select.SelectOption;
import io.github.panxiaochao.boot3.component.tree.Tree;
import io.github.panxiaochao.boot3.component.tree.TreeBuilder;
import io.github.panxiaochao.boot3.component.tree.TreeNode;
import io.github.panxiaochao.boot3.component.tree.TreeNodeProperties;
import io.github.panxiaochao.boot3.utils.DictUtil;
import io.github.panxiaochao.project.system.application.api.dto.sysorg.SysOrgCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysorg.SysOrgPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysorg.SysOrgQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysorg.SysOrgUpdateDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysorg.SysOrgQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysorg.SysOrgVO;
import io.github.panxiaochao.project.system.application.convert.ISysOrgDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysOrgReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysorg.SysOrgBO;
import io.github.panxiaochao.project.system.domain.repository.ISysOrgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统管理-机构部门表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysOrgAppService {

    /**
     * 系统管理-机构部门表 Domain接口服务类
     */
    private final ISysOrgService sysOrgService;

    /**
     * 系统管理-机构部门表 读模型服务类
     */
    private final ISysOrgReadModelService sysOrgReadModelService;

    /**
     * 机构类别 常量名
     */
    private static final String ORG_CATEGORY = "ORG_CATEGORY";

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-机构部门表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysOrgQueryVO> page(SysOrgPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysOrgQueryVO> list = sysOrgReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysOrgVO> getById(Integer id) {
        SysOrgBO sysOrg = sysOrgService.getById(id);
        SysOrgVO sysOrgVO = ISysOrgDTOConvert.INSTANCE.toVO(sysOrg);
        return R.ok(sysOrgVO);
    }

    /**
     * 保存
     * @param sysOrgCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysOrgVO> save(SysOrgCreateDTO sysOrgCreateDTO) {
        SysOrgBO sysOrg = ISysOrgDTOConvert.INSTANCE.fromCreateDTO(sysOrgCreateDTO);
        SysOrgQueryDTO queryRequest = new SysOrgQueryDTO();
        queryRequest.setOrgCode(sysOrg.getOrgCode());
        queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
        SysOrgVO one = sysOrgReadModelService.getOne(queryRequest);
        if (Objects.nonNull(one)) {
            return R.fail("机构编码[" + sysOrg.getOrgCode() + "]已存在");
        }
        sysOrg = sysOrgService.save(sysOrg);
        SysOrgVO sysOrgVO = ISysOrgDTOConvert.INSTANCE.toVO(sysOrg);
        return R.ok(sysOrgVO);
    }

    /**
     * 根据主键更新
     * @param sysOrgUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysOrgUpdateDTO sysOrgUpdateDTO) {
        SysOrgBO sysOrg = ISysOrgDTOConvert.INSTANCE.fromUpdateDTO(sysOrgUpdateDTO);
        sysOrgService.update(sysOrg);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        SysOrgQueryDTO queryRequest = new SysOrgQueryDTO();
        queryRequest.setParentId(id);
        List<SysOrgQueryVO> list = sysOrgReadModelService.selectList(queryRequest);
        if (CollectionUtils.isEmpty(list)) {
            sysOrgService.deleteById(id);
        }
        else {
            return R.fail("存在下级级联数据，请删除！");
        }
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysOrgService.deleteByIds(idList);
        return R.ok();
    }

    /**
     * 组织树列表
     * @param rootId 根节点
     * @return 树列表
     */
    public List<Tree<Integer>> listTree(Integer rootId) {
        SysOrgQueryDTO queryRequest = new SysOrgQueryDTO();
        if (rootId != null) {
            queryRequest.setParentId(rootId);
        }
        else {
            rootId = CommonConstant.TREE_ROOT_ID.intValue();
        }
        queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
        List<TreeNode<Integer>> treeNodeList = sysOrgReadModelService.selectList(queryRequest)
            .stream()
            .map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getOrgName(), s.getSort(),
                    (extraMap) -> extraMap.put("value", s.getId())))
            .collect(Collectors.toList());
        // 修改节点属性
        TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
        treeNodeProperties.labelKey("title");
        treeNodeProperties.idKey("key");
        // 构建树
        List<Tree<Integer>> treeList = TreeBuilder.of(rootId, true, treeNodeProperties)
            .append(treeNodeList)
            .fastBuild()
            .toTreeList();
        return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
    }

    /**
     * 获取机构表格树列表
     * @param orgId 菜单ID
     * @return 树列表
     */
    public List<Tree<Integer>> tableTree(Integer orgId) {
        SysOrgQueryDTO queryRequest = new SysOrgQueryDTO();
        Integer rootId = CommonConstant.TREE_ROOT_ID.intValue();
        // 有数据就说明需要查下级
        if (orgId != null) {
            // 设置父节点为菜单ID
            queryRequest.setParentId(orgId);
            queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
            rootId = orgId;
        }
        List<SysOrgQueryVO> list = sysOrgReadModelService.selectList(queryRequest);
        List<TreeNode<Integer>> treeNodeList = list.stream()
            .map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getOrgName(), s.getSort(), (extraMap) -> {
                extraMap.put("areaId", s.getAreaId());
                extraMap.put("areaCode", s.getAreaCode());
                extraMap.put("orgNameEn", s.getOrgNameEn());
                extraMap.put("orgNameAbbr", s.getOrgNameAbbr());
                extraMap.put("orgCode", s.getOrgCode());
                extraMap.put("sort", s.getSort());
                extraMap.put("orgCategory", s.getOrgCategory());
                extraMap.put("orgCategoryStr",
                        s.getOrgCategory() != null ? DictUtil.getDictValue(ORG_CATEGORY, s.getOrgCategory()) : "");
                extraMap.put("mobile", s.getMobile());
                extraMap.put("fax", s.getFax());
                extraMap.put("address", s.getAddress());
                extraMap.put("status", s.getStatus());
                extraMap.put("remark", s.getRemark());
            }))
            .collect(Collectors.toList());
        // 修改节点属性
        TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
        treeNodeProperties.labelKey("orgName");
        // 构建树
        List<Tree<Integer>> treeList = TreeBuilder.of(rootId, false, treeNodeProperties)
            .append(treeNodeList)
            .fastBuild()
            .toTreeList();
        return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
    }

    /**
     * 获取机构类别下拉
     */
    public List<Select<String>> selectOrgCategoryList() {
        Map<String, String> dictMap = DictUtil.getAllDictByDictCode(ORG_CATEGORY);
        List<SelectOption<String>> selectOptionList = dictMap.entrySet()
            .stream()
            .map(m -> SelectOption.of(m.getKey(), m.getValue(), m.getValue(),
                    (extraMap) -> extraMap.put("label", m.getValue())))
            .collect(Collectors.toList());
        List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
        return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
    }

    /**
     * 获取机构列表
     * @param orgId 菜单ID
     * @return 列表
     */
    public List<SysOrgQueryVO> list(Integer orgId) {
        SysOrgQueryDTO queryRequest = new SysOrgQueryDTO();
        // 有数据就说明需要查下级
        if (orgId != null) {
            queryRequest.setParentId(orgId);
        }
        queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
        List<SysOrgQueryVO> list = sysOrgReadModelService.selectList(queryRequest);
        list.forEach(s -> {
            s.setOrgCategoryStr(
                    s.getOrgCategory() != null ? DictUtil.getDictValue(ORG_CATEGORY, s.getOrgCategory()) : "");
        });
        return list;
    }

}
