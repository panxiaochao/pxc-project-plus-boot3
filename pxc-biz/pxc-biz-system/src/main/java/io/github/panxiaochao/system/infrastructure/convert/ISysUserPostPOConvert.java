package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysuserpost.SysUserPostQueryVO;
import io.github.panxiaochao.system.domain.entity.sysuserpost.SysUserPostBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserPostPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-用户岗位关联表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserPostPOConvert {

    /**
     * 系统管理-用户岗位关联表 持久化对象结构映射实例
     */
    ISysUserPostPOConvert INSTANCE = Mappers.getMapper(ISysUserPostPOConvert.class);

    /**
     * 系统管理-用户岗位关联表 实体 转 系统管理-用户岗位关联表 持久化对象
     * @param sysUserPost 系统管理-用户岗位关联表 实体
     * @return 系统管理-用户岗位关联表 持久化对象
     */
    SysUserPostPO fromEntity(SysUserPostBO sysUserPost);

    /**
     * 系统管理-用户岗位关联表 实体 转 系统管理-用户岗位关联表 持久化对象
     * @param sysUserPostList 系统管理-用户岗位关联表 实体
     * @return 系统管理-用户岗位关联表 持久化对象
     */
    List<SysUserPostPO> fromEntity(List<SysUserPostBO> sysUserPostList);

    /**
     * 系统管理-用户岗位关联表 持久化对象 转 系统管理-用户岗位关联表 实体
     * @param sysUserPostPO 系统管理-用户岗位关联表 持久化对象
     * @return 系统管理-用户岗位关联表 实体
     */
    SysUserPostBO toEntityBO(SysUserPostPO sysUserPostPO);

    /**
     * 系统管理-用户岗位关联表 持久化对象 转 系统管理-用户岗位关联表 实体
     * @param sysUserPostPOList 系统管理-用户岗位关联表 持久化对象
     * @return 系统管理-用户岗位关联表 实体
     */
    List<SysUserPostBO> toEntityBO(List<SysUserPostPO> sysUserPostPOList);

    /**
     * 系统管理-用户岗位关联表 持久化对象 转 系统管理-用户岗位关联表 查询响应数据传输对象
     * @param sysUserPostPO 系统管理-用户岗位关联表 持久化对象
     * @return 系统管理-用户岗位关联表 查询响应数据传输对象
     */
    SysUserPostQueryVO toQueryVO(SysUserPostPO sysUserPostPO);

    /**
     * 系统管理-用户岗位关联表 持久化对象列表 转 系统管理-用户岗位关联表 查询响应数据传输对象列表
     * @param sysUserPostPOList 系统管理-用户岗位关联表 持久化对象列表
     * @return 系统管理-用户岗位关联表 查询响应数据传输对象列表
     */
    List<SysUserPostQueryVO> toQueryVO(List<SysUserPostPO> sysUserPostPOList);

}
