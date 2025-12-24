package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysdictitem.SysDictItemQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysdictitem.SysDictItemVO;
import io.github.panxiaochao.system.domain.entity.sysdictitem.SysDictItemBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-数据字典配置表 数据传输对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysDictItemDTOConvert {

    /**
     * 系统管理-数据字典配置表 数据传输对象结构映射实例
     */
    ISysDictItemDTOConvert INSTANCE = Mappers.getMapper(ISysDictItemDTOConvert.class);

    /**
     * 系统管理-数据字典配置表 创建请求数据传输对象 转 系统管理-数据字典配置表 实体
     * @param createDto 系统管理-数据字典配置表 创建请求数据传输对象
     * @return 系统管理-数据字典配置表 实体
     */
    SysDictItemBO fromCreateDTO(SysDictItemCreateDTO createDto);

    /**
     * 系统管理-数据字典配置表 更新请求数据传输对象 转 系统管理-数据字典配置表 实体
     * @param updateDto 系统管理-数据字典配置表 更新请求数据传输对象
     * @return 系统管理-数据字典配置表 实体
     */
    SysDictItemBO fromUpdateDTO(SysDictItemUpdateDTO updateDto);

    /**
     * 系统管理-数据字典配置表 查询请求数据传输对象 转 系统管理-数据字典配置表 实体
     * @param queryDto 系统管理-数据字典配置表 查询请求数据传输对象
     * @return 系统管理-数据字典配置表 实体
     */
    SysDictItemBO fromQueryRequest(SysDictItemQueryDTO queryDto);

    /**
     * 系统管理-数据字典配置表 实体 转 系统管理-数据字典配置表 响应数据传输对象
     * @param sysDictItem 系统管理-数据字典配置表 实体
     * @return 系统管理-数据字典配置表 响应数据传输对象
     */
    SysDictItemVO toVO(SysDictItemBO sysDictItem);

    /**
     * 系统管理-数据字典配置表 实体 转 系统管理-数据字典配置表 查询响应数据传输对象
     * @param sysDictItem 系统管理-数据字典配置表 实体
     * @return 系统管理-数据字典配置表 查询响应数据传输对象
     */
    SysDictItemQueryVO toQueryVO(SysDictItemBO sysDictItem);

    /**
     * 系统管理-数据字典配置表 实体列表 转 系统管理-数据字典配置表 查询响应数据传输对象列表
     * @param sysDictItemList 系统管理-数据字典配置表 实体列表
     * @return 系统管理-数据字典配置表 查询响应数据传输对象列表
     */
    List<SysDictItemQueryVO> toQueryVO(List<SysDictItemBO> sysDictItemList);

}
