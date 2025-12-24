package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.sysparam.SysParamCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysparam.SysParamPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysparam.SysParamUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysparam.SysParamQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysparam.SysParamVO;
import io.github.panxiaochao.system.application.service.SysParamAppService;
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
 * 系统管理-系统参数 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-系统参数 接口", description = "系统管理-系统参数 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sys-param")
public class SysParamApi {

    /**
     * 系统管理-系统参数 服务
     */
    private final SysParamAppService sysParamAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysParamQueryVO>> page(@RequestBody SysParamPageQueryDTO pageQueryDTO) {
        return R.ok(sysParamAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-系统参数 ID")
    @GetMapping(value = "/get")
    public R<SysParamVO> getById(@RequestParam Integer id) {
        return sysParamAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysParamVO> save(@RequestBody SysParamCreateDTO sysParamCreateDTO) {
        return sysParamAppService.save(sysParamCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysParamUpdateDTO sysParamUpdateDTO) {
        return sysParamAppService.update(sysParamUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-系统参数 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysParamAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-系统参数 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysParamAppService.deleteByIds(idList);
    }

}
