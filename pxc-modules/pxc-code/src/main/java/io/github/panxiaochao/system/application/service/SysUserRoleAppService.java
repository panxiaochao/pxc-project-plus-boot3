package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserrole.SysUserRoleCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserrole.SysUserRolePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserrole.SysUserRoleUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserrole.SysUserRoleQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserrole.SysUserRoleVO;
import io.github.panxiaochao.system.application.convert.ISysUserRoleDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuserrole.SysUserRoleBO;
import io.github.panxiaochao.system.domain.repository.ISysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @return 返回保存对象
     */
    public R<SysUserRoleVO> save(SysUserRoleCreateDTO sysUserRoleCreateDTO) {
        SysUserRoleBO sysUserRole = ISysUserRoleDTOConvert.INSTANCE.fromCreateDTO(sysUserRoleCreateDTO);
        sysUserRole = sysUserRoleService.save(sysUserRole);
        SysUserRoleVO sysUserRoleVO = ISysUserRoleDTOConvert.INSTANCE.toVO(sysUserRole);
        return R.ok(sysUserRoleVO);
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

}
