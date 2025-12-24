package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.systenantpackage.SysTenantPackageCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackage.SysTenantPackageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackage.SysTenantPackageUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenantpackage.SysTenantPackageQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenantpackage.SysTenantPackageVO;
import io.github.panxiaochao.system.domain.entity.systenantpackage.SysTenantPackageBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-租户套餐表 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysTenantPackageDTOConvert {

    /**
     * 系统管理-租户套餐表 数据传输对象结构映射实例
     */
    ISysTenantPackageDTOConvert INSTANCE = Mappers.getMapper(ISysTenantPackageDTOConvert.class);

    /**
     * 系统管理-租户套餐表 创建请求数据传输对象 转 系统管理-租户套餐表 实体
     * @param createDto 系统管理-租户套餐表 创建请求数据传输对象
     * @return 系统管理-租户套餐表 实体
     */
    SysTenantPackageBO fromCreateDTO(SysTenantPackageCreateDTO createDto);

    /**
     * 系统管理-租户套餐表 更新请求数据传输对象 转 系统管理-租户套餐表 实体
     * @param updateDto 系统管理-租户套餐表 更新请求数据传输对象
     * @return 系统管理-租户套餐表 实体
     */
    SysTenantPackageBO fromUpdateDTO(SysTenantPackageUpdateDTO updateDto);

    /**
     * 系统管理-租户套餐表 查询请求数据传输对象 转 系统管理-租户套餐表 实体
     * @param queryDto 系统管理-租户套餐表 查询请求数据传输对象
     * @return 系统管理-租户套餐表 实体
     */
    SysTenantPackageBO fromQueryRequest(SysTenantPackageQueryDTO queryDto);

    /**
     * 系统管理-租户套餐表 实体 转 系统管理-租户套餐表 响应数据传输对象
     * @param sysTenantPackage 系统管理-租户套餐表 实体
     * @return 系统管理-租户套餐表 响应数据传输对象
     */
    SysTenantPackageVO toVO(SysTenantPackageBO sysTenantPackage);

    /**
     * 系统管理-租户套餐表 实体 转 系统管理-租户套餐表 查询响应数据传输对象
     * @param sysTenantPackage 系统管理-租户套餐表 实体
     * @return 系统管理-租户套餐表 查询响应数据传输对象
     */
    SysTenantPackageQueryVO toQueryVO(SysTenantPackageBO sysTenantPackage);

    /**
     * 系统管理-租户套餐表 实体列表 转 系统管理-租户套餐表 查询响应数据传输对象列表
     * @param sysTenantPackageList 系统管理-租户套餐表 实体列表
     * @return 系统管理-租户套餐表 查询响应数据传输对象列表
     */
    List<SysTenantPackageQueryVO> toQueryVO(List<SysTenantPackageBO> sysTenantPackageList);

}
