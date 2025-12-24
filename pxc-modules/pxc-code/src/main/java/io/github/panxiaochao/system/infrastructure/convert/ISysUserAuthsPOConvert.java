package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysuserauths.SysUserAuthsQueryVO;
import io.github.panxiaochao.system.domain.entity.sysuserauths.SysUserAuthsBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserAuthsPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-用户授权信息表 持久化对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserAuthsPOConvert {

    /**
     * 系统管理-用户授权信息表 持久化对象结构映射实例
     */
    ISysUserAuthsPOConvert INSTANCE = Mappers.getMapper(ISysUserAuthsPOConvert.class);

    /**
     * 系统管理-用户授权信息表 实体 转 系统管理-用户授权信息表 持久化对象
     * @param sysUserAuths 系统管理-用户授权信息表 实体
     * @return 系统管理-用户授权信息表 持久化对象
     */
    SysUserAuthsPO fromEntity(SysUserAuthsBO sysUserAuths);

    /**
     * 系统管理-用户授权信息表 实体 转 系统管理-用户授权信息表 持久化对象
     * @param sysUserAuthsList 系统管理-用户授权信息表 实体
     * @return 系统管理-用户授权信息表 持久化对象
     */
    List<SysUserAuthsPO> fromEntity(List<SysUserAuthsBO> sysUserAuthsList);

    /**
     * 系统管理-用户授权信息表 持久化对象 转 系统管理-用户授权信息表 实体
     * @param sysUserAuthsPO 系统管理-用户授权信息表 持久化对象
     * @return 系统管理-用户授权信息表 实体
     */
    SysUserAuthsBO toEntityBO(SysUserAuthsPO sysUserAuthsPO);

    /**
     * 系统管理-用户授权信息表 持久化对象 转 系统管理-用户授权信息表 实体
     * @param sysUserAuthsPOList 系统管理-用户授权信息表 持久化对象
     * @return 系统管理-用户授权信息表 实体
     */
    List<SysUserAuthsBO> toEntityBO(List<SysUserAuthsPO> sysUserAuthsPOList);

    /**
     * 系统管理-用户授权信息表 持久化对象 转 系统管理-用户授权信息表 查询响应数据传输对象
     * @param sysUserAuthsPO 系统管理-用户授权信息表 持久化对象
     * @return 系统管理-用户授权信息表 查询响应数据传输对象
     */
    SysUserAuthsQueryVO toQueryVO(SysUserAuthsPO sysUserAuthsPO);

    /**
     * 系统管理-用户授权信息表 持久化对象列表 转 系统管理-用户授权信息表 查询响应数据传输对象列表
     * @param sysUserAuthsPOList 系统管理-用户授权信息表 持久化对象列表
     * @return 系统管理-用户授权信息表 查询响应数据传输对象列表
     */
    List<SysUserAuthsQueryVO> toQueryVO(List<SysUserAuthsPO> sysUserAuthsPOList);
}
