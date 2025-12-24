package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysuser.SysUserQueryVO;
import io.github.panxiaochao.system.domain.entity.sysuser.SysUserBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-用户表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserPOConvert {

    /**
     * 系统管理-用户表 持久化对象结构映射实例
     */
    ISysUserPOConvert INSTANCE = Mappers.getMapper(ISysUserPOConvert.class);

    /**
     * 系统管理-用户表 实体 转 系统管理-用户表 持久化对象
     * @param sysUser 系统管理-用户表 实体
     * @return 系统管理-用户表 持久化对象
     */
    SysUserPO fromEntity(SysUserBO sysUser);

    /**
     * 系统管理-用户表 实体 转 系统管理-用户表 持久化对象
     * @param sysUserList 系统管理-用户表 实体
     * @return 系统管理-用户表 持久化对象
     */
    List<SysUserPO> fromEntity(List<SysUserBO> sysUserList);

    /**
     * 系统管理-用户表 持久化对象 转 系统管理-用户表 实体
     * @param sysUserPO 系统管理-用户表 持久化对象
     * @return 系统管理-用户表 实体
     */
    SysUserBO toEntityBO(SysUserPO sysUserPO);

    /**
     * 系统管理-用户表 持久化对象 转 系统管理-用户表 实体
     * @param sysUserPOList 系统管理-用户表 持久化对象
     * @return 系统管理-用户表 实体
     */
    List<SysUserBO> toEntityBO(List<SysUserPO> sysUserPOList);

    /**
     * 系统管理-用户表 持久化对象 转 系统管理-用户表 查询响应数据传输对象
     * @param sysUserPO 系统管理-用户表 持久化对象
     * @return 系统管理-用户表 查询响应数据传输对象
     */
    SysUserQueryVO toQueryVO(SysUserPO sysUserPO);

    /**
     * 系统管理-用户表 持久化对象列表 转 系统管理-用户表 查询响应数据传输对象列表
     * @param sysUserPOList 系统管理-用户表 持久化对象列表
     * @return 系统管理-用户表 查询响应数据传输对象列表
     */
    List<SysUserQueryVO> toQueryVO(List<SysUserPO> sysUserPOList);

}
