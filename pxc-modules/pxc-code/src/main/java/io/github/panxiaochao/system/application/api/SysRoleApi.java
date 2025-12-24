package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRoleCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRolePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRoleUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysrole.SysRoleQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysrole.SysRoleVO;
import io.github.panxiaochao.system.application.service.SysRoleAppService;
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
 * <p>系统管理-角色表 接口.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-角色表 接口", description = "系统管理-角色表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sysrole")
public class SysRoleApi {

    /**
     * 系统管理-角色表 服务
     */
    private final SysRoleAppService sysRoleAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysRoleQueryVO>> page(@RequestBody SysRolePageQueryDTO pageQueryDTO) {
        return R.ok(sysRoleAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-角色表 ID")
    @GetMapping(value = "/get")
    public R<SysRoleVO> getById(@RequestParam Integer id) {
        return sysRoleAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysRoleVO> save(@RequestBody SysRoleCreateDTO sysRoleCreateDTO) {
        return sysRoleAppService.save(sysRoleCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysRoleUpdateDTO sysRoleUpdateDTO) {
        return sysRoleAppService.update(sysRoleUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-角色表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysRoleAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-角色表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysRoleAppService.deleteByIds(idList);
    }

}
