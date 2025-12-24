package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysarea.SysAreaBO;

import java.util.List;

/**
 * <p>系统管理-全国5级行政区划 Domain接口服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysAreaService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-全国5级行政区划 实体
     */
    SysAreaBO getById(String id);
    
    /**
     * 保存
     * @param sysArea 系统管理-全国5级行政区划 实体
     * @return 系统管理-全国5级行政区划 实体
     */
    SysAreaBO save(SysAreaBO sysArea);

    /**
     * 批量保存
     * @param sysAreaList 批量数据
     */
    List<SysAreaBO> saveBatch(List<SysAreaBO> sysAreaList);
    
    /**
     * 根据主键更新
     * @param sysArea 系统管理-全国5级行政区划 实体
     */
    void update(SysAreaBO sysArea);

    /**
     * 批量更新
     * @param sysAreaList 批量数据
     */
    void updateBatch(List<SysAreaBO> sysAreaList);

    /**
     * 根据主键删除
     * @param id 主键
     */
    void deleteById(String id);

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    void deleteByIds(List<String> idList);
}
