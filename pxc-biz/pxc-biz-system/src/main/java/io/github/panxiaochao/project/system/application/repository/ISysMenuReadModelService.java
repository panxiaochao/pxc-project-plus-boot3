package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysmenu.SysMenuPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysmenu.SysMenuQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysmenu.SysMenuQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysmenu.SysMenuVO;

import java.util.List;

/**
 * <p>
 * 系统管理-菜单配置 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysMenuReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-菜单配置 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysMenuQueryVO> page(Pagination pagination, SysMenuPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-菜单配置 查询请求对象数组
     * @return 系统管理-菜单配置 结果数组
     */
    List<SysMenuQueryVO> selectList(SysMenuQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-菜单配置 请求对象
     * @return 系统管理-菜单配置 对象
     */
    SysMenuVO getOne(SysMenuQueryDTO queryDto);

}
