package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantVO;
import io.github.panxiaochao.system.domain.entity.systenant.SysTenantBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-租户表 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysTenantDTOConvert {

    /**
     * 系统管理-租户表 数据传输对象结构映射实例
     */
    ISysTenantDTOConvert INSTANCE = Mappers.getMapper(ISysTenantDTOConvert.class);

    /**
     * 系统管理-租户表 创建请求数据传输对象 转 系统管理-租户表 实体
     * @param createDto 系统管理-租户表 创建请求数据传输对象
     * @return 系统管理-租户表 实体
     */
    SysTenantBO fromCreateDTO(SysTenantCreateDTO createDto);

    /**
     * 系统管理-租户表 更新请求数据传输对象 转 系统管理-租户表 实体
     * @param updateDto 系统管理-租户表 更新请求数据传输对象
     * @return 系统管理-租户表 实体
     */
    SysTenantBO fromUpdateDTO(SysTenantUpdateDTO updateDto);

    /**
     * 系统管理-租户表 查询请求数据传输对象 转 系统管理-租户表 实体
     * @param queryDto 系统管理-租户表 查询请求数据传输对象
     * @return 系统管理-租户表 实体
     */
    SysTenantBO fromQueryRequest(SysTenantQueryDTO queryDto);

    /**
     * 系统管理-租户表 实体 转 系统管理-租户表 响应数据传输对象
     * @param sysTenant 系统管理-租户表 实体
     * @return 系统管理-租户表 响应数据传输对象
     */
    SysTenantVO toVO(SysTenantBO sysTenant);

    /**
     * 系统管理-租户表 实体 转 系统管理-租户表 查询响应数据传输对象
     * @param sysTenant 系统管理-租户表 实体
     * @return 系统管理-租户表 查询响应数据传输对象
     */
    SysTenantQueryVO toQueryVO(SysTenantBO sysTenant);

    /**
     * 系统管理-租户表 实体列表 转 系统管理-租户表 查询响应数据传输对象列表
     * @param sysTenantList 系统管理-租户表 实体列表
     * @return 系统管理-租户表 查询响应数据传输对象列表
     */
    List<SysTenantQueryVO> toQueryVO(List<SysTenantBO> sysTenantList);

}
