package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.systenantpackage.SysTenantPackageQueryVO;
import io.github.panxiaochao.system.domain.entity.systenantpackage.SysTenantPackageBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysTenantPackagePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-租户套餐表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysTenantPackagePOConvert {

    /**
     * 系统管理-租户套餐表 持久化对象结构映射实例
     */
    ISysTenantPackagePOConvert INSTANCE = Mappers.getMapper(ISysTenantPackagePOConvert.class);

    /**
     * 系统管理-租户套餐表 实体 转 系统管理-租户套餐表 持久化对象
     * @param sysTenantPackage 系统管理-租户套餐表 实体
     * @return 系统管理-租户套餐表 持久化对象
     */
    SysTenantPackagePO fromEntity(SysTenantPackageBO sysTenantPackage);

    /**
     * 系统管理-租户套餐表 实体 转 系统管理-租户套餐表 持久化对象
     * @param sysTenantPackageList 系统管理-租户套餐表 实体
     * @return 系统管理-租户套餐表 持久化对象
     */
    List<SysTenantPackagePO> fromEntity(List<SysTenantPackageBO> sysTenantPackageList);

    /**
     * 系统管理-租户套餐表 持久化对象 转 系统管理-租户套餐表 实体
     * @param sysTenantPackagePO 系统管理-租户套餐表 持久化对象
     * @return 系统管理-租户套餐表 实体
     */
    SysTenantPackageBO toEntityBO(SysTenantPackagePO sysTenantPackagePO);

    /**
     * 系统管理-租户套餐表 持久化对象 转 系统管理-租户套餐表 实体
     * @param sysTenantPackagePOList 系统管理-租户套餐表 持久化对象
     * @return 系统管理-租户套餐表 实体
     */
    List<SysTenantPackageBO> toEntityBO(List<SysTenantPackagePO> sysTenantPackagePOList);

    /**
     * 系统管理-租户套餐表 持久化对象 转 系统管理-租户套餐表 查询响应数据传输对象
     * @param sysTenantPackagePO 系统管理-租户套餐表 持久化对象
     * @return 系统管理-租户套餐表 查询响应数据传输对象
     */
    SysTenantPackageQueryVO toQueryVO(SysTenantPackagePO sysTenantPackagePO);

    /**
     * 系统管理-租户套餐表 持久化对象列表 转 系统管理-租户套餐表 查询响应数据传输对象列表
     * @param sysTenantPackagePOList 系统管理-租户套餐表 持久化对象列表
     * @return 系统管理-租户套餐表 查询响应数据传输对象列表
     */
    List<SysTenantPackageQueryVO> toQueryVO(List<SysTenantPackagePO> sysTenantPackagePOList);

}
