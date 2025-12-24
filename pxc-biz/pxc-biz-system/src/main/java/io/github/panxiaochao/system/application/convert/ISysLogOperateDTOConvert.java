package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.syslogoperate.SysLogOperateCreateDTO;
import io.github.panxiaochao.system.application.api.dto.syslogoperate.SysLogOperateQueryDTO;
import io.github.panxiaochao.system.application.api.dto.syslogoperate.SysLogOperateUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.syslogoperate.SysLogOperateQueryVO;
import io.github.panxiaochao.system.application.api.vo.syslogoperate.SysLogOperateVO;
import io.github.panxiaochao.system.domain.entity.syslogoperate.SysLogOperateBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-系统日志操作表 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysLogOperateDTOConvert {

    /**
     * 系统管理-系统日志操作表 数据传输对象结构映射实例
     */
    ISysLogOperateDTOConvert INSTANCE = Mappers.getMapper(ISysLogOperateDTOConvert.class);

    /**
     * 系统管理-系统日志操作表 创建请求数据传输对象 转 系统管理-系统日志操作表 实体
     * @param createDto 系统管理-系统日志操作表 创建请求数据传输对象
     * @return 系统管理-系统日志操作表 实体
     */
    SysLogOperateBO fromCreateDTO(SysLogOperateCreateDTO createDto);

    /**
     * 系统管理-系统日志操作表 更新请求数据传输对象 转 系统管理-系统日志操作表 实体
     * @param updateDto 系统管理-系统日志操作表 更新请求数据传输对象
     * @return 系统管理-系统日志操作表 实体
     */
    SysLogOperateBO fromUpdateDTO(SysLogOperateUpdateDTO updateDto);

    /**
     * 系统管理-系统日志操作表 查询请求数据传输对象 转 系统管理-系统日志操作表 实体
     * @param queryDto 系统管理-系统日志操作表 查询请求数据传输对象
     * @return 系统管理-系统日志操作表 实体
     */
    SysLogOperateBO fromQueryRequest(SysLogOperateQueryDTO queryDto);

    /**
     * 系统管理-系统日志操作表 实体 转 系统管理-系统日志操作表 响应数据传输对象
     * @param sysLogOperate 系统管理-系统日志操作表 实体
     * @return 系统管理-系统日志操作表 响应数据传输对象
     */
    SysLogOperateVO toVO(SysLogOperateBO sysLogOperate);

    /**
     * 系统管理-系统日志操作表 实体 转 系统管理-系统日志操作表 查询响应数据传输对象
     * @param sysLogOperate 系统管理-系统日志操作表 实体
     * @return 系统管理-系统日志操作表 查询响应数据传输对象
     */
    SysLogOperateQueryVO toQueryVO(SysLogOperateBO sysLogOperate);

    /**
     * 系统管理-系统日志操作表 实体列表 转 系统管理-系统日志操作表 查询响应数据传输对象列表
     * @param sysLogOperateList 系统管理-系统日志操作表 实体列表
     * @return 系统管理-系统日志操作表 查询响应数据传输对象列表
     */
    List<SysLogOperateQueryVO> toQueryVO(List<SysLogOperateBO> sysLogOperateList);

}
