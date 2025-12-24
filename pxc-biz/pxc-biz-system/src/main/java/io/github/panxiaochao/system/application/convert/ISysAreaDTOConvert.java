package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysarea.SysAreaCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysarea.SysAreaQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysarea.SysAreaUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysarea.SysAreaQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysarea.SysAreaVO;
import io.github.panxiaochao.system.domain.entity.sysarea.SysAreaBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-全国5级行政区划 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysAreaDTOConvert {

    /**
     * 系统管理-全国5级行政区划 数据传输对象结构映射实例
     */
    ISysAreaDTOConvert INSTANCE = Mappers.getMapper(ISysAreaDTOConvert.class);

    /**
     * 系统管理-全国5级行政区划 创建请求数据传输对象 转 系统管理-全国5级行政区划 实体
     * @param createDto 系统管理-全国5级行政区划 创建请求数据传输对象
     * @return 系统管理-全国5级行政区划 实体
     */
    SysAreaBO fromCreateDTO(SysAreaCreateDTO createDto);

    /**
     * 系统管理-全国5级行政区划 更新请求数据传输对象 转 系统管理-全国5级行政区划 实体
     * @param updateDto 系统管理-全国5级行政区划 更新请求数据传输对象
     * @return 系统管理-全国5级行政区划 实体
     */
    SysAreaBO fromUpdateDTO(SysAreaUpdateDTO updateDto);

    /**
     * 系统管理-全国5级行政区划 查询请求数据传输对象 转 系统管理-全国5级行政区划 实体
     * @param queryDto 系统管理-全国5级行政区划 查询请求数据传输对象
     * @return 系统管理-全国5级行政区划 实体
     */
    SysAreaBO fromQueryRequest(SysAreaQueryDTO queryDto);

    /**
     * 系统管理-全国5级行政区划 实体 转 系统管理-全国5级行政区划 响应数据传输对象
     * @param sysArea 系统管理-全国5级行政区划 实体
     * @return 系统管理-全国5级行政区划 响应数据传输对象
     */
    SysAreaVO toVO(SysAreaBO sysArea);

    /**
     * 系统管理-全国5级行政区划 实体 转 系统管理-全国5级行政区划 查询响应数据传输对象
     * @param sysArea 系统管理-全国5级行政区划 实体
     * @return 系统管理-全国5级行政区划 查询响应数据传输对象
     */
    SysAreaQueryVO toQueryVO(SysAreaBO sysArea);

    /**
     * 系统管理-全国5级行政区划 实体列表 转 系统管理-全国5级行政区划 查询响应数据传输对象列表
     * @param sysAreaList 系统管理-全国5级行政区划 实体列表
     * @return 系统管理-全国5级行政区划 查询响应数据传输对象列表
     */
    List<SysAreaQueryVO> toQueryVO(List<SysAreaBO> sysAreaList);

}
