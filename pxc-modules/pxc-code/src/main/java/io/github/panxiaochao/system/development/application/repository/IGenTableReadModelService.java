package io.github.panxiaochao.system.development.application.repository;

import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTablePageQueryDTO;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableQueryDTO;
import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableQueryVO;

import java.util.List;

/**
 * <p>代码生成表 读模型服务.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
public interface IGenTableReadModelService {

    /**
     * 查询分页
     * @param pagination  分页属性对象
     * @param pageQueryDTO 代码生成表 分页查询请求对象
     * @return 分页结果数组
     */
    List<GenTableQueryVO> page(Pagination pagination, GenTablePageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto 代码生成表 查询请求对象数组
     * @return 代码生成表 结果数组
     */
    List<GenTableQueryVO> selectList(GenTableQueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto 代码生成表 查询请求对象
     * @return 代码生成表 查询响应对象
     */
    GenTableQueryVO getOne(GenTableQueryDTO queryDto);

}
