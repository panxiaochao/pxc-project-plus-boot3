package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysarea.SysAreaCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysarea.SysAreaPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysarea.SysAreaUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysarea.SysAreaQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysarea.SysAreaVO;
import io.github.panxiaochao.system.application.convert.ISysAreaDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysAreaReadModelService;
import io.github.panxiaochao.system.domain.entity.sysarea.SysAreaBO;
import io.github.panxiaochao.system.domain.repository.ISysAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-全国5级行政区划 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysAreaAppService {

    /**
     * 系统管理-全国5级行政区划 Domain接口服务类
     */
    private final ISysAreaService sysAreaService;

    /**
     * 系统管理-全国5级行政区划 读模型服务类
     */
    private final ISysAreaReadModelService sysAreaReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-全国5级行政区划 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysAreaQueryVO> page(SysAreaPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysAreaQueryVO> list = sysAreaReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysAreaVO> getById(String id) {
        SysAreaBO sysArea = sysAreaService.getById(id);
        SysAreaVO sysAreaVO = ISysAreaDTOConvert.INSTANCE.toVO(sysArea);
        return R.ok(sysAreaVO);
    }
    
    /**
     * 保存
     * @param sysAreaCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysAreaVO> save(SysAreaCreateDTO sysAreaCreateDTO) {
        SysAreaBO sysArea = ISysAreaDTOConvert.INSTANCE.fromCreateDTO(sysAreaCreateDTO);
        sysArea = sysAreaService.save(sysArea);
        SysAreaVO sysAreaVO = ISysAreaDTOConvert.INSTANCE.toVO(sysArea);
        return R.ok(sysAreaVO);
    }
    
    /**
     * 根据主键更新
     * @param sysAreaUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysAreaUpdateDTO sysAreaUpdateDTO) {
        SysAreaBO sysArea = ISysAreaDTOConvert.INSTANCE.fromUpdateDTO(sysAreaUpdateDTO);
        sysAreaService.update(sysArea);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysAreaService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<String> idList) {
        sysAreaService.deleteByIds(idList);
        return R.ok();
    }

}
