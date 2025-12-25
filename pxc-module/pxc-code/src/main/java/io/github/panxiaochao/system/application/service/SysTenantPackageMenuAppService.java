package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenantpackagemenu.SysTenantPackageMenuQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenantpackagemenu.SysTenantPackageMenuVO;
import io.github.panxiaochao.system.application.convert.ISysTenantPackageMenuDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.systenantpackagemenu.SysTenantPackageMenuBO;
import io.github.panxiaochao.system.domain.repository.ISysTenantPackageMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-租户套餐菜单表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageMenuAppService {

    /**
     * 系统管理-租户套餐菜单表 Domain接口服务类
     */
    private final ISysTenantPackageMenuService sysTenantPackageMenuService;

    /**
     * 系统管理-租户套餐菜单表 读模型服务类
     */
    private final ISysTenantPackageMenuReadModelService sysTenantPackageMenuReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-租户套餐菜单表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysTenantPackageMenuQueryVO> page(SysTenantPackageMenuPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysTenantPackageMenuQueryVO> list = sysTenantPackageMenuReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysTenantPackageMenuVO> getById(Integer id) {
        SysTenantPackageMenuBO sysTenantPackageMenu = sysTenantPackageMenuService.getById(id);
        SysTenantPackageMenuVO sysTenantPackageMenuVO = ISysTenantPackageMenuDTOConvert.INSTANCE
            .toVO(sysTenantPackageMenu);
        return R.ok(sysTenantPackageMenuVO);
    }

    /**
     * 保存
     * @param sysTenantPackageMenuCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysTenantPackageMenuVO> save(SysTenantPackageMenuCreateDTO sysTenantPackageMenuCreateDTO) {
        SysTenantPackageMenuBO sysTenantPackageMenu = ISysTenantPackageMenuDTOConvert.INSTANCE
            .fromCreateDTO(sysTenantPackageMenuCreateDTO);
        sysTenantPackageMenu = sysTenantPackageMenuService.save(sysTenantPackageMenu);
        SysTenantPackageMenuVO sysTenantPackageMenuVO = ISysTenantPackageMenuDTOConvert.INSTANCE
            .toVO(sysTenantPackageMenu);
        return R.ok(sysTenantPackageMenuVO);
    }

    /**
     * 根据主键更新
     * @param sysTenantPackageMenuUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysTenantPackageMenuUpdateDTO sysTenantPackageMenuUpdateDTO) {
        SysTenantPackageMenuBO sysTenantPackageMenu = ISysTenantPackageMenuDTOConvert.INSTANCE
            .fromUpdateDTO(sysTenantPackageMenuUpdateDTO);
        sysTenantPackageMenuService.update(sysTenantPackageMenu);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysTenantPackageMenuService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysTenantPackageMenuService.deleteByIds(idList);
        return R.ok();
    }

}
