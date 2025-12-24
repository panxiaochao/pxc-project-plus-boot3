package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserauths.SysUserAuthsQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserauths.SysUserAuthsVO;
import io.github.panxiaochao.system.domain.entity.sysuserauths.SysUserAuthsBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-用户授权信息表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserAuthsDTOConvert {

    /**
     * 系统管理-用户授权信息表 数据传输对象结构映射实例
     */
    ISysUserAuthsDTOConvert INSTANCE = Mappers.getMapper(ISysUserAuthsDTOConvert.class);

    /**
     * 系统管理-用户授权信息表 创建请求数据传输对象 转 系统管理-用户授权信息表 实体
     *
     * @param createDto 系统管理-用户授权信息表 创建请求数据传输对象
     * @return 系统管理-用户授权信息表 实体
     */
    SysUserAuthsBO fromCreateDTO(SysUserAuthsCreateDTO createDto);

    /**
     * 系统管理-用户授权信息表 更新请求数据传输对象 转 系统管理-用户授权信息表 实体
     *
     * @param updateDto 系统管理-用户授权信息表 更新请求数据传输对象
     * @return 系统管理-用户授权信息表 实体
     */
    SysUserAuthsBO fromUpdateDTO(SysUserAuthsUpdateDTO updateDto);

    /**
     * 系统管理-用户授权信息表 查询请求数据传输对象 转 系统管理-用户授权信息表 实体
     *
     * @param queryDto 系统管理-用户授权信息表 查询请求数据传输对象
     * @return 系统管理-用户授权信息表 实体
     */
    SysUserAuthsBO fromQueryRequest(SysUserAuthsQueryDTO queryDto);

    /**
     * 系统管理-用户授权信息表 实体 转 系统管理-用户授权信息表 响应数据传输对象
     *
     * @param sysUserAuths 系统管理-用户授权信息表 实体
     * @return 系统管理-用户授权信息表 响应数据传输对象
     */
    SysUserAuthsVO toVO(SysUserAuthsBO sysUserAuths);

    /**
     * 系统管理-用户授权信息表 实体 转 系统管理-用户授权信息表 查询响应数据传输对象
     *
     * @param sysUserAuths 系统管理-用户授权信息表 实体
     * @return 系统管理-用户授权信息表 查询响应数据传输对象
     */
    SysUserAuthsQueryVO toQueryVO(SysUserAuthsBO sysUserAuths);

    /**
     * 系统管理-用户授权信息表 实体列表 转 系统管理-用户授权信息表 查询响应数据传输对象列表
     *
     * @param sysUserAuthsList 系统管理-用户授权信息表 实体列表
     * @return 系统管理-用户授权信息表 查询响应数据传输对象列表
     */
    List<SysUserAuthsQueryVO> toQueryVO(List<SysUserAuthsBO> sysUserAuthsList);
}
