package io.github.panxiaochao.system.development.application.convert;

import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableCreateDTO;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableQueryDTO;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableUpdateDTO;
import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableQueryVO;
import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableVO;
import io.github.panxiaochao.system.development.domain.entity.gentable.GenTableBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>代码生成表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
@Mapper
public interface IGenTableDTOConvert {

    /**
     * 代码生成表 数据传输对象结构映射实例
     */
    IGenTableDTOConvert INSTANCE = Mappers.getMapper(IGenTableDTOConvert.class);

    /**
     * 代码生成表 创建请求数据传输对象 转 代码生成表 实体
     *
     * @param createDto 代码生成表 创建请求数据传输对象
     * @return 代码生成表 实体
     */
    GenTableBO fromCreateDTO(GenTableCreateDTO createDto);

    /**
     * 代码生成表 更新请求数据传输对象 转 代码生成表 实体
     *
     * @param updateDto 代码生成表 更新请求数据传输对象
     * @return 代码生成表 实体
     */
    GenTableBO fromUpdateDTO(GenTableUpdateDTO updateDto);

    /**
     * 代码生成表 查询请求数据传输对象 转 代码生成表 实体
     *
     * @param queryDto 代码生成表 查询请求数据传输对象
     * @return 代码生成表 实体
     */
    GenTableBO fromQueryRequest(GenTableQueryDTO queryDto);

    /**
     * 代码生成表 实体 转 代码生成表 响应数据传输对象
     *
     * @param genTable 代码生成表 实体
     * @return 代码生成表 响应数据传输对象
     */
    GenTableVO toVO(GenTableBO genTable);

    /**
     * 代码生成表 实体 转 代码生成表 查询响应数据传输对象
     *
     * @param genTable 代码生成表 实体
     * @return 代码生成表 查询响应数据传输对象
     */
    GenTableQueryVO toQueryVO(GenTableBO genTable);

    /**
     * 代码生成表 实体列表 转 代码生成表 查询响应数据传输对象列表
     *
     * @param genTableList 代码生成表 实体列表
     * @return 代码生成表 查询响应数据传输对象列表
     */
    List<GenTableQueryVO> toQueryVO(List<GenTableBO> genTableList);
}
