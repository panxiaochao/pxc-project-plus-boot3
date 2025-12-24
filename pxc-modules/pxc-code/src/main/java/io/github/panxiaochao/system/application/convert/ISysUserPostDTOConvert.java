package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserpost.SysUserPostQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserpost.SysUserPostVO;
import io.github.panxiaochao.system.domain.entity.sysuserpost.SysUserPostBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-用户岗位关联表 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserPostDTOConvert {

    /**
     * 系统管理-用户岗位关联表 数据传输对象结构映射实例
     */
    ISysUserPostDTOConvert INSTANCE = Mappers.getMapper(ISysUserPostDTOConvert.class);

    /**
     * 系统管理-用户岗位关联表 创建请求数据传输对象 转 系统管理-用户岗位关联表 实体
     * @param createDto 系统管理-用户岗位关联表 创建请求数据传输对象
     * @return 系统管理-用户岗位关联表 实体
     */
    SysUserPostBO fromCreateDTO(SysUserPostCreateDTO createDto);

    /**
     * 系统管理-用户岗位关联表 更新请求数据传输对象 转 系统管理-用户岗位关联表 实体
     * @param updateDto 系统管理-用户岗位关联表 更新请求数据传输对象
     * @return 系统管理-用户岗位关联表 实体
     */
    SysUserPostBO fromUpdateDTO(SysUserPostUpdateDTO updateDto);

    /**
     * 系统管理-用户岗位关联表 查询请求数据传输对象 转 系统管理-用户岗位关联表 实体
     * @param queryDto 系统管理-用户岗位关联表 查询请求数据传输对象
     * @return 系统管理-用户岗位关联表 实体
     */
    SysUserPostBO fromQueryRequest(SysUserPostQueryDTO queryDto);

    /**
     * 系统管理-用户岗位关联表 实体 转 系统管理-用户岗位关联表 响应数据传输对象
     * @param sysUserPost 系统管理-用户岗位关联表 实体
     * @return 系统管理-用户岗位关联表 响应数据传输对象
     */
    SysUserPostVO toVO(SysUserPostBO sysUserPost);

    /**
     * 系统管理-用户岗位关联表 实体 转 系统管理-用户岗位关联表 查询响应数据传输对象
     * @param sysUserPost 系统管理-用户岗位关联表 实体
     * @return 系统管理-用户岗位关联表 查询响应数据传输对象
     */
    SysUserPostQueryVO toQueryVO(SysUserPostBO sysUserPost);

    /**
     * 系统管理-用户岗位关联表 实体列表 转 系统管理-用户岗位关联表 查询响应数据传输对象列表
     * @param sysUserPostList 系统管理-用户岗位关联表 实体列表
     * @return 系统管理-用户岗位关联表 查询响应数据传输对象列表
     */
    List<SysUserPostQueryVO> toQueryVO(List<SysUserPostBO> sysUserPostList);

}
