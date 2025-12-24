package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserorg.SysUserOrgQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserorg.SysUserOrgVO;
import io.github.panxiaochao.system.application.service.SysUserOrgAppService;
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
 * 系统管理-用户机构/部门表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-用户机构/部门表 接口", description = "系统管理-用户机构/部门表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sysuserorg")
public class SysUserOrgApi {

    /**
     * 系统管理-用户机构/部门表 服务
     */
    private final SysUserOrgAppService sysUserOrgAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysUserOrgQueryVO>> page(@RequestBody SysUserOrgPageQueryDTO pageQueryDTO) {
        return R.ok(sysUserOrgAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-用户机构/部门表 ID")
    @GetMapping(value = "/get")
    public R<SysUserOrgVO> getById(@RequestParam Integer id) {
        return sysUserOrgAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysUserOrgVO> save(@RequestBody SysUserOrgCreateDTO sysUserOrgCreateDTO) {
        return sysUserOrgAppService.save(sysUserOrgCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysUserOrgUpdateDTO sysUserOrgUpdateDTO) {
        return sysUserOrgAppService.update(sysUserOrgUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-用户机构/部门表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysUserOrgAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-用户机构/部门表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysUserOrgAppService.deleteByIds(idList);
    }

}
