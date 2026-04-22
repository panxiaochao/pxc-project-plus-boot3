package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysarea.SysAreaPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysarea.SysAreaQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysarea.SysAreaQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysarea.SysAreaVO;

import java.util.List;

/**
 * <p>
 * 系统管理-全国5级行政区划 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
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
    List<SysAreaQueryVO> selectList(SysAreaQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-全国5级行政区划 请求对象
     * @return 系统管理-全国5级行政区划 对象
     */
    SysAreaVO getOne(SysAreaQueryDTO queryDto);

    /**
     * 定制查询列表
     * @param queryDto 全国5级行政区划查询请求对象
     * @return 查询列表
     */
    List<SysAreaQueryVO> listTree(SysAreaPageQueryDTO queryDto);

}
