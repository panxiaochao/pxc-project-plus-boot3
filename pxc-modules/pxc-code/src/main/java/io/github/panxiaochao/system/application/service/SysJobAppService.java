package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysjob.SysJobQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysjob.SysJobVO;
import io.github.panxiaochao.system.application.convert.ISysJobDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysJobReadModelService;
import io.github.panxiaochao.system.domain.entity.sysjob.SysJobBO;
import io.github.panxiaochao.system.domain.repository.ISysJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-定时任务调度表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysJobAppService {

    /**
     * 系统管理-定时任务调度表 Domain接口服务类
     */
    private final ISysJobService sysJobService;

    /**
     * 系统管理-定时任务调度表 读模型服务类
     */
    private final ISysJobReadModelService sysJobReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-定时任务调度表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysJobQueryVO> page(SysJobPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysJobQueryVO> list = sysJobReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysJobVO> getById(Integer id) {
        SysJobBO sysJob = sysJobService.getById(id);
        SysJobVO sysJobVO = ISysJobDTOConvert.INSTANCE.toVO(sysJob);
        return R.ok(sysJobVO);
    }
    
    /**
     * 保存
     * @param sysJobCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysJobVO> save(SysJobCreateDTO sysJobCreateDTO) {
        SysJobBO sysJob = ISysJobDTOConvert.INSTANCE.fromCreateDTO(sysJobCreateDTO);
        sysJob = sysJobService.save(sysJob);
        SysJobVO sysJobVO = ISysJobDTOConvert.INSTANCE.toVO(sysJob);
        return R.ok(sysJobVO);
    }
    
    /**
     * 根据主键更新
     * @param sysJobUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysJobUpdateDTO sysJobUpdateDTO) {
        SysJobBO sysJob = ISysJobDTOConvert.INSTANCE.fromUpdateDTO(sysJobUpdateDTO);
        sysJobService.update(sysJob);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysJobService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysJobService.deleteByIds(idList);
        return R.ok();
    }

}
