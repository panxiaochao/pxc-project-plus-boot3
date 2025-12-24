package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysarea.SysAreaQueryVO;
import io.github.panxiaochao.system.domain.entity.sysarea.SysAreaBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysAreaPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-全国5级行政区划 持久化对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysAreaPOConvert {

    /**
     * 系统管理-全国5级行政区划 持久化对象结构映射实例
     */
    ISysAreaPOConvert INSTANCE = Mappers.getMapper(ISysAreaPOConvert.class);

    /**
     * 系统管理-全国5级行政区划 实体 转 系统管理-全国5级行政区划 持久化对象
     * @param sysArea 系统管理-全国5级行政区划 实体
     * @return 系统管理-全国5级行政区划 持久化对象
     */
    SysAreaPO fromEntity(SysAreaBO sysArea);

    /**
     * 系统管理-全国5级行政区划 实体 转 系统管理-全国5级行政区划 持久化对象
     * @param sysAreaList 系统管理-全国5级行政区划 实体
     * @return 系统管理-全国5级行政区划 持久化对象
     */
    List<SysAreaPO> fromEntity(List<SysAreaBO> sysAreaList);

    /**
     * 系统管理-全国5级行政区划 持久化对象 转 系统管理-全国5级行政区划 实体
     * @param sysAreaPO 系统管理-全国5级行政区划 持久化对象
     * @return 系统管理-全国5级行政区划 实体
     */
    SysAreaBO toEntityBO(SysAreaPO sysAreaPO);

    /**
     * 系统管理-全国5级行政区划 持久化对象 转 系统管理-全国5级行政区划 实体
     * @param sysAreaPOList 系统管理-全国5级行政区划 持久化对象
     * @return 系统管理-全国5级行政区划 实体
     */
    List<SysAreaBO> toEntityBO(List<SysAreaPO> sysAreaPOList);

    /**
     * 系统管理-全国5级行政区划 持久化对象 转 系统管理-全国5级行政区划 查询响应数据传输对象
     * @param sysAreaPO 系统管理-全国5级行政区划 持久化对象
     * @return 系统管理-全国5级行政区划 查询响应数据传输对象
     */
    SysAreaQueryVO toQueryVO(SysAreaPO sysAreaPO);

    /**
     * 系统管理-全国5级行政区划 持久化对象列表 转 系统管理-全国5级行政区划 查询响应数据传输对象列表
     * @param sysAreaPOList 系统管理-全国5级行政区划 持久化对象列表
     * @return 系统管理-全国5级行政区划 查询响应数据传输对象列表
     */
    List<SysAreaQueryVO> toQueryVO(List<SysAreaPO> sysAreaPOList);
}
