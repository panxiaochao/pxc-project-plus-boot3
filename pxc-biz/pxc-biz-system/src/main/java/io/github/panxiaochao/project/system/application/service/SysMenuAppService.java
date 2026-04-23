package io.github.panxiaochao.project.system.application.service;

import io.github.panxiaochao.boot3.common.constants.CommonConstant;
import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.common.response.page.PageResponse;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.boot3.component.tree.Tree;
import io.github.panxiaochao.boot3.component.tree.TreeBuilder;
import io.github.panxiaochao.boot3.component.tree.TreeNode;
import io.github.panxiaochao.boot3.component.tree.TreeNodeProperties;
import io.github.panxiaochao.project.common.core.enums.MenuTypeEnum;
import io.github.panxiaochao.project.system.application.api.dto.sysmenu.SysMenuCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysmenu.SysMenuPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysmenu.SysMenuQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysmenu.SysMenuUpdateDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysmenu.SysMenuQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysmenu.SysMenuVO;
import io.github.panxiaochao.project.system.application.convert.ISysMenuDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysMenuReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysmenu.SysMenuBO;
import io.github.panxiaochao.project.system.domain.repository.ISysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统管理-菜单配置 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysMenuAppService {

    /**
     * 系统管理-菜单配置 Domain接口服务类
     */
    private final ISysMenuService sysMenuService;

    /**
     * 系统管理-菜单配置 读模型服务类
     */
    private final ISysMenuReadModelService sysMenuReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-菜单配置 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysMenuQueryVO> page(SysMenuPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysMenuQueryVO> list = sysMenuReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysMenuVO> getById(Integer id) {
        SysMenuBO sysMenu = sysMenuService.getById(id);
        SysMenuVO sysMenuVO = ISysMenuDTOConvert.INSTANCE.toVO(sysMenu);
        return R.ok(sysMenuVO);
    }

    /**
     * 保存
     * @param sysMenuCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysMenuVO> save(SysMenuCreateDTO sysMenuCreateDTO) {
        SysMenuBO sysMenu = ISysMenuDTOConvert.INSTANCE.fromCreateDTO(sysMenuCreateDTO);
        // TODO 判断路由名称是否唯一

        if (MenuTypeEnum.isTopMenu(sysMenu.getMenuType())) {
            sysMenu.setParentId(CommonConstant.TREE_ROOT_ID.intValue());
        }
        sysMenu = sysMenuService.save(sysMenu);
        SysMenuVO sysMenuVO = ISysMenuDTOConvert.INSTANCE.toVO(sysMenu);
        return R.ok(sysMenuVO);
    }

    /**
     * 根据主键更新
     * @param sysMenuUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysMenuUpdateDTO sysMenuUpdateDTO) {
        SysMenuBO sysMenu = ISysMenuDTOConvert.INSTANCE.fromUpdateDTO(sysMenuUpdateDTO);
        sysMenuService.update(sysMenu);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysMenuService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysMenuService.deleteByIds(idList);
        return R.ok();
    }

    /**
     * 获取菜单表格树列表
     * @param menuId 菜单ID
     * @return 树列表
     */
    public List<Tree<Integer>> tableTree(Integer menuId) {
        SysMenuQueryDTO queryRequest = new SysMenuQueryDTO();
        Integer rootId = CommonConstant.TREE_ROOT_ID.intValue();
        // 有数据就说明需要查下级
        if (menuId != null) {
            // 设置父节点为菜单ID
            queryRequest.setParentId(menuId);
            queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
            rootId = menuId;
        }
        List<SysMenuQueryVO> list = sysMenuReadModelService.selectList(queryRequest);
        List<TreeNode<Integer>> treeNodeList = list.stream()
            .map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getMenuName(), s.getSort(), (extraMap) -> {
                extraMap.put("url", s.getUrl());
                extraMap.put("redirectUrl", s.getRedirectUrl());
                extraMap.put("component", s.getComponent());
                extraMap.put("componentName", s.getComponentName());
                extraMap.put("permissionCode", s.getPermissionCode());
                extraMap.put("icon", s.getIcon());
                extraMap.put("menuType", s.getMenuType());
                extraMap.put("openType", s.getOpenType());
                extraMap.put("keepAlive", s.getKeepAlive());
                extraMap.put("sort", s.getSort());
                extraMap.put("isHidden", s.getIsHidden());
                extraMap.put("status", s.getStatus());
            }))
            .collect(Collectors.toList());
        // 修改节点属性
        TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
        treeNodeProperties.labelKey("menuName");
        // 构建树
        List<Tree<Integer>> treeList = TreeBuilder.of(rootId, false, treeNodeProperties)
            .append(treeNodeList)
            .fastBuild()
            .toTreeList();
        return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
    }

    /**
     * 获取菜单树列表
     * @param menuId 菜单ID
     * @param isOnlyMenu 是否只显示菜单，排除按钮
     * @return 树列表
     */
    public List<Tree<Integer>> listTree(Integer menuId, boolean isOnlyMenu) {
        SysMenuQueryDTO queryRequest = new SysMenuQueryDTO();
        Integer rootId = CommonConstant.TREE_ROOT_ID.intValue();
        // 有数据就说明需要查下级
        if (menuId != null) {
            // 设置父节点为菜单ID
            queryRequest.setParentId(menuId);
            queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
            rootId = menuId;
        }
        List<SysMenuQueryVO> list = sysMenuReadModelService.selectList(queryRequest);
        if (isOnlyMenu) {
            // 排除是否需要按钮
            List<String> menuTypeList = Arrays.asList("0", "1");
            list = list.stream().filter(f -> menuTypeList.contains(f.getMenuType())).toList();
        }
        List<TreeNode<Integer>> treeNodeList = list.stream()
            .map(s -> TreeNode.of(s.getId(), s.getParentId(), s.getMenuName(), s.getSort(),
                    (extraMap) -> extraMap.put("value", s.getId())))
            .collect(Collectors.toList());
        // 修改节点属性
        TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
        treeNodeProperties.idKey("key");
        treeNodeProperties.labelKey("title");
        // 构建树
        List<Tree<Integer>> treeList = TreeBuilder.of(rootId, true, treeNodeProperties)
            .append(treeNodeList)
            .fastBuild()
            .toTreeList();
        return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
    }

    /**
     * 获取所有菜单树下拉
     * @return 集合对象数据，包含下拉菜单数据，所有菜单ID集合
     */
    public Map<String, Object> queryAllTree() {
        SysMenuQueryDTO queryRequest = new SysMenuQueryDTO();
        queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
        Integer rootId = CommonConstant.TREE_ROOT_ID.intValue();
        List<SysMenuQueryVO> list = sysMenuReadModelService.selectList(queryRequest);
        // 所有菜单ID结合
        List<Integer> ids = new ArrayList<>();
        List<TreeNode<Integer>> treeNodeList = list.stream().map(s -> {
            // 顺带放入，不要要再多一次循环
            ids.add(s.getId());
            return TreeNode.of(s.getId(), s.getParentId(), s.getMenuName(), s.getSort(),
                    (extraMap) -> extraMap.put("value", s.getId()));
        }).collect(Collectors.toList());
        // 修改节点属性
        TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
        treeNodeProperties.idKey("key");
        treeNodeProperties.labelKey("title");
        // 构建树
        List<Tree<Integer>> treeList = TreeBuilder.of(rootId, true, treeNodeProperties)
            .append(treeNodeList)
            .fastBuild()
            .toTreeList();
        // 输出结果封装
        Map<String, Object> result = new HashMap<>();
        result.put("list", CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList);
        result.put("ids", ids);
        return result;
    }

}
