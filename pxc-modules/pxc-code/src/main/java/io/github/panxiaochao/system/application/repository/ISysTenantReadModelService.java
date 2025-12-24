package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantQueryDTO;
import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantQueryVO;

import java.util.List;

/**
 * <p>系统管理-租户表 读模型服务.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysTenantReadModelService {

    /**
     * 查询分页
     * @param pagination  分页属性对象
     * @param pageQueryDTO 系统管理-租户表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysTenantQueryVO> page(Pagination pagination, SysTenantPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-租户表 查询请求对象数组
     * @return 系统管理-租户表 结果数组
     */
    List<SysTenantQueryVO> selectList(SysTenantQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-租户表 查询请求对象
     * @return 系统管理-租户表 查询响应对象
     */
    SysTenantQueryVO getOne(SysTenantQueryDTO queryDto);

}
