package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysrole.SysRoleCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRoleQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRoleUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysrole.SysRoleQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysrole.SysRoleVO;
import io.github.panxiaochao.system.domain.entity.sysrole.SysRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-角色表 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysRoleDTOConvert {

    /**
     * 系统管理-角色表 数据传输对象结构映射实例
     */
    ISysRoleDTOConvert INSTANCE = Mappers.getMapper(ISysRoleDTOConvert.class);

    /**
     * 系统管理-角色表 创建请求数据传输对象 转 系统管理-角色表 实体
     * @param createDto 系统管理-角色表 创建请求数据传输对象
     * @return 系统管理-角色表 实体
     */
    SysRoleBO fromCreateDTO(SysRoleCreateDTO createDto);

    /**
     * 系统管理-角色表 更新请求数据传输对象 转 系统管理-角色表 实体
     * @param updateDto 系统管理-角色表 更新请求数据传输对象
     * @return 系统管理-角色表 实体
     */
    SysRoleBO fromUpdateDTO(SysRoleUpdateDTO updateDto);

    /**
     * 系统管理-角色表 查询请求数据传输对象 转 系统管理-角色表 实体
     * @param queryDto 系统管理-角色表 查询请求数据传输对象
     * @return 系统管理-角色表 实体
     */
    SysRoleBO fromQueryRequest(SysRoleQueryDTO queryDto);

    /**
     * 系统管理-角色表 实体 转 系统管理-角色表 响应数据传输对象
     * @param sysRole 系统管理-角色表 实体
     * @return 系统管理-角色表 响应数据传输对象
     */
    SysRoleVO toVO(SysRoleBO sysRole);

    /**
     * 系统管理-角色表 实体 转 系统管理-角色表 查询响应数据传输对象
     * @param sysRole 系统管理-角色表 实体
     * @return 系统管理-角色表 查询响应数据传输对象
     */
    SysRoleQueryVO toQueryVO(SysRoleBO sysRole);

    /**
     * 系统管理-角色表 实体列表 转 系统管理-角色表 查询响应数据传输对象列表
     * @param sysRoleList 系统管理-角色表 实体列表
     * @return 系统管理-角色表 查询响应数据传输对象列表
     */
    List<SysRoleQueryVO> toQueryVO(List<SysRoleBO> sysRoleList);

}
