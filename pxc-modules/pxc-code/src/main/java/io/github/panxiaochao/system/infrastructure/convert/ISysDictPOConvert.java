package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.vo.sysdict.SysDictQueryVO;
import io.github.panxiaochao.system.domain.entity.sysdict.SysDictBO;
import io.github.panxiaochao.system.infrastructure.dao.po.SysDictPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-数据字典表 持久化对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysDictPOConvert {

    /**
     * 系统管理-数据字典表 持久化对象结构映射实例
     */
    ISysDictPOConvert INSTANCE = Mappers.getMapper(ISysDictPOConvert.class);

    /**
     * 系统管理-数据字典表 实体 转 系统管理-数据字典表 持久化对象
     * @param sysDict 系统管理-数据字典表 实体
     * @return 系统管理-数据字典表 持久化对象
     */
    SysDictPO fromEntity(SysDictBO sysDict);

    /**
     * 系统管理-数据字典表 实体 转 系统管理-数据字典表 持久化对象
     * @param sysDictList 系统管理-数据字典表 实体
     * @return 系统管理-数据字典表 持久化对象
     */
    List<SysDictPO> fromEntity(List<SysDictBO> sysDictList);

    /**
     * 系统管理-数据字典表 持久化对象 转 系统管理-数据字典表 实体
     * @param sysDictPO 系统管理-数据字典表 持久化对象
     * @return 系统管理-数据字典表 实体
     */
    SysDictBO toEntityBO(SysDictPO sysDictPO);

    /**
     * 系统管理-数据字典表 持久化对象 转 系统管理-数据字典表 实体
     * @param sysDictPOList 系统管理-数据字典表 持久化对象
     * @return 系统管理-数据字典表 实体
     */
    List<SysDictBO> toEntityBO(List<SysDictPO> sysDictPOList);

    /**
     * 系统管理-数据字典表 持久化对象 转 系统管理-数据字典表 查询响应数据传输对象
     * @param sysDictPO 系统管理-数据字典表 持久化对象
     * @return 系统管理-数据字典表 查询响应数据传输对象
     */
    SysDictQueryVO toQueryVO(SysDictPO sysDictPO);

    /**
     * 系统管理-数据字典表 持久化对象列表 转 系统管理-数据字典表 查询响应数据传输对象列表
     * @param sysDictPOList 系统管理-数据字典表 持久化对象列表
     * @return 系统管理-数据字典表 查询响应数据传输对象列表
     */
    List<SysDictQueryVO> toQueryVO(List<SysDictPO> sysDictPOList);
}
