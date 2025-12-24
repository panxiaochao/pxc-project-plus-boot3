package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysdictitem.SysDictItemUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysdictitem.SysDictItemQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysdictitem.SysDictItemVO;
import io.github.panxiaochao.system.application.service.SysDictItemAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统管理-数据字典配置表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-数据字典配置表 接口", description = "系统管理-数据字典配置表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sys-dict-item")
public class SysDictItemApi {

    /**
     * 系统管理-数据字典配置表 服务
     */
    private final SysDictItemAppService sysDictItemAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysDictItemQueryVO>> page(@RequestBody SysDictItemPageQueryDTO pageQueryDTO) {
        return R.ok(sysDictItemAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-数据字典配置表 ID")
    @GetMapping(value = "/get")
    public R<SysDictItemVO> getById(@RequestParam Integer id) {
        return sysDictItemAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysDictItemVO> save(@RequestBody SysDictItemCreateDTO sysDictItemCreateDTO) {
        return sysDictItemAppService.save(sysDictItemCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysDictItemUpdateDTO sysDictItemUpdateDTO) {
        return sysDictItemAppService.update(sysDictItemUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-数据字典配置表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysDictItemAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-数据字典配置表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysDictItemAppService.deleteByIds(idList);
    }

}
