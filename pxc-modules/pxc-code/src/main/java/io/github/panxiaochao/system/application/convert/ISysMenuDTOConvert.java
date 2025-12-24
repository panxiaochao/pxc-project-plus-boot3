package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysmenu.SysMenuCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysmenu.SysMenuQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysmenu.SysMenuUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysmenu.SysMenuQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysmenu.SysMenuVO;
import io.github.panxiaochao.system.domain.entity.sysmenu.SysMenuBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-菜单配置 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysMenuDTOConvert {

    /**
     * 系统管理-菜单配置 数据传输对象结构映射实例
     */
    ISysMenuDTOConvert INSTANCE = Mappers.getMapper(ISysMenuDTOConvert.class);

    /**
     * 系统管理-菜单配置 创建请求数据传输对象 转 系统管理-菜单配置 实体
     *
     * @param createDto 系统管理-菜单配置 创建请求数据传输对象
     * @return 系统管理-菜单配置 实体
     */
    SysMenuBO fromCreateDTO(SysMenuCreateDTO createDto);

    /**
     * 系统管理-菜单配置 更新请求数据传输对象 转 系统管理-菜单配置 实体
     *
     * @param updateDto 系统管理-菜单配置 更新请求数据传输对象
     * @return 系统管理-菜单配置 实体
     */
    SysMenuBO fromUpdateDTO(SysMenuUpdateDTO updateDto);

    /**
     * 系统管理-菜单配置 查询请求数据传输对象 转 系统管理-菜单配置 实体
     *
     * @param queryDto 系统管理-菜单配置 查询请求数据传输对象
     * @return 系统管理-菜单配置 实体
     */
    SysMenuBO fromQueryRequest(SysMenuQueryDTO queryDto);

    /**
     * 系统管理-菜单配置 实体 转 系统管理-菜单配置 响应数据传输对象
     *
     * @param sysMenu 系统管理-菜单配置 实体
     * @return 系统管理-菜单配置 响应数据传输对象
     */
    SysMenuVO toVO(SysMenuBO sysMenu);

    /**
     * 系统管理-菜单配置 实体 转 系统管理-菜单配置 查询响应数据传输对象
     *
     * @param sysMenu 系统管理-菜单配置 实体
     * @return 系统管理-菜单配置 查询响应数据传输对象
     */
    SysMenuQueryVO toQueryVO(SysMenuBO sysMenu);

    /**
     * 系统管理-菜单配置 实体列表 转 系统管理-菜单配置 查询响应数据传输对象列表
     *
     * @param sysMenuList 系统管理-菜单配置 实体列表
     * @return 系统管理-菜单配置 查询响应数据传输对象列表
     */
    List<SysMenuQueryVO> toQueryVO(List<SysMenuBO> sysMenuList);
}
