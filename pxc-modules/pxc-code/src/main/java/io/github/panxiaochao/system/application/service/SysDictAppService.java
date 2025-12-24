package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysdict.SysDictCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysdict.SysDictPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysdict.SysDictUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysdict.SysDictQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysdict.SysDictVO;
import io.github.panxiaochao.system.application.convert.ISysDictDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysDictReadModelService;
import io.github.panxiaochao.system.domain.entity.sysdict.SysDictBO;
import io.github.panxiaochao.system.domain.repository.ISysDictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-数据字典表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysDictAppService {

    /**
     * 系统管理-数据字典表 Domain接口服务类
     */
    private final ISysDictService sysDictService;

    /**
     * 系统管理-数据字典表 读模型服务类
     */
    private final ISysDictReadModelService sysDictReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-数据字典表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysDictQueryVO> page(SysDictPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysDictQueryVO> list = sysDictReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysDictVO> getById(Integer id) {
        SysDictBO sysDict = sysDictService.getById(id);
        SysDictVO sysDictVO = ISysDictDTOConvert.INSTANCE.toVO(sysDict);
        return R.ok(sysDictVO);
    }
    
    /**
     * 保存
     * @param sysDictCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysDictVO> save(SysDictCreateDTO sysDictCreateDTO) {
        SysDictBO sysDict = ISysDictDTOConvert.INSTANCE.fromCreateDTO(sysDictCreateDTO);
        sysDict = sysDictService.save(sysDict);
        SysDictVO sysDictVO = ISysDictDTOConvert.INSTANCE.toVO(sysDict);
        return R.ok(sysDictVO);
    }
    
    /**
     * 根据主键更新
     * @param sysDictUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysDictUpdateDTO sysDictUpdateDTO) {
        SysDictBO sysDict = ISysDictDTOConvert.INSTANCE.fromUpdateDTO(sysDictUpdateDTO);
        sysDictService.update(sysDict);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysDictService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysDictService.deleteByIds(idList);
        return R.ok();
    }

}
