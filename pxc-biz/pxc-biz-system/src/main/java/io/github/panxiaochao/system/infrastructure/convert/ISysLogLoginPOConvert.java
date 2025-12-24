package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysloglogin.SysLogLoginQueryVO;
import io.github.panxiaochao.system.domain.entity.sysloglogin.SysLogLoginBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysLogLoginPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-系统日志登录/登出表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysLogLoginPOConvert {

    /**
     * 系统管理-系统日志登录/登出表 持久化对象结构映射实例
     */
    ISysLogLoginPOConvert INSTANCE = Mappers.getMapper(ISysLogLoginPOConvert.class);

    /**
     * 系统管理-系统日志登录/登出表 实体 转 系统管理-系统日志登录/登出表 持久化对象
     * @param sysLogLogin 系统管理-系统日志登录/登出表 实体
     * @return 系统管理-系统日志登录/登出表 持久化对象
     */
    SysLogLoginPO fromEntity(SysLogLoginBO sysLogLogin);

    /**
     * 系统管理-系统日志登录/登出表 实体 转 系统管理-系统日志登录/登出表 持久化对象
     * @param sysLogLoginList 系统管理-系统日志登录/登出表 实体
     * @return 系统管理-系统日志登录/登出表 持久化对象
     */
    List<SysLogLoginPO> fromEntity(List<SysLogLoginBO> sysLogLoginList);

    /**
     * 系统管理-系统日志登录/登出表 持久化对象 转 系统管理-系统日志登录/登出表 实体
     * @param sysLogLoginPO 系统管理-系统日志登录/登出表 持久化对象
     * @return 系统管理-系统日志登录/登出表 实体
     */
    SysLogLoginBO toEntityBO(SysLogLoginPO sysLogLoginPO);

    /**
     * 系统管理-系统日志登录/登出表 持久化对象 转 系统管理-系统日志登录/登出表 实体
     * @param sysLogLoginPOList 系统管理-系统日志登录/登出表 持久化对象
     * @return 系统管理-系统日志登录/登出表 实体
     */
    List<SysLogLoginBO> toEntityBO(List<SysLogLoginPO> sysLogLoginPOList);

    /**
     * 系统管理-系统日志登录/登出表 持久化对象 转 系统管理-系统日志登录/登出表 查询响应数据传输对象
     * @param sysLogLoginPO 系统管理-系统日志登录/登出表 持久化对象
     * @return 系统管理-系统日志登录/登出表 查询响应数据传输对象
     */
    SysLogLoginQueryVO toQueryVO(SysLogLoginPO sysLogLoginPO);

    /**
     * 系统管理-系统日志登录/登出表 持久化对象列表 转 系统管理-系统日志登录/登出表 查询响应数据传输对象列表
     * @param sysLogLoginPOList 系统管理-系统日志登录/登出表 持久化对象列表
     * @return 系统管理-系统日志登录/登出表 查询响应数据传输对象列表
     */
    List<SysLogLoginQueryVO> toQueryVO(List<SysLogLoginPO> sysLogLoginPOList);

}
