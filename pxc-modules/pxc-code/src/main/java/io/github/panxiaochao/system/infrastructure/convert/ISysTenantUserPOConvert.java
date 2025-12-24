package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.systenantuser.SysTenantUserQueryVO;
import io.github.panxiaochao.system.domain.entity.systenantuser.SysTenantUserBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysTenantUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-租户用户表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysTenantUserPOConvert {

    /**
     * 系统管理-租户用户表 持久化对象结构映射实例
     */
    ISysTenantUserPOConvert INSTANCE = Mappers.getMapper(ISysTenantUserPOConvert.class);

    /**
     * 系统管理-租户用户表 实体 转 系统管理-租户用户表 持久化对象
     * @param sysTenantUser 系统管理-租户用户表 实体
     * @return 系统管理-租户用户表 持久化对象
     */
    SysTenantUserPO fromEntity(SysTenantUserBO sysTenantUser);

    /**
     * 系统管理-租户用户表 实体 转 系统管理-租户用户表 持久化对象
     * @param sysTenantUserList 系统管理-租户用户表 实体
     * @return 系统管理-租户用户表 持久化对象
     */
    List<SysTenantUserPO> fromEntity(List<SysTenantUserBO> sysTenantUserList);

    /**
     * 系统管理-租户用户表 持久化对象 转 系统管理-租户用户表 实体
     * @param sysTenantUserPO 系统管理-租户用户表 持久化对象
     * @return 系统管理-租户用户表 实体
     */
    SysTenantUserBO toEntityBO(SysTenantUserPO sysTenantUserPO);

    /**
     * 系统管理-租户用户表 持久化对象 转 系统管理-租户用户表 实体
     * @param sysTenantUserPOList 系统管理-租户用户表 持久化对象
     * @return 系统管理-租户用户表 实体
     */
    List<SysTenantUserBO> toEntityBO(List<SysTenantUserPO> sysTenantUserPOList);

    /**
     * 系统管理-租户用户表 持久化对象 转 系统管理-租户用户表 查询响应数据传输对象
     * @param sysTenantUserPO 系统管理-租户用户表 持久化对象
     * @return 系统管理-租户用户表 查询响应数据传输对象
     */
    SysTenantUserQueryVO toQueryVO(SysTenantUserPO sysTenantUserPO);

    /**
     * 系统管理-租户用户表 持久化对象列表 转 系统管理-租户用户表 查询响应数据传输对象列表
     * @param sysTenantUserPOList 系统管理-租户用户表 持久化对象列表
     * @return 系统管理-租户用户表 查询响应数据传输对象列表
     */
    List<SysTenantUserQueryVO> toQueryVO(List<SysTenantUserPO> sysTenantUserPOList);

}
