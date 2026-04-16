package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysdict.SysDictPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysdict.SysDictQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysdict.SysDictVO;

import java.util.List;

/**
 * <p>
 * 系统管理-数据字典表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysDictReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-数据字典表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysDictQueryVO> page(Pagination pagination, SysDictPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-数据字典表 查询请求对象数组
     * @return 系统管理-数据字典表 结果数组
     */
    List<SysDictQueryVO> selectList(SysDictPageQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-数据字典表 请求对象
     * @return 系统管理-数据字典表 对象
     */
    SysDictVO getOne(SysDictPageQueryDTO queryDto);

}
