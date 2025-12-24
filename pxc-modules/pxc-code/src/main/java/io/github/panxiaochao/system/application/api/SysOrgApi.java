package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysorg.SysOrgQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysorg.SysOrgVO;
import io.github.panxiaochao.system.application.service.SysOrgAppService;
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
 * <p>系统管理-机构部门表 接口.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-机构部门表 接口", description = "系统管理-机构部门表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sysorg")
public class SysOrgApi {

    /**
     * 系统管理-机构部门表 服务
     */
    private final SysOrgAppService sysOrgAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysOrgQueryVO>> page(@RequestBody SysOrgPageQueryDTO pageQueryDTO) {
        return R.ok(sysOrgAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-机构部门表 ID")
    @GetMapping(value = "/get")
    public R<SysOrgVO> getById(@RequestParam Integer id) {
        return sysOrgAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysOrgVO> save(@RequestBody SysOrgCreateDTO sysOrgCreateDTO) {
        return sysOrgAppService.save(sysOrgCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysOrgUpdateDTO sysOrgUpdateDTO) {
        return sysOrgAppService.update(sysOrgUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-机构部门表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysOrgAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-机构部门表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysOrgAppService.deleteByIds(idList);
    }

}
