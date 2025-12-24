package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.systenantpackagemenu.SysTenantPackageMenuQueryVO;
import io.github.panxiaochao.system.domain.entity.systenantpackagemenu.SysTenantPackageMenuBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysTenantPackageMenuPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-租户套餐菜单表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysTenantPackageMenuPOConvert {

    /**
     * 系统管理-租户套餐菜单表 持久化对象结构映射实例
     */
    ISysTenantPackageMenuPOConvert INSTANCE = Mappers.getMapper(ISysTenantPackageMenuPOConvert.class);

    /**
     * 系统管理-租户套餐菜单表 实体 转 系统管理-租户套餐菜单表 持久化对象
     * @param sysTenantPackageMenu 系统管理-租户套餐菜单表 实体
     * @return 系统管理-租户套餐菜单表 持久化对象
     */
    SysTenantPackageMenuPO fromEntity(SysTenantPackageMenuBO sysTenantPackageMenu);

    /**
     * 系统管理-租户套餐菜单表 实体 转 系统管理-租户套餐菜单表 持久化对象
     * @param sysTenantPackageMenuList 系统管理-租户套餐菜单表 实体
     * @return 系统管理-租户套餐菜单表 持久化对象
     */
    List<SysTenantPackageMenuPO> fromEntity(List<SysTenantPackageMenuBO> sysTenantPackageMenuList);

    /**
     * 系统管理-租户套餐菜单表 持久化对象 转 系统管理-租户套餐菜单表 实体
     * @param sysTenantPackageMenuPO 系统管理-租户套餐菜单表 持久化对象
     * @return 系统管理-租户套餐菜单表 实体
     */
    SysTenantPackageMenuBO toEntityBO(SysTenantPackageMenuPO sysTenantPackageMenuPO);

    /**
     * 系统管理-租户套餐菜单表 持久化对象 转 系统管理-租户套餐菜单表 实体
     * @param sysTenantPackageMenuPOList 系统管理-租户套餐菜单表 持久化对象
     * @return 系统管理-租户套餐菜单表 实体
     */
    List<SysTenantPackageMenuBO> toEntityBO(List<SysTenantPackageMenuPO> sysTenantPackageMenuPOList);

    /**
     * 系统管理-租户套餐菜单表 持久化对象 转 系统管理-租户套餐菜单表 查询响应数据传输对象
     * @param sysTenantPackageMenuPO 系统管理-租户套餐菜单表 持久化对象
     * @return 系统管理-租户套餐菜单表 查询响应数据传输对象
     */
    SysTenantPackageMenuQueryVO toQueryVO(SysTenantPackageMenuPO sysTenantPackageMenuPO);

    /**
     * 系统管理-租户套餐菜单表 持久化对象列表 转 系统管理-租户套餐菜单表 查询响应数据传输对象列表
     * @param sysTenantPackageMenuPOList 系统管理-租户套餐菜单表 持久化对象列表
     * @return 系统管理-租户套餐菜单表 查询响应数据传输对象列表
     */
    List<SysTenantPackageMenuQueryVO> toQueryVO(List<SysTenantPackageMenuPO> sysTenantPackageMenuPOList);

}
