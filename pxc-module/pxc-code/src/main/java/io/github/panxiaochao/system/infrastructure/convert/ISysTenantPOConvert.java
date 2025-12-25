package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantQueryVO;
import io.github.panxiaochao.system.domain.entity.systenant.SysTenantBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysTenantPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-租户表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysTenantPOConvert {

    /**
     * 系统管理-租户表 持久化对象结构映射实例
     */
    ISysTenantPOConvert INSTANCE = Mappers.getMapper(ISysTenantPOConvert.class);

    /**
     * 系统管理-租户表 实体 转 系统管理-租户表 持久化对象
     * @param sysTenant 系统管理-租户表 实体
     * @return 系统管理-租户表 持久化对象
     */
    SysTenantPO fromEntity(SysTenantBO sysTenant);

    /**
     * 系统管理-租户表 实体 转 系统管理-租户表 持久化对象
     * @param sysTenantList 系统管理-租户表 实体
     * @return 系统管理-租户表 持久化对象
     */
    List<SysTenantPO> fromEntity(List<SysTenantBO> sysTenantList);

    /**
     * 系统管理-租户表 持久化对象 转 系统管理-租户表 实体
     * @param sysTenantPO 系统管理-租户表 持久化对象
     * @return 系统管理-租户表 实体
     */
    SysTenantBO toEntityBO(SysTenantPO sysTenantPO);

    /**
     * 系统管理-租户表 持久化对象 转 系统管理-租户表 实体
     * @param sysTenantPOList 系统管理-租户表 持久化对象
     * @return 系统管理-租户表 实体
     */
    List<SysTenantBO> toEntityBO(List<SysTenantPO> sysTenantPOList);

    /**
     * 系统管理-租户表 持久化对象 转 系统管理-租户表 查询响应数据传输对象
     * @param sysTenantPO 系统管理-租户表 持久化对象
     * @return 系统管理-租户表 查询响应数据传输对象
     */
    SysTenantQueryVO toQueryVO(SysTenantPO sysTenantPO);

    /**
     * 系统管理-租户表 持久化对象列表 转 系统管理-租户表 查询响应数据传输对象列表
     * @param sysTenantPOList 系统管理-租户表 持久化对象列表
     * @return 系统管理-租户表 查询响应数据传输对象列表
     */
    List<SysTenantQueryVO> toQueryVO(List<SysTenantPO> sysTenantPOList);

}
