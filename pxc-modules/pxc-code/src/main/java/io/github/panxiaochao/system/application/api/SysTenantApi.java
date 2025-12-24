package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantVO;
import io.github.panxiaochao.system.application.service.SysTenantAppService;
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
 * <p>系统管理-租户表 接口.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-租户表 接口", description = "系统管理-租户表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/systenant")
public class SysTenantApi {

    /**
     * 系统管理-租户表 服务
     */
    private final SysTenantAppService sysTenantAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysTenantQueryVO>> page(@RequestBody SysTenantPageQueryDTO pageQueryDTO) {
        return R.ok(sysTenantAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-租户表 ID")
    @GetMapping(value = "/get")
    public R<SysTenantVO> getById(@RequestParam Integer id) {
        return sysTenantAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysTenantVO> save(@RequestBody SysTenantCreateDTO sysTenantCreateDTO) {
        return sysTenantAppService.save(sysTenantCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysTenantUpdateDTO sysTenantUpdateDTO) {
        return sysTenantAppService.update(sysTenantUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-租户表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysTenantAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-租户表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysTenantAppService.deleteByIds(idList);
    }

}
