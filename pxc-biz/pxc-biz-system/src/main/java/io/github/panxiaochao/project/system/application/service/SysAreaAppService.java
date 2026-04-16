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
import io.github.panxiaochao.project.system.application.api.dto.sysarea.SysAreaCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysarea.SysAreaPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysarea.SysAreaUpdateDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysarea.SysAreaQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysarea.SysAreaVO;
import io.github.panxiaochao.project.system.application.convert.ISysAreaDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysAreaReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysarea.SysAreaBO;
import io.github.panxiaochao.project.system.domain.repository.ISysAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统管理-全国5级行政区划 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysAreaAppService {

    /**
     * 系统管理-全国5级行政区划 Domain接口服务类
     */
    private final ISysAreaService sysAreaService;

    /**
     * 系统管理-全国5级行政区划 读模型服务类
     */
    private final ISysAreaReadModelService sysAreaReadModelService;

    /**
     * 区域层级 常量名
     */
    private static final String AREA_LEVEL = "AREA_LEVEL";

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-全国5级行政区划 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysAreaQueryVO> page(SysAreaPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysAreaQueryVO> list = sysAreaReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysAreaVO> getById(String id) {
        SysAreaBO sysArea = sysAreaService.getById(id);
        SysAreaVO sysAreaVO = ISysAreaDTOConvert.INSTANCE.toVO(sysArea);
        return R.ok(sysAreaVO);
    }

    /**
     * 保存
     * @param sysAreaCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysAreaVO> save(SysAreaCreateDTO sysAreaCreateDTO) {
        SysAreaBO sysArea = ISysAreaDTOConvert.INSTANCE.fromCreateDTO(sysAreaCreateDTO);
        sysArea = sysAreaService.save(sysArea);
        SysAreaVO sysAreaVO = ISysAreaDTOConvert.INSTANCE.toVO(sysArea);
        return R.ok(sysAreaVO);
    }

    /**
     * 根据主键更新
     * @param sysAreaUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysAreaUpdateDTO sysAreaUpdateDTO) {
        SysAreaBO sysArea = ISysAreaDTOConvert.INSTANCE.fromUpdateDTO(sysAreaUpdateDTO);
        sysAreaService.update(sysArea);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysAreaService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<String> idList) {
        sysAreaService.deleteByIds(idList);
        return R.ok();
    }

    /**
     * 前2级的区域数据
     * @param areaCode 区域code
     * @return 区域数组
     */
    public List<Tree<String>> listTree(String areaCode) {
        SysAreaPageQueryDTO queryRequest = new SysAreaPageQueryDTO();
        String rootId = CommonConstant.TREE_ROOT_ID.toString();
        // 当区域code不为空的时候，说明是查询下级数据
        if (StringUtils.hasText(areaCode)) {
            // 设置父节点为当前区域code
            queryRequest.setParentCode(areaCode);
            rootId = areaCode;
        }
        else {
            queryRequest.setAreaLevel(2);
        }
        List<TreeNode<String>> treeNodeList = sysAreaReadModelService.listTree(queryRequest)
            .stream()
            .map(sysAreaQueryVO -> TreeNode.of(sysAreaQueryVO.getAreaCode(), sysAreaQueryVO.getParentCode(),
                    sysAreaQueryVO.getAreaName(), sysAreaQueryVO.getSort(), (extraMap) -> {
                        extraMap.put("id", sysAreaQueryVO.getId());
                        extraMap.put("areaCode", sysAreaQueryVO.getAreaCode());
                        extraMap.put("areaLevel", sysAreaQueryVO.getAreaLevel());
                        extraMap.put("cityCode", sysAreaQueryVO.getCityCode());
                        extraMap.put("areaNameEn", sysAreaQueryVO.getAreaNameEn());
                        extraMap.put("areaNameEnAbbr", sysAreaQueryVO.getAreaNameEnAbbr());
                        extraMap.put("longitude", sysAreaQueryVO.getLongitude());
                        extraMap.put("latitude", sysAreaQueryVO.getLatitude());
                        extraMap.put("parentPath", sysAreaQueryVO.getParentPath());
                    }))
            .collect(Collectors.toList());
        // 修改节点属性
        TreeNodeProperties treeNodeProperties = TreeNodeProperties.builder();
        treeNodeProperties.labelKey("areaName");
        // 构建树
        List<Tree<String>> treeList = TreeBuilder.of(rootId, true, treeNodeProperties)
            .append(treeNodeList)
            .fastBuild()
            .toTreeList();
        return CollectionUtils.isEmpty(treeList) ? new ArrayList<>() : treeList;
    }

    /**
     * 获取区域层级下拉菜单
     * @return 返回通用下拉菜单
     */
    public List<Select<Integer>> selectAreaLevels() {
        Map<String, String> dictMap = DictUtil.getAllDictByDictCode(AREA_LEVEL);
        List<SelectOption<Integer>> selectOptionList = dictMap.entrySet()
            .stream()
            .map(m -> SelectOption.of(Integer.valueOf(m.getKey()), m.getValue(), (extraMap) -> {
                extraMap.put("label", m.getValue());
            }))
            .collect(Collectors.toList());
        List<Select<Integer>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
        return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
    }

}
