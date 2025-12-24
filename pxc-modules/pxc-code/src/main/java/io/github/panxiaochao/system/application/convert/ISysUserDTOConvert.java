package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuser.SysUserQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuser.SysUserVO;
import io.github.panxiaochao.system.domain.entity.sysuser.SysUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-用户表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserDTOConvert {

    /**
     * 系统管理-用户表 数据传输对象结构映射实例
     */
    ISysUserDTOConvert INSTANCE = Mappers.getMapper(ISysUserDTOConvert.class);

    /**
     * 系统管理-用户表 创建请求数据传输对象 转 系统管理-用户表 实体
     *
     * @param createDto 系统管理-用户表 创建请求数据传输对象
     * @return 系统管理-用户表 实体
     */
    SysUserBO fromCreateDTO(SysUserCreateDTO createDto);

    /**
     * 系统管理-用户表 更新请求数据传输对象 转 系统管理-用户表 实体
     *
     * @param updateDto 系统管理-用户表 更新请求数据传输对象
     * @return 系统管理-用户表 实体
     */
    SysUserBO fromUpdateDTO(SysUserUpdateDTO updateDto);

    /**
     * 系统管理-用户表 查询请求数据传输对象 转 系统管理-用户表 实体
     *
     * @param queryDto 系统管理-用户表 查询请求数据传输对象
     * @return 系统管理-用户表 实体
     */
    SysUserBO fromQueryRequest(SysUserQueryDTO queryDto);

    /**
     * 系统管理-用户表 实体 转 系统管理-用户表 响应数据传输对象
     *
     * @param sysUser 系统管理-用户表 实体
     * @return 系统管理-用户表 响应数据传输对象
     */
    SysUserVO toVO(SysUserBO sysUser);

    /**
     * 系统管理-用户表 实体 转 系统管理-用户表 查询响应数据传输对象
     *
     * @param sysUser 系统管理-用户表 实体
     * @return 系统管理-用户表 查询响应数据传输对象
     */
    SysUserQueryVO toQueryVO(SysUserBO sysUser);

    /**
     * 系统管理-用户表 实体列表 转 系统管理-用户表 查询响应数据传输对象列表
     *
     * @param sysUserList 系统管理-用户表 实体列表
     * @return 系统管理-用户表 查询响应数据传输对象列表
     */
    List<SysUserQueryVO> toQueryVO(List<SysUserBO> sysUserList);
}
