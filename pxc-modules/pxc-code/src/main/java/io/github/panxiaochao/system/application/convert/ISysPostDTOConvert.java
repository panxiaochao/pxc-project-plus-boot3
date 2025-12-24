package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.syspost.SysPostCreateDTO;
import io.github.panxiaochao.system.application.api.dto.syspost.SysPostQueryDTO;
import io.github.panxiaochao.system.application.api.dto.syspost.SysPostUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.syspost.SysPostQueryVO;
import io.github.panxiaochao.system.application.api.vo.syspost.SysPostVO;
import io.github.panxiaochao.system.domain.entity.syspost.SysPostBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-岗位表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysPostDTOConvert {

    /**
     * 系统管理-岗位表 数据传输对象结构映射实例
     */
    ISysPostDTOConvert INSTANCE = Mappers.getMapper(ISysPostDTOConvert.class);

    /**
     * 系统管理-岗位表 创建请求数据传输对象 转 系统管理-岗位表 实体
     *
     * @param createDto 系统管理-岗位表 创建请求数据传输对象
     * @return 系统管理-岗位表 实体
     */
    SysPostBO fromCreateDTO(SysPostCreateDTO createDto);

    /**
     * 系统管理-岗位表 更新请求数据传输对象 转 系统管理-岗位表 实体
     *
     * @param updateDto 系统管理-岗位表 更新请求数据传输对象
     * @return 系统管理-岗位表 实体
     */
    SysPostBO fromUpdateDTO(SysPostUpdateDTO updateDto);

    /**
     * 系统管理-岗位表 查询请求数据传输对象 转 系统管理-岗位表 实体
     *
     * @param queryDto 系统管理-岗位表 查询请求数据传输对象
     * @return 系统管理-岗位表 实体
     */
    SysPostBO fromQueryRequest(SysPostQueryDTO queryDto);

    /**
     * 系统管理-岗位表 实体 转 系统管理-岗位表 响应数据传输对象
     *
     * @param sysPost 系统管理-岗位表 实体
     * @return 系统管理-岗位表 响应数据传输对象
     */
    SysPostVO toVO(SysPostBO sysPost);

    /**
     * 系统管理-岗位表 实体 转 系统管理-岗位表 查询响应数据传输对象
     *
     * @param sysPost 系统管理-岗位表 实体
     * @return 系统管理-岗位表 查询响应数据传输对象
     */
    SysPostQueryVO toQueryVO(SysPostBO sysPost);

    /**
     * 系统管理-岗位表 实体列表 转 系统管理-岗位表 查询响应数据传输对象列表
     *
     * @param sysPostList 系统管理-岗位表 实体列表
     * @return 系统管理-岗位表 查询响应数据传输对象列表
     */
    List<SysPostQueryVO> toQueryVO(List<SysPostBO> sysPostList);
}
