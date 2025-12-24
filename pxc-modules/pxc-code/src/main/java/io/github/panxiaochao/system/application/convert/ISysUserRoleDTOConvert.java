package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysuserrole.SysUserRoleCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserrole.SysUserRoleQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserrole.SysUserRoleUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserrole.SysUserRoleQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserrole.SysUserRoleVO;
import io.github.panxiaochao.system.domain.entity.sysuserrole.SysUserRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-用户角色表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserRoleDTOConvert {

    /**
     * 系统管理-用户角色表 数据传输对象结构映射实例
     */
    ISysUserRoleDTOConvert INSTANCE = Mappers.getMapper(ISysUserRoleDTOConvert.class);

    /**
     * 系统管理-用户角色表 创建请求数据传输对象 转 系统管理-用户角色表 实体
     *
     * @param createDto 系统管理-用户角色表 创建请求数据传输对象
     * @return 系统管理-用户角色表 实体
     */
    SysUserRoleBO fromCreateDTO(SysUserRoleCreateDTO createDto);

    /**
     * 系统管理-用户角色表 更新请求数据传输对象 转 系统管理-用户角色表 实体
     *
     * @param updateDto 系统管理-用户角色表 更新请求数据传输对象
     * @return 系统管理-用户角色表 实体
     */
    SysUserRoleBO fromUpdateDTO(SysUserRoleUpdateDTO updateDto);

    /**
     * 系统管理-用户角色表 查询请求数据传输对象 转 系统管理-用户角色表 实体
     *
     * @param queryDto 系统管理-用户角色表 查询请求数据传输对象
     * @return 系统管理-用户角色表 实体
     */
    SysUserRoleBO fromQueryRequest(SysUserRoleQueryDTO queryDto);

    /**
     * 系统管理-用户角色表 实体 转 系统管理-用户角色表 响应数据传输对象
     *
     * @param sysUserRole 系统管理-用户角色表 实体
     * @return 系统管理-用户角色表 响应数据传输对象
     */
    SysUserRoleVO toVO(SysUserRoleBO sysUserRole);

    /**
     * 系统管理-用户角色表 实体 转 系统管理-用户角色表 查询响应数据传输对象
     *
     * @param sysUserRole 系统管理-用户角色表 实体
     * @return 系统管理-用户角色表 查询响应数据传输对象
     */
    SysUserRoleQueryVO toQueryVO(SysUserRoleBO sysUserRole);

    /**
     * 系统管理-用户角色表 实体列表 转 系统管理-用户角色表 查询响应数据传输对象列表
     *
     * @param sysUserRoleList 系统管理-用户角色表 实体列表
     * @return 系统管理-用户角色表 查询响应数据传输对象列表
     */
    List<SysUserRoleQueryVO> toQueryVO(List<SysUserRoleBO> sysUserRoleList);
}
