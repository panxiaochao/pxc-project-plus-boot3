package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserpost.SysUserPostQueryVO;

import java.util.List;

/**
 * <p>系统管理-用户岗位关联表 读模型服务.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
public interface ISysUserPostReadModelService {

    /**
     * 查询分页
     * @param pagination  分页属性对象
     * @param pageQueryDTO 系统管理-用户岗位关联表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysUserPostQueryVO> page(Pagination pagination, SysUserPostPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-用户岗位关联表 查询请求对象数组
     * @return 系统管理-用户岗位关联表 结果数组
     */
    List<SysUserPostQueryVO> selectList(SysUserPostQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-用户岗位关联表 查询请求对象
     * @return 系统管理-用户岗位关联表 查询响应对象
     */
    SysUserPostQueryVO getOne(SysUserPostQueryDTO queryDto);

}
