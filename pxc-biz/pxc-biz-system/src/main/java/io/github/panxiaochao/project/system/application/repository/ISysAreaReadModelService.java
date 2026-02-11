package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysarea.SysAreaPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysarea.SysAreaQueryVO;

import java.util.List;

/**
 * <p>
 * 系统管理-全国5级行政区划 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-02-11
 */
public interface ISysAreaReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-全国5级行政区划 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysAreaQueryVO> page(Pagination pagination, SysAreaPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-全国5级行政区划 查询请求对象数组
     * @return 系统管理-全国5级行政区划 结果数组
     */
    List<SysAreaQueryVO> selectList(SysAreaPageQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-全国5级行政区划 查询请求对象
     * @return 系统管理-全国5级行政区划 查询响应对象
     */
    SysAreaQueryVO getOne(SysAreaPageQueryDTO queryDto);

}
