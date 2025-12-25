package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenantpackage.SysTenantPackageCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackage.SysTenantPackagePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackage.SysTenantPackageUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenantpackage.SysTenantPackageQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenantpackage.SysTenantPackageVO;
import io.github.panxiaochao.system.application.convert.ISysTenantPackageDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageReadModelService;
import io.github.panxiaochao.system.domain.entity.systenantpackage.SysTenantPackageBO;
import io.github.panxiaochao.system.domain.repository.ISysTenantPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-租户套餐表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageAppService {

    /**
     * 系统管理-租户套餐表 Domain接口服务类
     */
    private final ISysTenantPackageService sysTenantPackageService;

    /**
     * 系统管理-租户套餐表 读模型服务类
     */
    private final ISysTenantPackageReadModelService sysTenantPackageReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-租户套餐表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysTenantPackageQueryVO> page(SysTenantPackagePageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysTenantPackageQueryVO> list = sysTenantPackageReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysTenantPackageVO> getById(Integer id) {
        SysTenantPackageBO sysTenantPackage = sysTenantPackageService.getById(id);
        SysTenantPackageVO sysTenantPackageVO = ISysTenantPackageDTOConvert.INSTANCE.toVO(sysTenantPackage);
        return R.ok(sysTenantPackageVO);
    }

    /**
     * 保存
     * @param sysTenantPackageCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysTenantPackageVO> save(SysTenantPackageCreateDTO sysTenantPackageCreateDTO) {
        SysTenantPackageBO sysTenantPackage = ISysTenantPackageDTOConvert.INSTANCE
            .fromCreateDTO(sysTenantPackageCreateDTO);
        sysTenantPackage = sysTenantPackageService.save(sysTenantPackage);
        SysTenantPackageVO sysTenantPackageVO = ISysTenantPackageDTOConvert.INSTANCE.toVO(sysTenantPackage);
        return R.ok(sysTenantPackageVO);
    }

    /**
     * 根据主键更新
     * @param sysTenantPackageUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysTenantPackageUpdateDTO sysTenantPackageUpdateDTO) {
        SysTenantPackageBO sysTenantPackage = ISysTenantPackageDTOConvert.INSTANCE
            .fromUpdateDTO(sysTenantPackageUpdateDTO);
        sysTenantPackageService.update(sysTenantPackage);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysTenantPackageService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysTenantPackageService.deleteByIds(idList);
        return R.ok();
    }

}
