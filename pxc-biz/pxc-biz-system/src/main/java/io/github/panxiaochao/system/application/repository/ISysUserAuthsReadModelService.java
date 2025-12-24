package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserauths.SysUserAuthsQueryVO;

import java.util.List;

/**
 * <p>
 * 系统管理-用户授权信息表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysUserAuthsReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-用户授权信息表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysUserAuthsQueryVO> page(Pagination pagination, SysUserAuthsPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-用户授权信息表 查询请求对象数组
     * @return 系统管理-用户授权信息表 结果数组
     */
    List<SysUserAuthsQueryVO> selectList(SysUserAuthsQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-用户授权信息表 查询请求对象
     * @return 系统管理-用户授权信息表 查询响应对象
     */
    SysUserAuthsQueryVO getOne(SysUserAuthsQueryDTO queryDto);

}
