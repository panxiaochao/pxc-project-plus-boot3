package ${application}.repository;

import io.github.panxiaochao.boot3.common.response.page.Pagination;
import ${application}.api.dto.${entity?lower_case}.${entity}PageQueryDTO;
import ${application}.api.dto.${entity?lower_case}.${entity}QueryDTO;
import ${application}.api.vo.${entity?lower_case}.${entity}QueryVO;
import ${application}.api.vo.${entity?lower_case}.${entity}VO;

import java.util.List;

/**
 * <p>${table.comment!} 读模型服务.</p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface I${entity}ReadModelService {

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO ${table.comment!} 分页查询请求对象
     * @return 分页结果数组
     */
    List<${entity}QueryVO> page(Pagination pagination, ${entity}PageQueryDTO pageQueryDTO);

    /**
     * 查询数组
     * @param queryDto ${table.comment!} 查询请求对象数组
     * @return ${table.comment!} 结果数组
     */
    List<${entity}QueryVO> selectList(${entity}QueryDTO queryDto);

    /**
     * 查询单条记录
     * @param queryDto ${table.comment!} 请求对象
     * @return ${table.comment!} 对象
     */
    ${entity}VO getOne(${entity}QueryDTO queryDto);

}
