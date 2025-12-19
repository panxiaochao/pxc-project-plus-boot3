package io.github.panxiaochao.system.development.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableCreateDTO;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTablePageQueryDTO;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableUpdateDTO;
import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableQueryVO;
import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableVO;
import io.github.panxiaochao.system.development.application.convert.IGenTableDTOConvert;
import io.github.panxiaochao.system.development.application.repository.IGenTableReadModelService;
import io.github.panxiaochao.system.development.domain.entity.gentable.GenTableBO;
import io.github.panxiaochao.system.development.domain.service.GenTableDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>代码生成表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
@Service
@RequiredArgsConstructor
public class GenTableAppService {

    /**
     * 代码生成表 Domain服务类
     */
    private final GenTableDomainService genTableDomainService;

    /**
     * 代码生成表 读模型服务
     */
    private final IGenTableReadModelService genTableReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 代码生成表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<GenTableQueryVO> page(GenTablePageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<GenTableQueryVO> list = genTableReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<GenTableVO> getById(String id) {
        GenTableBO genTable = genTableDomainService.getById(id);
        GenTableVO genTableVO = IGenTableDTOConvert.INSTANCE.toVO(genTable);
        return R.ok(genTableVO);
    }
    
    /**
     * 保存
     * @param genTableCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<GenTableVO> save(GenTableCreateDTO genTableCreateDTO) {
        GenTableBO genTable = IGenTableDTOConvert.INSTANCE.fromCreateDTO(genTableCreateDTO);
        genTable = genTableDomainService.save(genTable);
        GenTableVO genTableVO = IGenTableDTOConvert.INSTANCE.toVO(genTable);
        return R.ok(genTableVO);
    }
    
    /**
     * 根据主键更新
     * @param genTableUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(GenTableUpdateDTO genTableUpdateDTO) {
        GenTableBO genTable = IGenTableDTOConvert.INSTANCE.fromUpdateDTO(genTableUpdateDTO);
        genTableDomainService.update(genTable);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        genTableDomainService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<String> idList) {
        genTableDomainService.deleteByIds(idList);
        return R.ok();
    }

}
