package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysdictitem.SysDictItemQueryVO;
import io.github.panxiaochao.system.domain.entity.sysdictitem.SysDictItemBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysDictItemPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统管理-数据字典配置表 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysDictItemPOConvert {

    /**
     * 系统管理-数据字典配置表 持久化对象结构映射实例
     */
    ISysDictItemPOConvert INSTANCE = Mappers.getMapper(ISysDictItemPOConvert.class);

    /**
     * 系统管理-数据字典配置表 实体 转 系统管理-数据字典配置表 持久化对象
     * @param sysDictItem 系统管理-数据字典配置表 实体
     * @return 系统管理-数据字典配置表 持久化对象
     */
    SysDictItemPO fromEntity(SysDictItemBO sysDictItem);

    /**
     * 系统管理-数据字典配置表 实体 转 系统管理-数据字典配置表 持久化对象
     * @param sysDictItemList 系统管理-数据字典配置表 实体
     * @return 系统管理-数据字典配置表 持久化对象
     */
    List<SysDictItemPO> fromEntity(List<SysDictItemBO> sysDictItemList);

    /**
     * 系统管理-数据字典配置表 持久化对象 转 系统管理-数据字典配置表 实体
     * @param sysDictItemPO 系统管理-数据字典配置表 持久化对象
     * @return 系统管理-数据字典配置表 实体
     */
    SysDictItemBO toEntityBO(SysDictItemPO sysDictItemPO);

    /**
     * 系统管理-数据字典配置表 持久化对象 转 系统管理-数据字典配置表 实体
     * @param sysDictItemPOList 系统管理-数据字典配置表 持久化对象
     * @return 系统管理-数据字典配置表 实体
     */
    List<SysDictItemBO> toEntityBO(List<SysDictItemPO> sysDictItemPOList);

    /**
     * 系统管理-数据字典配置表 持久化对象 转 系统管理-数据字典配置表 查询响应数据传输对象
     * @param sysDictItemPO 系统管理-数据字典配置表 持久化对象
     * @return 系统管理-数据字典配置表 查询响应数据传输对象
     */
    SysDictItemQueryVO toQueryVO(SysDictItemPO sysDictItemPO);

    /**
     * 系统管理-数据字典配置表 持久化对象列表 转 系统管理-数据字典配置表 查询响应数据传输对象列表
     * @param sysDictItemPOList 系统管理-数据字典配置表 持久化对象列表
     * @return 系统管理-数据字典配置表 查询响应数据传输对象列表
     */
    List<SysDictItemQueryVO> toQueryVO(List<SysDictItemPO> sysDictItemPOList);

}
