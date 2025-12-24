package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantVO;
import io.github.panxiaochao.system.application.convert.ISysTenantDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantReadModelService;
import io.github.panxiaochao.system.domain.entity.systenant.SysTenantBO;
import io.github.panxiaochao.system.domain.repository.ISysTenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-租户表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysTenantAppService {

    /**
     * 系统管理-租户表 Domain接口服务类
     */
    private final ISysTenantService sysTenantService;

    /**
     * 系统管理-租户表 读模型服务类
     */
    private final ISysTenantReadModelService sysTenantReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-租户表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysTenantQueryVO> page(SysTenantPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysTenantQueryVO> list = sysTenantReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysTenantVO> getById(Integer id) {
        SysTenantBO sysTenant = sysTenantService.getById(id);
        SysTenantVO sysTenantVO = ISysTenantDTOConvert.INSTANCE.toVO(sysTenant);
        return R.ok(sysTenantVO);
    }
    
    /**
     * 保存
     * @param sysTenantCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysTenantVO> save(SysTenantCreateDTO sysTenantCreateDTO) {
        SysTenantBO sysTenant = ISysTenantDTOConvert.INSTANCE.fromCreateDTO(sysTenantCreateDTO);
        sysTenant = sysTenantService.save(sysTenant);
        SysTenantVO sysTenantVO = ISysTenantDTOConvert.INSTANCE.toVO(sysTenant);
        return R.ok(sysTenantVO);
    }
    
    /**
     * 根据主键更新
     * @param sysTenantUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysTenantUpdateDTO sysTenantUpdateDTO) {
        SysTenantBO sysTenant = ISysTenantDTOConvert.INSTANCE.fromUpdateDTO(sysTenantUpdateDTO);
        sysTenantService.update(sysTenant);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysTenantService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysTenantService.deleteByIds(idList);
        return R.ok();
    }

}
