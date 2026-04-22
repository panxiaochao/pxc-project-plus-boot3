package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.syspost.SysPostPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.syspost.SysPostQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.syspost.SysPostQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.syspost.SysPostVO;

import java.util.List;

/**
 * <p>
 * 系统管理-岗位表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysPostReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-岗位表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysPostQueryVO> page(Pagination pagination, SysPostPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-岗位表 查询请求对象数组
     * @return 系统管理-岗位表 结果数组
     */
    List<SysPostQueryVO> selectList(SysPostQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-岗位表 请求对象
     * @return 系统管理-岗位表 对象
     */
    SysPostVO getOne(SysPostQueryDTO queryDto);

    /**
     * 根据岗位编码查询单条记录
     * @param postCode 岗位编码
     * @return 系统管理-岗位表 查询响应对象
     */
    SysPostVO getOneByPostCode(String postCode);

}
