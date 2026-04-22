package io.github.panxiaochao.project.system.application.service;

import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.common.response.page.PageResponse;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.boot3.utils.StringPools;
import io.github.panxiaochao.project.system.application.api.dto.sysuserrole.SysUserRoleCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuserrole.SysUserRolePageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuserrole.SysUserRoleQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuserrole.SysUserRoleUpdateDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysuserrole.SysUserRoleQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysuserrole.SysUserRoleVO;
import io.github.panxiaochao.project.system.application.convert.ISysUserRoleDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysUserRoleReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysuserrole.SysUserRoleBO;
import io.github.panxiaochao.project.system.domain.repository.ISysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统管理-用户角色表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleAppService {

    /**
     * 系统管理-用户角色表 Domain接口服务类
     */
    private final ISysUserRoleService sysUserRoleService;

    /**
     * 系统管理-用户角色表 读模型服务类
     */
    private final ISysUserRoleReadModelService sysUserRoleReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-用户角色表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserRoleQueryVO> page(SysUserRolePageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysUserRoleQueryVO> list = sysUserRoleReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysUserRoleVO> getById(Integer id) {
        SysUserRoleBO sysUserRole = sysUserRoleService.getById(id);
        SysUserRoleVO sysUserRoleVO = ISysUserRoleDTOConvert.INSTANCE.toVO(sysUserRole);
        return R.ok(sysUserRoleVO);
    }

    /**
     * 保存
     * @param sysUserRoleCreateDTO 创建请求对象
     */
    public void save(SysUserRoleCreateDTO sysUserRoleCreateDTO) {
        if (StringUtils.hasText(sysUserRoleCreateDTO.getRoleId())) {
            // 以,分割roleId为字符串数组
            String[] roleIds = StringUtils.tokenizeToStringArray(sysUserRoleCreateDTO.getRoleId(), StringPools.COMMA);
            List<SysUserRoleBO> list = Arrays.stream(roleIds)
                .map(roleId -> new SysUserRoleBO(sysUserRoleCreateDTO.getUserId(), Integer.parseInt(roleId)))
                .collect(Collectors.toList());
            // 先删除当前用户的所有关联数据
            sysUserRoleService.deleteByUserId(Collections.singletonList(sysUserRoleCreateDTO.getUserId()));
            // 批量保存当前用户的最新关联数据
            sysUserRoleService.saveBatch(list);
        }
        else {
            // 角色ID为空，说明是删除全部
            sysUserRoleService.deleteByUserId(Collections.singletonList(sysUserRoleCreateDTO.getUserId()));
        }
    }

    /**
     * 根据主键更新
     * @param sysUserRoleUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysUserRoleUpdateDTO sysUserRoleUpdateDTO) {
        SysUserRoleBO sysUserRole = ISysUserRoleDTOConvert.INSTANCE.fromUpdateDTO(sysUserRoleUpdateDTO);
        sysUserRoleService.update(sysUserRole);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysUserRoleService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysUserRoleService.deleteByIds(idList);
        return R.ok();
    }

    /**
     * 角色ID数组
     * @param userId 用户ID
     * @return 角色ID数组
     */
    public List<Integer> rolesByUserId(Integer userId) {
        SysUserRoleQueryDTO queryRequest = new SysUserRoleQueryDTO();
        queryRequest.setUserId(userId);
        List<SysUserRoleQueryVO> list = sysUserRoleReadModelService.selectList(queryRequest);
        if (!CollectionUtils.isEmpty(list)) {
            return list.stream().map(SysUserRoleQueryVO::getRoleId).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}
