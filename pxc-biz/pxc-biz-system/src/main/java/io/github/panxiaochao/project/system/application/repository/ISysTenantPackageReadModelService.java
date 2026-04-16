package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.systenantpackage.SysTenantPackagePageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.systenantpackage.SysTenantPackageQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.systenantpackage.SysTenantPackageVO;

import java.util.List;

/**
 * <p>
 * 系统管理-租户套餐表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysTenantPackageReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-租户套餐表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysTenantPackageQueryVO> page(Pagination pagination, SysTenantPackagePageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-租户套餐表 查询请求对象数组
     * @return 系统管理-租户套餐表 结果数组
     */
    List<SysTenantPackageQueryVO> selectList(SysTenantPackagePageQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-租户套餐表 请求对象
     * @return 系统管理-租户套餐表 对象
     */
    SysTenantPackageVO getOne(SysTenantPackagePageQueryDTO queryDto);

}
