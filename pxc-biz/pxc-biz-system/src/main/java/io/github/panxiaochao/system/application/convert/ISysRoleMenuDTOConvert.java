package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysrolemenu.SysRoleMenuCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysrolemenu.SysRoleMenuQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysrolemenu.SysRoleMenuUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysrolemenu.SysRoleMenuQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysrolemenu.SysRoleMenuVO;
import io.github.panxiaochao.system.domain.entity.sysrolemenu.SysRoleMenuBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-角色菜单表 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysRoleMenuDTOConvert {

    /**
     * 系统管理-角色菜单表 数据传输对象结构映射实例
     */
    ISysRoleMenuDTOConvert INSTANCE = Mappers.getMapper(ISysRoleMenuDTOConvert.class);

    /**
     * 系统管理-角色菜单表 创建请求数据传输对象 转 系统管理-角色菜单表 实体
     * @param createDto 系统管理-角色菜单表 创建请求数据传输对象
     * @return 系统管理-角色菜单表 实体
     */
    SysRoleMenuBO fromCreateDTO(SysRoleMenuCreateDTO createDto);

    /**
     * 系统管理-角色菜单表 更新请求数据传输对象 转 系统管理-角色菜单表 实体
     * @param updateDto 系统管理-角色菜单表 更新请求数据传输对象
     * @return 系统管理-角色菜单表 实体
     */
    SysRoleMenuBO fromUpdateDTO(SysRoleMenuUpdateDTO updateDto);

    /**
     * 系统管理-角色菜单表 查询请求数据传输对象 转 系统管理-角色菜单表 实体
     * @param queryDto 系统管理-角色菜单表 查询请求数据传输对象
     * @return 系统管理-角色菜单表 实体
     */
    SysRoleMenuBO fromQueryRequest(SysRoleMenuQueryDTO queryDto);

    /**
     * 系统管理-角色菜单表 实体 转 系统管理-角色菜单表 响应数据传输对象
     * @param sysRoleMenu 系统管理-角色菜单表 实体
     * @return 系统管理-角色菜单表 响应数据传输对象
     */
    SysRoleMenuVO toVO(SysRoleMenuBO sysRoleMenu);

    /**
     * 系统管理-角色菜单表 实体 转 系统管理-角色菜单表 查询响应数据传输对象
     * @param sysRoleMenu 系统管理-角色菜单表 实体
     * @return 系统管理-角色菜单表 查询响应数据传输对象
     */
    SysRoleMenuQueryVO toQueryVO(SysRoleMenuBO sysRoleMenu);

    /**
     * 系统管理-角色菜单表 实体列表 转 系统管理-角色菜单表 查询响应数据传输对象列表
     * @param sysRoleMenuList 系统管理-角色菜单表 实体列表
     * @return 系统管理-角色菜单表 查询响应数据传输对象列表
     */
    List<SysRoleMenuQueryVO> toQueryVO(List<SysRoleMenuBO> sysRoleMenuList);

}
