package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenantuser.SysTenantUserCreateDTO;
import io.github.panxiaochao.system.application.api.dto.systenantuser.SysTenantUserPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantuser.SysTenantUserUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.systenantuser.SysTenantUserQueryVO;
import io.github.panxiaochao.system.application.api.vo.systenantuser.SysTenantUserVO;
import io.github.panxiaochao.system.application.convert.ISysTenantUserDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysTenantUserReadModelService;
import io.github.panxiaochao.system.domain.entity.systenantuser.SysTenantUserBO;
import io.github.panxiaochao.system.domain.repository.ISysTenantUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-租户用户表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysTenantUserAppService {

    /**
     * 系统管理-租户用户表 Domain接口服务类
     */
    private final ISysTenantUserService sysTenantUserService;

    /**
     * 系统管理-租户用户表 读模型服务类
     */
    private final ISysTenantUserReadModelService sysTenantUserReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-租户用户表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysTenantUserQueryVO> page(SysTenantUserPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysTenantUserQueryVO> list = sysTenantUserReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysTenantUserVO> getById(Integer id) {
        SysTenantUserBO sysTenantUser = sysTenantUserService.getById(id);
        SysTenantUserVO sysTenantUserVO = ISysTenantUserDTOConvert.INSTANCE.toVO(sysTenantUser);
        return R.ok(sysTenantUserVO);
    }
    
    /**
     * 保存
     * @param sysTenantUserCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysTenantUserVO> save(SysTenantUserCreateDTO sysTenantUserCreateDTO) {
        SysTenantUserBO sysTenantUser = ISysTenantUserDTOConvert.INSTANCE.fromCreateDTO(sysTenantUserCreateDTO);
        sysTenantUser = sysTenantUserService.save(sysTenantUser);
        SysTenantUserVO sysTenantUserVO = ISysTenantUserDTOConvert.INSTANCE.toVO(sysTenantUser);
        return R.ok(sysTenantUserVO);
    }
    
    /**
     * 根据主键更新
     * @param sysTenantUserUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysTenantUserUpdateDTO sysTenantUserUpdateDTO) {
        SysTenantUserBO sysTenantUser = ISysTenantUserDTOConvert.INSTANCE.fromUpdateDTO(sysTenantUserUpdateDTO);
        sysTenantUserService.update(sysTenantUser);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysTenantUserService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysTenantUserService.deleteByIds(idList);
        return R.ok();
    }

}
