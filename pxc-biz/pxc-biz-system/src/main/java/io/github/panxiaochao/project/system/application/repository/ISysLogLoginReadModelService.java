package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysloglogin.SysLogLoginPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysloglogin.SysLogLoginQueryVO;

import java.util.List;

/**
 * <p>
 * 系统管理-系统日志登录/登出表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-02-11
 */
public interface ISysLogLoginReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-系统日志登录/登出表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysLogLoginQueryVO> page(Pagination pagination, SysLogLoginPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-系统日志登录/登出表 查询请求对象数组
     * @return 系统管理-系统日志登录/登出表 结果数组
     */
    List<SysLogLoginQueryVO> selectList(SysLogLoginPageQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-系统日志登录/登出表 查询请求对象
     * @return 系统管理-系统日志登录/登出表 查询响应对象
     */
    SysLogLoginQueryVO getOne(SysLogLoginPageQueryDTO queryDto);

}
