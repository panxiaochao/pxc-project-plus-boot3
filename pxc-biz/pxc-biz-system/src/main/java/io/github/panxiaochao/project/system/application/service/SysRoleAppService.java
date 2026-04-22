package io.github.panxiaochao.project.system.application.service;

import io.github.panxiaochao.boot3.common.constants.CommonConstant;
import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.common.response.page.PageResponse;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.boot3.component.select.Select;
import io.github.panxiaochao.boot3.component.select.SelectBuilder;
import io.github.panxiaochao.boot3.component.select.SelectOption;
import io.github.panxiaochao.boot3.utils.DictUtil;
import io.github.panxiaochao.project.system.application.api.dto.sysrole.SysRoleCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysrole.SysRolePageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysrole.SysRoleQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysrole.SysRoleUpdateDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysrole.SysRoleQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysrole.SysRoleVO;
import io.github.panxiaochao.project.system.application.convert.ISysRoleDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysRoleReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysrole.SysRoleBO;
import io.github.panxiaochao.project.system.domain.repository.ISysRoleService;
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
 * 系统管理-角色表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysRoleAppService {

    /**
     * 系统管理-角色表 Domain接口服务类
     */
    private final ISysRoleService sysRoleService;

    /**
     * 系统管理-角色表 读模型服务类
     */
    private final ISysRoleReadModelService sysRoleReadModelService;

    /**
     * 数据权限 常量名
     */
    private static final String DATA_SCOPE = "DATA_SCOPE";

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-角色表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysRoleQueryVO> page(SysRolePageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysRoleQueryVO> list = sysRoleReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysRoleVO> getById(Integer id) {
        SysRoleBO sysRole = sysRoleService.getById(id);
        SysRoleVO sysRoleVO = ISysRoleDTOConvert.INSTANCE.toVO(sysRole);
        return R.ok(sysRoleVO);
    }

    /**
     * 保存
     * @param sysRoleCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysRoleVO> save(SysRoleCreateDTO sysRoleCreateDTO) {
        SysRoleBO sysRole = ISysRoleDTOConvert.INSTANCE.fromCreateDTO(sysRoleCreateDTO);
        SysRoleQueryDTO queryRequest = new SysRoleQueryDTO();
        queryRequest.setRoleCode(sysRole.getRoleCode());
        queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
        SysRoleVO one = sysRoleReadModelService.getOne(queryRequest);
        if (Objects.nonNull(one)) {
            return R.fail("角色编码[" + sysRole.getRoleCode() + "]已存在");
        }
        sysRole = sysRoleService.save(sysRole);
        SysRoleVO sysRoleVO = ISysRoleDTOConvert.INSTANCE.toVO(sysRole);
        return R.ok(sysRoleVO);
    }

    /**
     * 根据主键更新
     * @param sysRoleUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysRoleUpdateDTO sysRoleUpdateDTO) {
        SysRoleBO sysRole = ISysRoleDTOConvert.INSTANCE.fromUpdateDTO(sysRoleUpdateDTO);
        sysRoleService.update(sysRole);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysRoleService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysRoleService.deleteByIds(idList);
        return R.ok();
    }

    /**
     * 查询列表
     * @param queryDTO 系统管理-角色表 查询查询请求对象
     * @return 结果数组
     */
    public List<Select<Integer>> listRole(SysRoleQueryDTO queryDTO) {
        queryDTO.setStatus(CommonConstant.STATUS_NORMAL.toString());
        List<SysRoleQueryVO> list = sysRoleReadModelService.selectList(queryDTO);
        List<SelectOption<Integer>> selectOptionList = list.stream()
            .map(m -> SelectOption.of(m.getId(), m.getRoleName(), m.getSort(), (extraMap) -> {
                extraMap.put("label", m.getRoleName());
            }))
            .collect(Collectors.toList());
        List<Select<Integer>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
        return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
    }

    /**
     * 获取数据权限下拉菜单
     * @return 返回通用下拉菜单
     */
    public List<Select<String>> selectDataScopes() {
        Map<String, String> dictMap = DictUtil.getAllDictByDictCode(DATA_SCOPE);
        List<SelectOption<String>> selectOptionList = dictMap.entrySet()
            .stream()
            .map(m -> SelectOption.of(m.getKey(), m.getValue(), m.getValue(),
                    (extraMap) -> extraMap.put("label", m.getValue())))
            .collect(Collectors.toList());
        List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
        return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
    }

}
