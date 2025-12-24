package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysorg.SysOrgQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysorg.SysOrgVO;
import io.github.panxiaochao.system.application.convert.ISysOrgDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysOrgReadModelService;
import io.github.panxiaochao.system.domain.entity.sysorg.SysOrgBO;
import io.github.panxiaochao.system.domain.repository.ISysOrgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-机构部门表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysOrgAppService {

    /**
     * 系统管理-机构部门表 Domain接口服务类
     */
    private final ISysOrgService sysOrgService;

    /**
     * 系统管理-机构部门表 读模型服务类
     */
    private final ISysOrgReadModelService sysOrgReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-机构部门表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysOrgQueryVO> page(SysOrgPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysOrgQueryVO> list = sysOrgReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysOrgVO> getById(Integer id) {
        SysOrgBO sysOrg = sysOrgService.getById(id);
        SysOrgVO sysOrgVO = ISysOrgDTOConvert.INSTANCE.toVO(sysOrg);
        return R.ok(sysOrgVO);
    }

    /**
     * 保存
     * @param sysOrgCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysOrgVO> save(SysOrgCreateDTO sysOrgCreateDTO) {
        SysOrgBO sysOrg = ISysOrgDTOConvert.INSTANCE.fromCreateDTO(sysOrgCreateDTO);
        sysOrg = sysOrgService.save(sysOrg);
        SysOrgVO sysOrgVO = ISysOrgDTOConvert.INSTANCE.toVO(sysOrg);
        return R.ok(sysOrgVO);
    }

    /**
     * 根据主键更新
     * @param sysOrgUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysOrgUpdateDTO sysOrgUpdateDTO) {
        SysOrgBO sysOrg = ISysOrgDTOConvert.INSTANCE.fromUpdateDTO(sysOrgUpdateDTO);
        sysOrgService.update(sysOrg);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysOrgService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysOrgService.deleteByIds(idList);
        return R.ok();
    }

}
