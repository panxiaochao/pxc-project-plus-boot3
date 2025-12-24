package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysmenu.SysMenuCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysmenu.SysMenuPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysmenu.SysMenuUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysmenu.SysMenuQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysmenu.SysMenuVO;
import io.github.panxiaochao.system.application.convert.ISysMenuDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.sysmenu.SysMenuBO;
import io.github.panxiaochao.system.domain.repository.ISysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-菜单配置 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysMenuAppService {

    /**
     * 系统管理-菜单配置 Domain接口服务类
     */
    private final ISysMenuService sysMenuService;

    /**
     * 系统管理-菜单配置 读模型服务类
     */
    private final ISysMenuReadModelService sysMenuReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-菜单配置 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysMenuQueryVO> page(SysMenuPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysMenuQueryVO> list = sysMenuReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysMenuVO> getById(Integer id) {
        SysMenuBO sysMenu = sysMenuService.getById(id);
        SysMenuVO sysMenuVO = ISysMenuDTOConvert.INSTANCE.toVO(sysMenu);
        return R.ok(sysMenuVO);
    }
    
    /**
     * 保存
     * @param sysMenuCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysMenuVO> save(SysMenuCreateDTO sysMenuCreateDTO) {
        SysMenuBO sysMenu = ISysMenuDTOConvert.INSTANCE.fromCreateDTO(sysMenuCreateDTO);
        sysMenu = sysMenuService.save(sysMenu);
        SysMenuVO sysMenuVO = ISysMenuDTOConvert.INSTANCE.toVO(sysMenu);
        return R.ok(sysMenuVO);
    }
    
    /**
     * 根据主键更新
     * @param sysMenuUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysMenuUpdateDTO sysMenuUpdateDTO) {
        SysMenuBO sysMenu = ISysMenuDTOConvert.INSTANCE.fromUpdateDTO(sysMenuUpdateDTO);
        sysMenuService.update(sysMenu);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysMenuService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysMenuService.deleteByIds(idList);
        return R.ok();
    }

}
