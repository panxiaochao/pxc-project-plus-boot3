package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysloglogin.SysLogLoginQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysloglogin.SysLogLoginVO;
import io.github.panxiaochao.system.domain.entity.sysloglogin.SysLogLoginBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-系统日志登录/登出表 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysLogLoginDTOConvert {

    /**
     * 系统管理-系统日志登录/登出表 数据传输对象结构映射实例
     */
    ISysLogLoginDTOConvert INSTANCE = Mappers.getMapper(ISysLogLoginDTOConvert.class);

    /**
     * 系统管理-系统日志登录/登出表 创建请求数据传输对象 转 系统管理-系统日志登录/登出表 实体
     * @param createDto 系统管理-系统日志登录/登出表 创建请求数据传输对象
     * @return 系统管理-系统日志登录/登出表 实体
     */
    SysLogLoginBO fromCreateDTO(SysLogLoginCreateDTO createDto);

    /**
     * 系统管理-系统日志登录/登出表 更新请求数据传输对象 转 系统管理-系统日志登录/登出表 实体
     * @param updateDto 系统管理-系统日志登录/登出表 更新请求数据传输对象
     * @return 系统管理-系统日志登录/登出表 实体
     */
    SysLogLoginBO fromUpdateDTO(SysLogLoginUpdateDTO updateDto);

    /**
     * 系统管理-系统日志登录/登出表 查询请求数据传输对象 转 系统管理-系统日志登录/登出表 实体
     * @param queryDto 系统管理-系统日志登录/登出表 查询请求数据传输对象
     * @return 系统管理-系统日志登录/登出表 实体
     */
    SysLogLoginBO fromQueryRequest(SysLogLoginQueryDTO queryDto);

    /**
     * 系统管理-系统日志登录/登出表 实体 转 系统管理-系统日志登录/登出表 响应数据传输对象
     * @param sysLogLogin 系统管理-系统日志登录/登出表 实体
     * @return 系统管理-系统日志登录/登出表 响应数据传输对象
     */
    SysLogLoginVO toVO(SysLogLoginBO sysLogLogin);

    /**
     * 系统管理-系统日志登录/登出表 实体 转 系统管理-系统日志登录/登出表 查询响应数据传输对象
     * @param sysLogLogin 系统管理-系统日志登录/登出表 实体
     * @return 系统管理-系统日志登录/登出表 查询响应数据传输对象
     */
    SysLogLoginQueryVO toQueryVO(SysLogLoginBO sysLogLogin);

    /**
     * 系统管理-系统日志登录/登出表 实体列表 转 系统管理-系统日志登录/登出表 查询响应数据传输对象列表
     * @param sysLogLoginList 系统管理-系统日志登录/登出表 实体列表
     * @return 系统管理-系统日志登录/登出表 查询响应数据传输对象列表
     */
    List<SysLogLoginQueryVO> toQueryVO(List<SysLogLoginBO> sysLogLoginList);

}
