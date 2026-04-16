package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysrolemenu.SysRoleMenuPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysrolemenu.SysRoleMenuQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysrolemenu.SysRoleMenuVO;

import java.util.List;

/**
 * <p>
 * 系统管理-角色菜单表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysRoleMenuReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-角色菜单表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysRoleMenuQueryVO> page(Pagination pagination, SysRoleMenuPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-角色菜单表 查询请求对象数组
     * @return 系统管理-角色菜单表 结果数组
     */
    List<SysRoleMenuQueryVO> selectList(SysRoleMenuPageQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-角色菜单表 请求对象
     * @return 系统管理-角色菜单表 对象
     */
    SysRoleMenuVO getOne(SysRoleMenuPageQueryDTO queryDto);

}
