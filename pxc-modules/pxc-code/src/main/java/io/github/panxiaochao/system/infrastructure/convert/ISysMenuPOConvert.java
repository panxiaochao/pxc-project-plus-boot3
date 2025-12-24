package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysmenu.SysMenuQueryVO;
import io.github.panxiaochao.system.domain.entity.sysmenu.SysMenuBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysMenuPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-菜单配置 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysMenuPOConvert {

    /**
     * 系统管理-菜单配置 持久化对象结构映射实例
     */
    ISysMenuPOConvert INSTANCE = Mappers.getMapper(ISysMenuPOConvert.class);

    /**
     * 系统管理-菜单配置 实体 转 系统管理-菜单配置 持久化对象
     * @param sysMenu 系统管理-菜单配置 实体
     * @return 系统管理-菜单配置 持久化对象
     */
    SysMenuPO fromEntity(SysMenuBO sysMenu);

    /**
     * 系统管理-菜单配置 实体 转 系统管理-菜单配置 持久化对象
     * @param sysMenuList 系统管理-菜单配置 实体
     * @return 系统管理-菜单配置 持久化对象
     */
    List<SysMenuPO> fromEntity(List<SysMenuBO> sysMenuList);

    /**
     * 系统管理-菜单配置 持久化对象 转 系统管理-菜单配置 实体
     * @param sysMenuPO 系统管理-菜单配置 持久化对象
     * @return 系统管理-菜单配置 实体
     */
    SysMenuBO toEntityBO(SysMenuPO sysMenuPO);

    /**
     * 系统管理-菜单配置 持久化对象 转 系统管理-菜单配置 实体
     * @param sysMenuPOList 系统管理-菜单配置 持久化对象
     * @return 系统管理-菜单配置 实体
     */
    List<SysMenuBO> toEntityBO(List<SysMenuPO> sysMenuPOList);

    /**
     * 系统管理-菜单配置 持久化对象 转 系统管理-菜单配置 查询响应数据传输对象
     * @param sysMenuPO 系统管理-菜单配置 持久化对象
     * @return 系统管理-菜单配置 查询响应数据传输对象
     */
    SysMenuQueryVO toQueryVO(SysMenuPO sysMenuPO);

    /**
     * 系统管理-菜单配置 持久化对象列表 转 系统管理-菜单配置 查询响应数据传输对象列表
     * @param sysMenuPOList 系统管理-菜单配置 持久化对象列表
     * @return 系统管理-菜单配置 查询响应数据传输对象列表
     */
    List<SysMenuQueryVO> toQueryVO(List<SysMenuPO> sysMenuPOList);

}
