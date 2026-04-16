package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysparam.SysParamPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysparam.SysParamQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysparam.SysParamVO;

import java.util.List;

/**
 * <p>
 * 系统管理-系统参数 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysParamReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-系统参数 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysParamQueryVO> page(Pagination pagination, SysParamPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-系统参数 查询请求对象数组
     * @return 系统管理-系统参数 结果数组
     */
    List<SysParamQueryVO> selectList(SysParamPageQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-系统参数 请求对象
     * @return 系统管理-系统参数 对象
     */
    SysParamVO getOne(SysParamPageQueryDTO queryDto);

}
