package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysparam.SysParamCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysparam.SysParamQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysparam.SysParamUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysparam.SysParamQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysparam.SysParamVO;
import io.github.panxiaochao.system.domain.entity.sysparam.SysParamBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-系统参数 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysParamDTOConvert {

    /**
     * 系统管理-系统参数 数据传输对象结构映射实例
     */
    ISysParamDTOConvert INSTANCE = Mappers.getMapper(ISysParamDTOConvert.class);

    /**
     * 系统管理-系统参数 创建请求数据传输对象 转 系统管理-系统参数 实体
     * @param createDto 系统管理-系统参数 创建请求数据传输对象
     * @return 系统管理-系统参数 实体
     */
    SysParamBO fromCreateDTO(SysParamCreateDTO createDto);

    /**
     * 系统管理-系统参数 更新请求数据传输对象 转 系统管理-系统参数 实体
     * @param updateDto 系统管理-系统参数 更新请求数据传输对象
     * @return 系统管理-系统参数 实体
     */
    SysParamBO fromUpdateDTO(SysParamUpdateDTO updateDto);

    /**
     * 系统管理-系统参数 查询请求数据传输对象 转 系统管理-系统参数 实体
     * @param queryDto 系统管理-系统参数 查询请求数据传输对象
     * @return 系统管理-系统参数 实体
     */
    SysParamBO fromQueryRequest(SysParamQueryDTO queryDto);

    /**
     * 系统管理-系统参数 实体 转 系统管理-系统参数 响应数据传输对象
     * @param sysParam 系统管理-系统参数 实体
     * @return 系统管理-系统参数 响应数据传输对象
     */
    SysParamVO toVO(SysParamBO sysParam);

    /**
     * 系统管理-系统参数 实体 转 系统管理-系统参数 查询响应数据传输对象
     * @param sysParam 系统管理-系统参数 实体
     * @return 系统管理-系统参数 查询响应数据传输对象
     */
    SysParamQueryVO toQueryVO(SysParamBO sysParam);

    /**
     * 系统管理-系统参数 实体列表 转 系统管理-系统参数 查询响应数据传输对象列表
     * @param sysParamList 系统管理-系统参数 实体列表
     * @return 系统管理-系统参数 查询响应数据传输对象列表
     */
    List<SysParamQueryVO> toQueryVO(List<SysParamBO> sysParamList);

}
