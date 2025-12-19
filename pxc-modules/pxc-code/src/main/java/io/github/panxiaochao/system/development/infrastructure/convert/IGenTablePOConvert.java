package io.github.panxiaochao.system.development.infrastructure.convert;

import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableQueryVO;
import io.github.panxiaochao.system.development.domain.entity.gentable.GenTableBO;
import io.github.panxiaochao.system.development.infrastructure.dao.po.GenTablePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>代码生成表 持久化对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
@Mapper
public interface IGenTablePOConvert {

    /**
     * 代码生成表 持久化对象结构映射实例
     */
    IGenTablePOConvert INSTANCE = Mappers.getMapper(IGenTablePOConvert.class);

    /**
     * 代码生成表 实体 转 代码生成表 持久化对象
     * @param genTable 代码生成表 实体
     * @return 代码生成表 持久化对象
     */
    GenTablePO fromEntity(GenTableBO genTable);

    /**
     * 代码生成表 实体 转 代码生成表 持久化对象
     * @param genTableList 代码生成表 实体
     * @return 代码生成表 持久化对象
     */
    List<GenTablePO> fromEntity(List<GenTableBO> genTableList);

    /**
     * 代码生成表 持久化对象 转 代码生成表 实体
     * @param genTablePO 代码生成表 持久化对象
     * @return 代码生成表 实体
     */
    GenTableBO toEntityBO(GenTablePO genTablePO);

    /**
     * 代码生成表 持久化对象 转 代码生成表 实体
     * @param genTablePOList 代码生成表 持久化对象
     * @return 代码生成表 实体
     */
    List<GenTableBO> toEntityBO(List<GenTablePO> genTablePOList);

    /**
     * 代码生成表 持久化对象 转 代码生成表 查询响应数据传输对象
     * @param genTablePO 代码生成表 持久化对象
     * @return 代码生成表 查询响应数据传输对象
     */
    GenTableQueryVO toQueryVO(GenTablePO genTablePO);

    /**
     * 代码生成表 持久化对象列表 转 代码生成表 查询响应数据传输对象列表
     * @param genTablePOList 代码生成表 持久化对象列表
     * @return 代码生成表 查询响应数据传输对象列表
     */
    List<GenTableQueryVO> toQueryVO(List<GenTablePO> genTablePOList);
}
