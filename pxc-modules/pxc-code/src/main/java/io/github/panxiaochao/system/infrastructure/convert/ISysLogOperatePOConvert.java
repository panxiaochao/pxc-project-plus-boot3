package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.syslogoperate.SysLogOperateQueryVO;
import io.github.panxiaochao.system.domain.entity.syslogoperate.SysLogOperateBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysLogOperatePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-系统日志操作表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysLogOperatePOConvert {

    /**
     * 系统管理-系统日志操作表 持久化对象结构映射实例
     */
    ISysLogOperatePOConvert INSTANCE = Mappers.getMapper(ISysLogOperatePOConvert.class);

    /**
     * 系统管理-系统日志操作表 实体 转 系统管理-系统日志操作表 持久化对象
     * @param sysLogOperate 系统管理-系统日志操作表 实体
     * @return 系统管理-系统日志操作表 持久化对象
     */
    SysLogOperatePO fromEntity(SysLogOperateBO sysLogOperate);

    /**
     * 系统管理-系统日志操作表 实体 转 系统管理-系统日志操作表 持久化对象
     * @param sysLogOperateList 系统管理-系统日志操作表 实体
     * @return 系统管理-系统日志操作表 持久化对象
     */
    List<SysLogOperatePO> fromEntity(List<SysLogOperateBO> sysLogOperateList);

    /**
     * 系统管理-系统日志操作表 持久化对象 转 系统管理-系统日志操作表 实体
     * @param sysLogOperatePO 系统管理-系统日志操作表 持久化对象
     * @return 系统管理-系统日志操作表 实体
     */
    SysLogOperateBO toEntityBO(SysLogOperatePO sysLogOperatePO);

    /**
     * 系统管理-系统日志操作表 持久化对象 转 系统管理-系统日志操作表 实体
     * @param sysLogOperatePOList 系统管理-系统日志操作表 持久化对象
     * @return 系统管理-系统日志操作表 实体
     */
    List<SysLogOperateBO> toEntityBO(List<SysLogOperatePO> sysLogOperatePOList);

    /**
     * 系统管理-系统日志操作表 持久化对象 转 系统管理-系统日志操作表 查询响应数据传输对象
     * @param sysLogOperatePO 系统管理-系统日志操作表 持久化对象
     * @return 系统管理-系统日志操作表 查询响应数据传输对象
     */
    SysLogOperateQueryVO toQueryVO(SysLogOperatePO sysLogOperatePO);

    /**
     * 系统管理-系统日志操作表 持久化对象列表 转 系统管理-系统日志操作表 查询响应数据传输对象列表
     * @param sysLogOperatePOList 系统管理-系统日志操作表 持久化对象列表
     * @return 系统管理-系统日志操作表 查询响应数据传输对象列表
     */
    List<SysLogOperateQueryVO> toQueryVO(List<SysLogOperatePO> sysLogOperatePOList);

}
