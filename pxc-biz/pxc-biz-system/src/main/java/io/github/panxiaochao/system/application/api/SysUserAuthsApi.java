package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserauths.SysUserAuthsQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserauths.SysUserAuthsVO;
import io.github.panxiaochao.system.application.service.SysUserAuthsAppService;
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
 * 系统管理-用户授权信息表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-用户授权信息表 接口", description = "系统管理-用户授权信息表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sysuserauths")
public class SysUserAuthsApi {

    /**
     * 系统管理-用户授权信息表 服务
     */
    private final SysUserAuthsAppService sysUserAuthsAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysUserAuthsQueryVO>> page(@RequestBody SysUserAuthsPageQueryDTO pageQueryDTO) {
        return R.ok(sysUserAuthsAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-用户授权信息表 ID")
    @GetMapping(value = "/get")
    public R<SysUserAuthsVO> getById(@RequestParam Integer id) {
        return sysUserAuthsAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysUserAuthsVO> save(@RequestBody SysUserAuthsCreateDTO sysUserAuthsCreateDTO) {
        return sysUserAuthsAppService.save(sysUserAuthsCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysUserAuthsUpdateDTO sysUserAuthsUpdateDTO) {
        return sysUserAuthsAppService.update(sysUserAuthsUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-用户授权信息表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysUserAuthsAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-用户授权信息表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysUserAuthsAppService.deleteByIds(idList);
    }

}
