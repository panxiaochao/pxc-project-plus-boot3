package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysrole.SysRolePageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysrole.SysRoleQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysrole.SysRoleQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysrole.SysRoleVO;

import java.util.List;

/**
 * <p>
 * 系统管理-角色表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysRoleReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-角色表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysRoleQueryVO> page(Pagination pagination, SysRolePageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-角色表 查询请求对象数组
     * @return 系统管理-角色表 结果数组
     */
    List<SysRoleQueryVO> selectList(SysRoleQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-角色表 请求对象
     * @return 系统管理-角色表 对象
     */
    SysRoleVO getOne(SysRoleQueryDTO queryDto);

}
