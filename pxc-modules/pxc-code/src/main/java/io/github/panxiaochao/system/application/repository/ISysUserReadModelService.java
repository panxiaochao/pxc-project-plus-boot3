package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysuser.SysUserQueryVO;

import java.util.List;

/**
 * <p>
 * 系统管理-用户表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysUserReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-用户表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysUserQueryVO> page(Pagination pagination, SysUserPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-用户表 查询请求对象数组
     * @return 系统管理-用户表 结果数组
     */
    List<SysUserQueryVO> selectList(SysUserQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-用户表 查询请求对象
     * @return 系统管理-用户表 查询响应对象
     */
    SysUserQueryVO getOne(SysUserQueryDTO queryDto);

}
