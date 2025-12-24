package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserpost.SysUserPostQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserpost.SysUserPostVO;
import io.github.panxiaochao.system.application.convert.ISysUserPostDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserPostReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuserpost.SysUserPostBO;
import io.github.panxiaochao.system.domain.repository.ISysUserPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-用户岗位关联表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserPostAppService {

    /**
     * 系统管理-用户岗位关联表 Domain接口服务类
     */
    private final ISysUserPostService sysUserPostService;

    /**
     * 系统管理-用户岗位关联表 读模型服务类
     */
    private final ISysUserPostReadModelService sysUserPostReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-用户岗位关联表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserPostQueryVO> page(SysUserPostPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysUserPostQueryVO> list = sysUserPostReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysUserPostVO> getById(Integer id) {
        SysUserPostBO sysUserPost = sysUserPostService.getById(id);
        SysUserPostVO sysUserPostVO = ISysUserPostDTOConvert.INSTANCE.toVO(sysUserPost);
        return R.ok(sysUserPostVO);
    }
    
    /**
     * 保存
     * @param sysUserPostCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysUserPostVO> save(SysUserPostCreateDTO sysUserPostCreateDTO) {
        SysUserPostBO sysUserPost = ISysUserPostDTOConvert.INSTANCE.fromCreateDTO(sysUserPostCreateDTO);
        sysUserPost = sysUserPostService.save(sysUserPost);
        SysUserPostVO sysUserPostVO = ISysUserPostDTOConvert.INSTANCE.toVO(sysUserPost);
        return R.ok(sysUserPostVO);
    }
    
    /**
     * 根据主键更新
     * @param sysUserPostUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysUserPostUpdateDTO sysUserPostUpdateDTO) {
        SysUserPostBO sysUserPost = ISysUserPostDTOConvert.INSTANCE.fromUpdateDTO(sysUserPostUpdateDTO);
        sysUserPostService.update(sysUserPost);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysUserPostService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysUserPostService.deleteByIds(idList);
        return R.ok();
    }

}
