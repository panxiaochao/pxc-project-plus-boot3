package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysjob.SysJobQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysjob.SysJobVO;
import io.github.panxiaochao.system.application.service.SysJobAppService;
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
 * 系统管理-定时任务调度表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-定时任务调度表 接口", description = "系统管理-定时任务调度表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sys-job")
public class SysJobApi {

    /**
     * 系统管理-定时任务调度表 服务
     */
    private final SysJobAppService sysJobAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysJobQueryVO>> page(@RequestBody SysJobPageQueryDTO pageQueryDTO) {
        return R.ok(sysJobAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-定时任务调度表 ID")
    @GetMapping(value = "/get")
    public R<SysJobVO> getById(@RequestParam Integer id) {
        return sysJobAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysJobVO> save(@RequestBody SysJobCreateDTO sysJobCreateDTO) {
        return sysJobAppService.save(sysJobCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysJobUpdateDTO sysJobUpdateDTO) {
        return sysJobAppService.update(sysJobUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-定时任务调度表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysJobAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-定时任务调度表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysJobAppService.deleteByIds(idList);
    }

}
