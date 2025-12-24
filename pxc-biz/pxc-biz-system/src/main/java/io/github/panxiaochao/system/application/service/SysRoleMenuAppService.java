package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysrolemenu.SysRoleMenuCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysrolemenu.SysRoleMenuPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysrolemenu.SysRoleMenuUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysrolemenu.SysRoleMenuQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysrolemenu.SysRoleMenuVO;
import io.github.panxiaochao.system.application.convert.ISysRoleMenuDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysRoleMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.sysrolemenu.SysRoleMenuBO;
import io.github.panxiaochao.system.domain.repository.ISysRoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-角色菜单表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysRoleMenuAppService {

    /**
     * 系统管理-角色菜单表 Domain接口服务类
     */
    private final ISysRoleMenuService sysRoleMenuService;

    /**
     * 系统管理-角色菜单表 读模型服务类
     */
    private final ISysRoleMenuReadModelService sysRoleMenuReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-角色菜单表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysRoleMenuQueryVO> page(SysRoleMenuPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysRoleMenuQueryVO> list = sysRoleMenuReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysRoleMenuVO> getById(Integer id) {
        SysRoleMenuBO sysRoleMenu = sysRoleMenuService.getById(id);
        SysRoleMenuVO sysRoleMenuVO = ISysRoleMenuDTOConvert.INSTANCE.toVO(sysRoleMenu);
        return R.ok(sysRoleMenuVO);
    }

    /**
     * 保存
     * @param sysRoleMenuCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysRoleMenuVO> save(SysRoleMenuCreateDTO sysRoleMenuCreateDTO) {
        SysRoleMenuBO sysRoleMenu = ISysRoleMenuDTOConvert.INSTANCE.fromCreateDTO(sysRoleMenuCreateDTO);
        sysRoleMenu = sysRoleMenuService.save(sysRoleMenu);
        SysRoleMenuVO sysRoleMenuVO = ISysRoleMenuDTOConvert.INSTANCE.toVO(sysRoleMenu);
        return R.ok(sysRoleMenuVO);
    }

    /**
     * 根据主键更新
     * @param sysRoleMenuUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysRoleMenuUpdateDTO sysRoleMenuUpdateDTO) {
        SysRoleMenuBO sysRoleMenu = ISysRoleMenuDTOConvert.INSTANCE.fromUpdateDTO(sysRoleMenuUpdateDTO);
        sysRoleMenuService.update(sysRoleMenu);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysRoleMenuService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysRoleMenuService.deleteByIds(idList);
        return R.ok();
    }

}
