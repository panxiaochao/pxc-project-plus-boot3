package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.systenantuser.SysTenantUserCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenantuser.SysTenantUserQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantuser.SysTenantUserUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenantuser.SysTenantUserQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenantuser.SysTenantUserVO;
import io.github.panxiaochao.system.domain.entity.systenantuser.SysTenantUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-租户用户表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysTenantUserDTOConvert {

    /**
     * 系统管理-租户用户表 数据传输对象结构映射实例
     */
    ISysTenantUserDTOConvert INSTANCE = Mappers.getMapper(ISysTenantUserDTOConvert.class);

    /**
     * 系统管理-租户用户表 创建请求数据传输对象 转 系统管理-租户用户表 实体
     *
     * @param createDto 系统管理-租户用户表 创建请求数据传输对象
     * @return 系统管理-租户用户表 实体
     */
    SysTenantUserBO fromCreateDTO(SysTenantUserCreateDTO createDto);

    /**
     * 系统管理-租户用户表 更新请求数据传输对象 转 系统管理-租户用户表 实体
     *
     * @param updateDto 系统管理-租户用户表 更新请求数据传输对象
     * @return 系统管理-租户用户表 实体
     */
    SysTenantUserBO fromUpdateDTO(SysTenantUserUpdateDTO updateDto);

    /**
     * 系统管理-租户用户表 查询请求数据传输对象 转 系统管理-租户用户表 实体
     *
     * @param queryDto 系统管理-租户用户表 查询请求数据传输对象
     * @return 系统管理-租户用户表 实体
     */
    SysTenantUserBO fromQueryRequest(SysTenantUserQueryDTO queryDto);

    /**
     * 系统管理-租户用户表 实体 转 系统管理-租户用户表 响应数据传输对象
     *
     * @param sysTenantUser 系统管理-租户用户表 实体
     * @return 系统管理-租户用户表 响应数据传输对象
     */
    SysTenantUserVO toVO(SysTenantUserBO sysTenantUser);

    /**
     * 系统管理-租户用户表 实体 转 系统管理-租户用户表 查询响应数据传输对象
     *
     * @param sysTenantUser 系统管理-租户用户表 实体
     * @return 系统管理-租户用户表 查询响应数据传输对象
     */
    SysTenantUserQueryVO toQueryVO(SysTenantUserBO sysTenantUser);

    /**
     * 系统管理-租户用户表 实体列表 转 系统管理-租户用户表 查询响应数据传输对象列表
     *
     * @param sysTenantUserList 系统管理-租户用户表 实体列表
     * @return 系统管理-租户用户表 查询响应数据传输对象列表
     */
    List<SysTenantUserQueryVO> toQueryVO(List<SysTenantUserBO> sysTenantUserList);
}
