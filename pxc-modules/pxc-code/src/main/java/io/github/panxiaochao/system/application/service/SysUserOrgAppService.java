package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserorg.SysUserOrgQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserorg.SysUserOrgVO;
import io.github.panxiaochao.system.application.convert.ISysUserOrgDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserOrgReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuserorg.SysUserOrgBO;
import io.github.panxiaochao.system.domain.repository.ISysUserOrgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-用户机构/部门表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserOrgAppService {

    /**
     * 系统管理-用户机构/部门表 Domain接口服务类
     */
    private final ISysUserOrgService sysUserOrgService;

    /**
     * 系统管理-用户机构/部门表 读模型服务类
     */
    private final ISysUserOrgReadModelService sysUserOrgReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-用户机构/部门表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserOrgQueryVO> page(SysUserOrgPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysUserOrgQueryVO> list = sysUserOrgReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysUserOrgVO> getById(Integer id) {
        SysUserOrgBO sysUserOrg = sysUserOrgService.getById(id);
        SysUserOrgVO sysUserOrgVO = ISysUserOrgDTOConvert.INSTANCE.toVO(sysUserOrg);
        return R.ok(sysUserOrgVO);
    }
    
    /**
     * 保存
     * @param sysUserOrgCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysUserOrgVO> save(SysUserOrgCreateDTO sysUserOrgCreateDTO) {
        SysUserOrgBO sysUserOrg = ISysUserOrgDTOConvert.INSTANCE.fromCreateDTO(sysUserOrgCreateDTO);
        sysUserOrg = sysUserOrgService.save(sysUserOrg);
        SysUserOrgVO sysUserOrgVO = ISysUserOrgDTOConvert.INSTANCE.toVO(sysUserOrg);
        return R.ok(sysUserOrgVO);
    }
    
    /**
     * 根据主键更新
     * @param sysUserOrgUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysUserOrgUpdateDTO sysUserOrgUpdateDTO) {
        SysUserOrgBO sysUserOrg = ISysUserOrgDTOConvert.INSTANCE.fromUpdateDTO(sysUserOrgUpdateDTO);
        sysUserOrgService.update(sysUserOrg);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysUserOrgService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysUserOrgService.deleteByIds(idList);
        return R.ok();
    }

}
