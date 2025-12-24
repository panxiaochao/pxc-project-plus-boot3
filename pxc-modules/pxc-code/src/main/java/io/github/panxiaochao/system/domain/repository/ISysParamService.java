package io.github.panxiaochao.system.domain.repository;

import io.github.panxiaochao.system.domain.entity.sysparam.SysParamBO;

import java.util.List;

/**
 * <p>
 * 系统管理-系统参数 Domain接口服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysParamService {

    /**
     * 详情
     * @param id 主键
     * @return 系统管理-系统参数 实体
     */
    SysParamBO getById(Integer id);

    /**
     * 保存
     * @param sysParam 系统管理-系统参数 实体
     * @return 系统管理-系统参数 实体
     */
    SysParamBO save(SysParamBO sysParam);

    /**
     * 批量保存
     * @param sysParamList 批量数据
     */
    List<SysParamBO> saveBatch(List<SysParamBO> sysParamList);

    /**
     * 根据主键更新
     * @param sysParam 系统管理-系统参数 实体
     */
    void update(SysParamBO sysParam);

    /**
     * 批量更新
     * @param sysParamList 批量数据
     */
    void updateBatch(List<SysParamBO> sysParamList);

    /**
     * 根据主键删除
     * @param id 主键
     */
    void deleteById(Integer id);

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    void deleteByIds(List<Integer> idList);

}
