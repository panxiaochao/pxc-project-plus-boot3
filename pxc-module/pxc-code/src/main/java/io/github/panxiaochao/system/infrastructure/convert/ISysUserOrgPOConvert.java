package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysuserorg.SysUserOrgQueryVO;
import io.github.panxiaochao.system.domain.entity.sysuserorg.SysUserOrgBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserOrgPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-用户机构/部门表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserOrgPOConvert {

    /**
     * 系统管理-用户机构/部门表 持久化对象结构映射实例
     */
    ISysUserOrgPOConvert INSTANCE = Mappers.getMapper(ISysUserOrgPOConvert.class);

    /**
     * 系统管理-用户机构/部门表 实体 转 系统管理-用户机构/部门表 持久化对象
     * @param sysUserOrg 系统管理-用户机构/部门表 实体
     * @return 系统管理-用户机构/部门表 持久化对象
     */
    SysUserOrgPO fromEntity(SysUserOrgBO sysUserOrg);

    /**
     * 系统管理-用户机构/部门表 实体 转 系统管理-用户机构/部门表 持久化对象
     * @param sysUserOrgList 系统管理-用户机构/部门表 实体
     * @return 系统管理-用户机构/部门表 持久化对象
     */
    List<SysUserOrgPO> fromEntity(List<SysUserOrgBO> sysUserOrgList);

    /**
     * 系统管理-用户机构/部门表 持久化对象 转 系统管理-用户机构/部门表 实体
     * @param sysUserOrgPO 系统管理-用户机构/部门表 持久化对象
     * @return 系统管理-用户机构/部门表 实体
     */
    SysUserOrgBO toEntityBO(SysUserOrgPO sysUserOrgPO);

    /**
     * 系统管理-用户机构/部门表 持久化对象 转 系统管理-用户机构/部门表 实体
     * @param sysUserOrgPOList 系统管理-用户机构/部门表 持久化对象
     * @return 系统管理-用户机构/部门表 实体
     */
    List<SysUserOrgBO> toEntityBO(List<SysUserOrgPO> sysUserOrgPOList);

    /**
     * 系统管理-用户机构/部门表 持久化对象 转 系统管理-用户机构/部门表 查询响应数据传输对象
     * @param sysUserOrgPO 系统管理-用户机构/部门表 持久化对象
     * @return 系统管理-用户机构/部门表 查询响应数据传输对象
     */
    SysUserOrgQueryVO toQueryVO(SysUserOrgPO sysUserOrgPO);

    /**
     * 系统管理-用户机构/部门表 持久化对象列表 转 系统管理-用户机构/部门表 查询响应数据传输对象列表
     * @param sysUserOrgPOList 系统管理-用户机构/部门表 持久化对象列表
     * @return 系统管理-用户机构/部门表 查询响应数据传输对象列表
     */
    List<SysUserOrgQueryVO> toQueryVO(List<SysUserOrgPO> sysUserOrgPOList);

}
