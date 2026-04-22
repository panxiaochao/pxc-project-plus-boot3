package io.github.panxiaochao.project.system.application.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysdictitem.SysDictItemPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysdictitem.SysDictItemQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysdictitem.SysDictItemQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysdictitem.SysDictItemVO;

import java.util.List;

/**
 * <p>
 * 系统管理-数据字典配置表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
public interface ISysDictItemReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-数据字典配置表 分页查询请求对象
     * @return 分页结果数组
     */
    List<SysDictItemQueryVO> page(Pagination pagination, SysDictItemPageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 系统管理-数据字典配置表 查询请求对象数组
     * @return 系统管理-数据字典配置表 结果数组
     */
    List<SysDictItemQueryVO> selectList(SysDictItemQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 系统管理-数据字典配置表 请求对象
     * @return 系统管理-数据字典配置表 对象
     */
    SysDictItemVO getOne(SysDictItemQueryDTO queryDto);

}
