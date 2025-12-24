package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysdict.SysDictCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysdict.SysDictQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysdict.SysDictUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysdict.SysDictQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysdict.SysDictVO;
import io.github.panxiaochao.system.domain.entity.sysdict.SysDictBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-数据字典表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysDictDTOConvert {

    /**
     * 系统管理-数据字典表 数据传输对象结构映射实例
     */
    ISysDictDTOConvert INSTANCE = Mappers.getMapper(ISysDictDTOConvert.class);

    /**
     * 系统管理-数据字典表 创建请求数据传输对象 转 系统管理-数据字典表 实体
     *
     * @param createDto 系统管理-数据字典表 创建请求数据传输对象
     * @return 系统管理-数据字典表 实体
     */
    SysDictBO fromCreateDTO(SysDictCreateDTO createDto);

    /**
     * 系统管理-数据字典表 更新请求数据传输对象 转 系统管理-数据字典表 实体
     *
     * @param updateDto 系统管理-数据字典表 更新请求数据传输对象
     * @return 系统管理-数据字典表 实体
     */
    SysDictBO fromUpdateDTO(SysDictUpdateDTO updateDto);

    /**
     * 系统管理-数据字典表 查询请求数据传输对象 转 系统管理-数据字典表 实体
     *
     * @param queryDto 系统管理-数据字典表 查询请求数据传输对象
     * @return 系统管理-数据字典表 实体
     */
    SysDictBO fromQueryRequest(SysDictQueryDTO queryDto);

    /**
     * 系统管理-数据字典表 实体 转 系统管理-数据字典表 响应数据传输对象
     *
     * @param sysDict 系统管理-数据字典表 实体
     * @return 系统管理-数据字典表 响应数据传输对象
     */
    SysDictVO toVO(SysDictBO sysDict);

    /**
     * 系统管理-数据字典表 实体 转 系统管理-数据字典表 查询响应数据传输对象
     *
     * @param sysDict 系统管理-数据字典表 实体
     * @return 系统管理-数据字典表 查询响应数据传输对象
     */
    SysDictQueryVO toQueryVO(SysDictBO sysDict);

    /**
     * 系统管理-数据字典表 实体列表 转 系统管理-数据字典表 查询响应数据传输对象列表
     *
     * @param sysDictList 系统管理-数据字典表 实体列表
     * @return 系统管理-数据字典表 查询响应数据传输对象列表
     */
    List<SysDictQueryVO> toQueryVO(List<SysDictBO> sysDictList);
}
