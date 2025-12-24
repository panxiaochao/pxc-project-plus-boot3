package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.syspost.SysPostQueryVO;
import io.github.panxiaochao.system.domain.entity.syspost.SysPostBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysPostPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-岗位表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysPostPOConvert {

    /**
     * 系统管理-岗位表 持久化对象结构映射实例
     */
    ISysPostPOConvert INSTANCE = Mappers.getMapper(ISysPostPOConvert.class);

    /**
     * 系统管理-岗位表 实体 转 系统管理-岗位表 持久化对象
     * @param sysPost 系统管理-岗位表 实体
     * @return 系统管理-岗位表 持久化对象
     */
    SysPostPO fromEntity(SysPostBO sysPost);

    /**
     * 系统管理-岗位表 实体 转 系统管理-岗位表 持久化对象
     * @param sysPostList 系统管理-岗位表 实体
     * @return 系统管理-岗位表 持久化对象
     */
    List<SysPostPO> fromEntity(List<SysPostBO> sysPostList);

    /**
     * 系统管理-岗位表 持久化对象 转 系统管理-岗位表 实体
     * @param sysPostPO 系统管理-岗位表 持久化对象
     * @return 系统管理-岗位表 实体
     */
    SysPostBO toEntityBO(SysPostPO sysPostPO);

    /**
     * 系统管理-岗位表 持久化对象 转 系统管理-岗位表 实体
     * @param sysPostPOList 系统管理-岗位表 持久化对象
     * @return 系统管理-岗位表 实体
     */
    List<SysPostBO> toEntityBO(List<SysPostPO> sysPostPOList);

    /**
     * 系统管理-岗位表 持久化对象 转 系统管理-岗位表 查询响应数据传输对象
     * @param sysPostPO 系统管理-岗位表 持久化对象
     * @return 系统管理-岗位表 查询响应数据传输对象
     */
    SysPostQueryVO toQueryVO(SysPostPO sysPostPO);

    /**
     * 系统管理-岗位表 持久化对象列表 转 系统管理-岗位表 查询响应数据传输对象列表
     * @param sysPostPOList 系统管理-岗位表 持久化对象列表
     * @return 系统管理-岗位表 查询响应数据传输对象列表
     */
    List<SysPostQueryVO> toQueryVO(List<SysPostPO> sysPostPOList);

}
