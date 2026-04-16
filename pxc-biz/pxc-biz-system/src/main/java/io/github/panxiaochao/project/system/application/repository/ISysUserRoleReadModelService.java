package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysuserrole.SysUserRolePageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysuserrole.SysUserRoleQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysuserrole.SysUserRoleVO;

import java.util.List;

/**
 * <p>
 * 系统管理-用户角色表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysUserRoleReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-用户角色表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysUserRoleQueryVO> page(Pagination pagination, SysUserRolePageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-用户角色表 查询请求对象数组
     * @return 系统管理-用户角色表 结果数组
     */
    List<SysUserRoleQueryVO> selectList(SysUserRolePageQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-用户角色表 请求对象
     * @return 系统管理-用户角色表 对象
     */
    SysUserRoleVO getOne(SysUserRolePageQueryDTO queryDto);

}
