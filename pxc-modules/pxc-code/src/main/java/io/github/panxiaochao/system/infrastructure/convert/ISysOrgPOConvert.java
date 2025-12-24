package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysorg.SysOrgQueryVO;
import io.github.panxiaochao.system.domain.entity.sysorg.SysOrgBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysOrgPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-机构部门表 持久化对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysOrgPOConvert {

    /**
     * 系统管理-机构部门表 持久化对象结构映射实例
     */
    ISysOrgPOConvert INSTANCE = Mappers.getMapper(ISysOrgPOConvert.class);

    /**
     * 系统管理-机构部门表 实体 转 系统管理-机构部门表 持久化对象
     * @param sysOrg 系统管理-机构部门表 实体
     * @return 系统管理-机构部门表 持久化对象
     */
    SysOrgPO fromEntity(SysOrgBO sysOrg);

    /**
     * 系统管理-机构部门表 实体 转 系统管理-机构部门表 持久化对象
     * @param sysOrgList 系统管理-机构部门表 实体
     * @return 系统管理-机构部门表 持久化对象
     */
    List<SysOrgPO> fromEntity(List<SysOrgBO> sysOrgList);

    /**
     * 系统管理-机构部门表 持久化对象 转 系统管理-机构部门表 实体
     * @param sysOrgPO 系统管理-机构部门表 持久化对象
     * @return 系统管理-机构部门表 实体
     */
    SysOrgBO toEntityBO(SysOrgPO sysOrgPO);

    /**
     * 系统管理-机构部门表 持久化对象 转 系统管理-机构部门表 实体
     * @param sysOrgPOList 系统管理-机构部门表 持久化对象
     * @return 系统管理-机构部门表 实体
     */
    List<SysOrgBO> toEntityBO(List<SysOrgPO> sysOrgPOList);

    /**
     * 系统管理-机构部门表 持久化对象 转 系统管理-机构部门表 查询响应数据传输对象
     * @param sysOrgPO 系统管理-机构部门表 持久化对象
     * @return 系统管理-机构部门表 查询响应数据传输对象
     */
    SysOrgQueryVO toQueryVO(SysOrgPO sysOrgPO);

    /**
     * 系统管理-机构部门表 持久化对象列表 转 系统管理-机构部门表 查询响应数据传输对象列表
     * @param sysOrgPOList 系统管理-机构部门表 持久化对象列表
     * @return 系统管理-机构部门表 查询响应数据传输对象列表
     */
    List<SysOrgQueryVO> toQueryVO(List<SysOrgPO> sysOrgPOList);
}
