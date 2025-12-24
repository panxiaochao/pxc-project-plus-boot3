package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysrolemenu.SysRoleMenuQueryVO;
import io.github.panxiaochao.system.domain.entity.sysrolemenu.SysRoleMenuBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysRoleMenuPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-角色菜单表 持久化对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysRoleMenuPOConvert {

    /**
     * 系统管理-角色菜单表 持久化对象结构映射实例
     */
    ISysRoleMenuPOConvert INSTANCE = Mappers.getMapper(ISysRoleMenuPOConvert.class);

    /**
     * 系统管理-角色菜单表 实体 转 系统管理-角色菜单表 持久化对象
     * @param sysRoleMenu 系统管理-角色菜单表 实体
     * @return 系统管理-角色菜单表 持久化对象
     */
    SysRoleMenuPO fromEntity(SysRoleMenuBO sysRoleMenu);

    /**
     * 系统管理-角色菜单表 实体 转 系统管理-角色菜单表 持久化对象
     * @param sysRoleMenuList 系统管理-角色菜单表 实体
     * @return 系统管理-角色菜单表 持久化对象
     */
    List<SysRoleMenuPO> fromEntity(List<SysRoleMenuBO> sysRoleMenuList);

    /**
     * 系统管理-角色菜单表 持久化对象 转 系统管理-角色菜单表 实体
     * @param sysRoleMenuPO 系统管理-角色菜单表 持久化对象
     * @return 系统管理-角色菜单表 实体
     */
    SysRoleMenuBO toEntityBO(SysRoleMenuPO sysRoleMenuPO);

    /**
     * 系统管理-角色菜单表 持久化对象 转 系统管理-角色菜单表 实体
     * @param sysRoleMenuPOList 系统管理-角色菜单表 持久化对象
     * @return 系统管理-角色菜单表 实体
     */
    List<SysRoleMenuBO> toEntityBO(List<SysRoleMenuPO> sysRoleMenuPOList);

    /**
     * 系统管理-角色菜单表 持久化对象 转 系统管理-角色菜单表 查询响应数据传输对象
     * @param sysRoleMenuPO 系统管理-角色菜单表 持久化对象
     * @return 系统管理-角色菜单表 查询响应数据传输对象
     */
    SysRoleMenuQueryVO toQueryVO(SysRoleMenuPO sysRoleMenuPO);

    /**
     * 系统管理-角色菜单表 持久化对象列表 转 系统管理-角色菜单表 查询响应数据传输对象列表
     * @param sysRoleMenuPOList 系统管理-角色菜单表 持久化对象列表
     * @return 系统管理-角色菜单表 查询响应数据传输对象列表
     */
    List<SysRoleMenuQueryVO> toQueryVO(List<SysRoleMenuPO> sysRoleMenuPOList);
}
