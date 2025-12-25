package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysloglogin.SysLogLoginQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysloglogin.SysLogLoginVO;
import io.github.panxiaochao.system.application.service.SysLogLoginAppService;
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
 * 系统管理-系统日志登录/登出表 接口.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Tag(name = "系统管理-系统日志登录/登出表 接口", description = "系统管理-系统日志登录/登出表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sys-log-login")
public class SysLogLoginApi {

    /**
     * 系统管理-系统日志登录/登出表 服务
     */
    private final SysLogLoginAppService sysLogLoginAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<SysLogLoginQueryVO>> page(@RequestBody SysLogLoginPageQueryDTO pageQueryDTO) {
        return R.ok(sysLogLoginAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "系统管理-系统日志登录/登出表 ID")
    @GetMapping(value = "/get")
    public R<SysLogLoginVO> getById(@RequestParam Integer id) {
        return sysLogLoginAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<SysLogLoginVO> save(@RequestBody SysLogLoginCreateDTO sysLogLoginCreateDTO) {
        return sysLogLoginAppService.save(sysLogLoginCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody SysLogLoginUpdateDTO sysLogLoginUpdateDTO) {
        return sysLogLoginAppService.update(sysLogLoginUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "系统管理-系统日志登录/登出表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(Integer id) {
        return sysLogLoginAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "系统管理-系统日志登录/登出表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<Integer> idList) {
        return sysLogLoginAppService.deleteByIds(idList);
    }

}
