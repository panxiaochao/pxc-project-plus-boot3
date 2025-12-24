package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysparam.SysParamQueryVO;
import io.github.panxiaochao.system.domain.entity.sysparam.SysParamBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysParamPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-系统参数 持久化对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysParamPOConvert {

    /**
     * 系统管理-系统参数 持久化对象结构映射实例
     */
    ISysParamPOConvert INSTANCE = Mappers.getMapper(ISysParamPOConvert.class);

    /**
     * 系统管理-系统参数 实体 转 系统管理-系统参数 持久化对象
     * @param sysParam 系统管理-系统参数 实体
     * @return 系统管理-系统参数 持久化对象
     */
    SysParamPO fromEntity(SysParamBO sysParam);

    /**
     * 系统管理-系统参数 实体 转 系统管理-系统参数 持久化对象
     * @param sysParamList 系统管理-系统参数 实体
     * @return 系统管理-系统参数 持久化对象
     */
    List<SysParamPO> fromEntity(List<SysParamBO> sysParamList);

    /**
     * 系统管理-系统参数 持久化对象 转 系统管理-系统参数 实体
     * @param sysParamPO 系统管理-系统参数 持久化对象
     * @return 系统管理-系统参数 实体
     */
    SysParamBO toEntityBO(SysParamPO sysParamPO);

    /**
     * 系统管理-系统参数 持久化对象 转 系统管理-系统参数 实体
     * @param sysParamPOList 系统管理-系统参数 持久化对象
     * @return 系统管理-系统参数 实体
     */
    List<SysParamBO> toEntityBO(List<SysParamPO> sysParamPOList);

    /**
     * 系统管理-系统参数 持久化对象 转 系统管理-系统参数 查询响应数据传输对象
     * @param sysParamPO 系统管理-系统参数 持久化对象
     * @return 系统管理-系统参数 查询响应数据传输对象
     */
    SysParamQueryVO toQueryVO(SysParamPO sysParamPO);

    /**
     * 系统管理-系统参数 持久化对象列表 转 系统管理-系统参数 查询响应数据传输对象列表
     * @param sysParamPOList 系统管理-系统参数 持久化对象列表
     * @return 系统管理-系统参数 查询响应数据传输对象列表
     */
    List<SysParamQueryVO> toQueryVO(List<SysParamPO> sysParamPOList);
}
