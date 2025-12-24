package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserauths.SysUserAuthsUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserauths.SysUserAuthsQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserauths.SysUserAuthsVO;
import io.github.panxiaochao.system.application.convert.ISysUserAuthsDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserAuthsReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuserauths.SysUserAuthsBO;
import io.github.panxiaochao.system.domain.repository.ISysUserAuthsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-用户授权信息表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserAuthsAppService {

    /**
     * 系统管理-用户授权信息表 Domain接口服务类
     */
    private final ISysUserAuthsService sysUserAuthsService;

    /**
     * 系统管理-用户授权信息表 读模型服务类
     */
    private final ISysUserAuthsReadModelService sysUserAuthsReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-用户授权信息表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserAuthsQueryVO> page(SysUserAuthsPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysUserAuthsQueryVO> list = sysUserAuthsReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysUserAuthsVO> getById(Integer id) {
        SysUserAuthsBO sysUserAuths = sysUserAuthsService.getById(id);
        SysUserAuthsVO sysUserAuthsVO = ISysUserAuthsDTOConvert.INSTANCE.toVO(sysUserAuths);
        return R.ok(sysUserAuthsVO);
    }

    /**
     * 保存
     * @param sysUserAuthsCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysUserAuthsVO> save(SysUserAuthsCreateDTO sysUserAuthsCreateDTO) {
        SysUserAuthsBO sysUserAuths = ISysUserAuthsDTOConvert.INSTANCE.fromCreateDTO(sysUserAuthsCreateDTO);
        sysUserAuths = sysUserAuthsService.save(sysUserAuths);
        SysUserAuthsVO sysUserAuthsVO = ISysUserAuthsDTOConvert.INSTANCE.toVO(sysUserAuths);
        return R.ok(sysUserAuthsVO);
    }

    /**
     * 根据主键更新
     * @param sysUserAuthsUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysUserAuthsUpdateDTO sysUserAuthsUpdateDTO) {
        SysUserAuthsBO sysUserAuths = ISysUserAuthsDTOConvert.INSTANCE.fromUpdateDTO(sysUserAuthsUpdateDTO);
        sysUserAuthsService.update(sysUserAuths);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysUserAuthsService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysUserAuthsService.deleteByIds(idList);
        return R.ok();
    }

}
