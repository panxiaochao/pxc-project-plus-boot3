package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysrole.SysRoleQueryVO;
import io.github.panxiaochao.system.domain.entity.sysrole.SysRoleBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysRolePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-角色表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysRolePOConvert {

    /**
     * 系统管理-角色表 持久化对象结构映射实例
     */
    ISysRolePOConvert INSTANCE = Mappers.getMapper(ISysRolePOConvert.class);

    /**
     * 系统管理-角色表 实体 转 系统管理-角色表 持久化对象
     * @param sysRole 系统管理-角色表 实体
     * @return 系统管理-角色表 持久化对象
     */
    SysRolePO fromEntity(SysRoleBO sysRole);

    /**
     * 系统管理-角色表 实体 转 系统管理-角色表 持久化对象
     * @param sysRoleList 系统管理-角色表 实体
     * @return 系统管理-角色表 持久化对象
     */
    List<SysRolePO> fromEntity(List<SysRoleBO> sysRoleList);

    /**
     * 系统管理-角色表 持久化对象 转 系统管理-角色表 实体
     * @param sysRolePO 系统管理-角色表 持久化对象
     * @return 系统管理-角色表 实体
     */
    SysRoleBO toEntityBO(SysRolePO sysRolePO);

    /**
     * 系统管理-角色表 持久化对象 转 系统管理-角色表 实体
     * @param sysRolePOList 系统管理-角色表 持久化对象
     * @return 系统管理-角色表 实体
     */
    List<SysRoleBO> toEntityBO(List<SysRolePO> sysRolePOList);

    /**
     * 系统管理-角色表 持久化对象 转 系统管理-角色表 查询响应数据传输对象
     * @param sysRolePO 系统管理-角色表 持久化对象
     * @return 系统管理-角色表 查询响应数据传输对象
     */
    SysRoleQueryVO toQueryVO(SysRolePO sysRolePO);

    /**
     * 系统管理-角色表 持久化对象列表 转 系统管理-角色表 查询响应数据传输对象列表
     * @param sysRolePOList 系统管理-角色表 持久化对象列表
     * @return 系统管理-角色表 查询响应数据传输对象列表
     */
    List<SysRoleQueryVO> toQueryVO(List<SysRolePO> sysRolePOList);

}
