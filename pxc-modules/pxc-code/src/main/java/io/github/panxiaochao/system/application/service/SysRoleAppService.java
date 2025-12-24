package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRoleCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRolePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRoleUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysrole.SysRoleQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysrole.SysRoleVO;
import io.github.panxiaochao.system.application.convert.ISysRoleDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.sysrole.SysRoleBO;
import io.github.panxiaochao.system.domain.repository.ISysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-角色表 App服务类.</p>
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

}
