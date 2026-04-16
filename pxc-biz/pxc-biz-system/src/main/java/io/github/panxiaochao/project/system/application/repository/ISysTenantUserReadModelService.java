package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.systenantuser.SysTenantUserPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.systenantuser.SysTenantUserQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.systenantuser.SysTenantUserVO;

import java.util.List;

/**
 * <p>
 * 系统管理-租户用户表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysTenantUserReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-租户用户表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysTenantUserQueryVO> page(Pagination pagination, SysTenantUserPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-租户用户表 查询请求对象数组
     * @return 系统管理-租户用户表 结果数组
     */
    List<SysTenantUserQueryVO> selectList(SysTenantUserPageQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-租户用户表 请求对象
     * @return 系统管理-租户用户表 对象
     */
    SysTenantUserVO getOne(SysTenantUserPageQueryDTO queryDto);

}
