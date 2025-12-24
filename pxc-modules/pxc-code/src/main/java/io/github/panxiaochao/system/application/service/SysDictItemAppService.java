package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysdictitem.SysDictItemQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysdictitem.SysDictItemVO;
import io.github.panxiaochao.system.application.convert.ISysDictItemDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysDictItemReadModelService;
import io.github.panxiaochao.system.domain.entity.sysdictitem.SysDictItemBO;
import io.github.panxiaochao.system.domain.repository.ISysDictItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-数据字典配置表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysDictItemAppService {

    /**
     * 系统管理-数据字典配置表 Domain接口服务类
     */
    private final ISysDictItemService sysDictItemService;

    /**
     * 系统管理-数据字典配置表 读模型服务类
     */
    private final ISysDictItemReadModelService sysDictItemReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-数据字典配置表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysDictItemQueryVO> page(SysDictItemPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysDictItemQueryVO> list = sysDictItemReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysDictItemVO> getById(Integer id) {
        SysDictItemBO sysDictItem = sysDictItemService.getById(id);
        SysDictItemVO sysDictItemVO = ISysDictItemDTOConvert.INSTANCE.toVO(sysDictItem);
        return R.ok(sysDictItemVO);
    }

    /**
     * 保存
     * @param sysDictItemCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysDictItemVO> save(SysDictItemCreateDTO sysDictItemCreateDTO) {
        SysDictItemBO sysDictItem = ISysDictItemDTOConvert.INSTANCE.fromCreateDTO(sysDictItemCreateDTO);
        sysDictItem = sysDictItemService.save(sysDictItem);
        SysDictItemVO sysDictItemVO = ISysDictItemDTOConvert.INSTANCE.toVO(sysDictItem);
        return R.ok(sysDictItemVO);
    }

    /**
     * 根据主键更新
     * @param sysDictItemUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysDictItemUpdateDTO sysDictItemUpdateDTO) {
        SysDictItemBO sysDictItem = ISysDictItemDTOConvert.INSTANCE.fromUpdateDTO(sysDictItemUpdateDTO);
        sysDictItemService.update(sysDictItem);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysDictItemService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysDictItemService.deleteByIds(idList);
        return R.ok();
    }

}
