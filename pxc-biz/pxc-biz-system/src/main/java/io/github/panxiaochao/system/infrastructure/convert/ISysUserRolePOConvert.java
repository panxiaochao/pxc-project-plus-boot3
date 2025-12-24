package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysuserrole.SysUserRoleQueryVO;
import io.github.panxiaochao.system.domain.entity.sysuserrole.SysUserRoleBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserRolePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-用户角色表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserRolePOConvert {

    /**
     * 系统管理-用户角色表 持久化对象结构映射实例
     */
    ISysUserRolePOConvert INSTANCE = Mappers.getMapper(ISysUserRolePOConvert.class);

    /**
     * 系统管理-用户角色表 实体 转 系统管理-用户角色表 持久化对象
     * @param sysUserRole 系统管理-用户角色表 实体
     * @return 系统管理-用户角色表 持久化对象
     */
    SysUserRolePO fromEntity(SysUserRoleBO sysUserRole);

    /**
     * 系统管理-用户角色表 实体 转 系统管理-用户角色表 持久化对象
     * @param sysUserRoleList 系统管理-用户角色表 实体
     * @return 系统管理-用户角色表 持久化对象
     */
    List<SysUserRolePO> fromEntity(List<SysUserRoleBO> sysUserRoleList);

    /**
     * 系统管理-用户角色表 持久化对象 转 系统管理-用户角色表 实体
     * @param sysUserRolePO 系统管理-用户角色表 持久化对象
     * @return 系统管理-用户角色表 实体
     */
    SysUserRoleBO toEntityBO(SysUserRolePO sysUserRolePO);

    /**
     * 系统管理-用户角色表 持久化对象 转 系统管理-用户角色表 实体
     * @param sysUserRolePOList 系统管理-用户角色表 持久化对象
     * @return 系统管理-用户角色表 实体
     */
    List<SysUserRoleBO> toEntityBO(List<SysUserRolePO> sysUserRolePOList);

    /**
     * 系统管理-用户角色表 持久化对象 转 系统管理-用户角色表 查询响应数据传输对象
     * @param sysUserRolePO 系统管理-用户角色表 持久化对象
     * @return 系统管理-用户角色表 查询响应数据传输对象
     */
    SysUserRoleQueryVO toQueryVO(SysUserRolePO sysUserRolePO);

    /**
     * 系统管理-用户角色表 持久化对象列表 转 系统管理-用户角色表 查询响应数据传输对象列表
     * @param sysUserRolePOList 系统管理-用户角色表 持久化对象列表
     * @return 系统管理-用户角色表 查询响应数据传输对象列表
     */
    List<SysUserRoleQueryVO> toQueryVO(List<SysUserRolePO> sysUserRolePOList);

}
