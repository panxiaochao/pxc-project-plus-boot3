package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenantpackagemenu.SysTenantPackageMenuQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenantpackagemenu.SysTenantPackageMenuVO;
import io.github.panxiaochao.system.domain.entity.systenantpackagemenu.SysTenantPackageMenuBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-租户套餐菜单表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysTenantPackageMenuDTOConvert {

    /**
     * 系统管理-租户套餐菜单表 数据传输对象结构映射实例
     */
    ISysTenantPackageMenuDTOConvert INSTANCE = Mappers.getMapper(ISysTenantPackageMenuDTOConvert.class);

    /**
     * 系统管理-租户套餐菜单表 创建请求数据传输对象 转 系统管理-租户套餐菜单表 实体
     *
     * @param createDto 系统管理-租户套餐菜单表 创建请求数据传输对象
     * @return 系统管理-租户套餐菜单表 实体
     */
    SysTenantPackageMenuBO fromCreateDTO(SysTenantPackageMenuCreateDTO createDto);

    /**
     * 系统管理-租户套餐菜单表 更新请求数据传输对象 转 系统管理-租户套餐菜单表 实体
     *
     * @param updateDto 系统管理-租户套餐菜单表 更新请求数据传输对象
     * @return 系统管理-租户套餐菜单表 实体
     */
    SysTenantPackageMenuBO fromUpdateDTO(SysTenantPackageMenuUpdateDTO updateDto);

    /**
     * 系统管理-租户套餐菜单表 查询请求数据传输对象 转 系统管理-租户套餐菜单表 实体
     *
     * @param queryDto 系统管理-租户套餐菜单表 查询请求数据传输对象
     * @return 系统管理-租户套餐菜单表 实体
     */
    SysTenantPackageMenuBO fromQueryRequest(SysTenantPackageMenuQueryDTO queryDto);

    /**
     * 系统管理-租户套餐菜单表 实体 转 系统管理-租户套餐菜单表 响应数据传输对象
     *
     * @param sysTenantPackageMenu 系统管理-租户套餐菜单表 实体
     * @return 系统管理-租户套餐菜单表 响应数据传输对象
     */
    SysTenantPackageMenuVO toVO(SysTenantPackageMenuBO sysTenantPackageMenu);

    /**
     * 系统管理-租户套餐菜单表 实体 转 系统管理-租户套餐菜单表 查询响应数据传输对象
     *
     * @param sysTenantPackageMenu 系统管理-租户套餐菜单表 实体
     * @return 系统管理-租户套餐菜单表 查询响应数据传输对象
     */
    SysTenantPackageMenuQueryVO toQueryVO(SysTenantPackageMenuBO sysTenantPackageMenu);

    /**
     * 系统管理-租户套餐菜单表 实体列表 转 系统管理-租户套餐菜单表 查询响应数据传输对象列表
     *
     * @param sysTenantPackageMenuList 系统管理-租户套餐菜单表 实体列表
     * @return 系统管理-租户套餐菜单表 查询响应数据传输对象列表
     */
    List<SysTenantPackageMenuQueryVO> toQueryVO(List<SysTenantPackageMenuBO> sysTenantPackageMenuList);
}
