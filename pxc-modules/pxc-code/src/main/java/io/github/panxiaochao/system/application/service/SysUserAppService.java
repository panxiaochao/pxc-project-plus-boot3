package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuser.SysUserQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuser.SysUserVO;
import io.github.panxiaochao.system.application.convert.ISysUserDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuser.SysUserBO;
import io.github.panxiaochao.system.domain.repository.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-用户表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserAppService {

    /**
     * 系统管理-用户表 Domain接口服务类
     */
    private final ISysUserService sysUserService;

    /**
     * 系统管理-用户表 读模型服务类
     */
    private final ISysUserReadModelService sysUserReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-用户表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserQueryVO> page(SysUserPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysUserQueryVO> list = sysUserReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysUserVO> getById(Integer id) {
        SysUserBO sysUser = sysUserService.getById(id);
        SysUserVO sysUserVO = ISysUserDTOConvert.INSTANCE.toVO(sysUser);
        return R.ok(sysUserVO);
    }

    /**
     * 保存
     * @param sysUserCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysUserVO> save(SysUserCreateDTO sysUserCreateDTO) {
        SysUserBO sysUser = ISysUserDTOConvert.INSTANCE.fromCreateDTO(sysUserCreateDTO);
        sysUser = sysUserService.save(sysUser);
        SysUserVO sysUserVO = ISysUserDTOConvert.INSTANCE.toVO(sysUser);
        return R.ok(sysUserVO);
    }

    /**
     * 根据主键更新
     * @param sysUserUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysUserUpdateDTO sysUserUpdateDTO) {
        SysUserBO sysUser = ISysUserDTOConvert.INSTANCE.fromUpdateDTO(sysUserUpdateDTO);
        sysUserService.update(sysUser);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysUserService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysUserService.deleteByIds(idList);
        return R.ok();
    }

}
