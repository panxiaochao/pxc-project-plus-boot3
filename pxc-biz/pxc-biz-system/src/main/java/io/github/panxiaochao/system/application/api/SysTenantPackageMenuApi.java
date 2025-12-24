package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenantpackagemenu.SysTenantPackageMenuQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenantpackagemenu.SysTenantPackageMenuVO;
import io.github.panxiaochao.system.application.service.SysTenantPackageMenuAppService;
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
 * 系统管理-租户套餐菜单表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-租户套餐菜单表 接口", description = "系统管理-租户套餐菜单表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sys-tenant-package-menu")
public class SysTenantPackageMenuApi {

    /**
     * 系统管理-租户套餐菜单表 服务
     */
    private final SysTenantPackageMenuAppService sysTenantPackageMenuAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysTenantPackageMenuQueryVO>> page(
            @RequestBody SysTenantPackageMenuPageQueryDTO pageQueryDTO) {
        return R.ok(sysTenantPackageMenuAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-租户套餐菜单表 ID")
    @GetMapping(value = "/get")
    public R<SysTenantPackageMenuVO> getById(@RequestParam Integer id) {
        return sysTenantPackageMenuAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysTenantPackageMenuVO> save(@RequestBody SysTenantPackageMenuCreateDTO sysTenantPackageMenuCreateDTO) {
        return sysTenantPackageMenuAppService.save(sysTenantPackageMenuCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysTenantPackageMenuUpdateDTO sysTenantPackageMenuUpdateDTO) {
        return sysTenantPackageMenuAppService.update(sysTenantPackageMenuUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-租户套餐菜单表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysTenantPackageMenuAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-租户套餐菜单表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysTenantPackageMenuAppService.deleteByIds(idList);
    }

}
