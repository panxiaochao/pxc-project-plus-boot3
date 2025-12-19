package io.github.panxiaochao.system.development.application.api;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableCreateDTO;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTablePageQueryDTO;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableUpdateDTO;
import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableQueryVO;
import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableVO;
import io.github.panxiaochao.system.development.application.service.GenTableAppService;
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
 * <p>代码生成表 接口.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
@Tag(name = "代码生成表 接口", description = "代码生成表 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/development/v1/gentable")
public class GenTableApi {

    /**
     * 代码生成表 服务
     */
    private final GenTableAppService genTableAppService;

    @Operation(summary = "查询分页", description = "查询分页")
    @PostMapping(value = "/page")
    public R<PageResponse<GenTableQueryVO>> page(@RequestBody GenTablePageQueryDTO pageQueryDTO) {
        return R.ok(genTableAppService.page(pageQueryDTO));
    }

    @Operation(summary = "获取详情", description = "获取详情")
    @Parameter(name = "id", description = "代码生成表 ID")
    @GetMapping(value = "/get")
    public R<GenTableVO> getById(@RequestParam String id) {
        return genTableAppService.getById(id);
    }

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public R<GenTableVO> save(@RequestBody GenTableCreateDTO genTableCreateDTO) {
        return genTableAppService.save(genTableCreateDTO);
    }

    @Operation(summary = "更新", description = "根据主键更新")
    @PutMapping
    public R<Void> update(@RequestBody GenTableUpdateDTO genTableUpdateDTO) {
        return genTableAppService.update(genTableUpdateDTO);
    }

    @Operation(summary = "删除", description = "根据主键删除")
    @Parameter(name = "id", description = "代码生成表 ID")
    @PostMapping(value = "/delete")
    public R<Void> deleteById(String id) {
        return genTableAppService.deleteById(id);
    }

    @Operation(summary = "批量删除", description = "根据主键数组删除")
    @Parameter(name = "idList", description = "代码生成表 ID数组")
    @PostMapping(value = "/deleteBatch")
    public R<Void> deleteByIds(List<String> idList) {
        return genTableAppService.deleteByIds(idList);
    }

}
