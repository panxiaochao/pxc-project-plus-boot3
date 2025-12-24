package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.syslogoperate.SysLogOperateCreateDTO;
import io.github.panxiaochao.system.application.api.dto.syslogoperate.SysLogOperatePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.syslogoperate.SysLogOperateUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.syslogoperate.SysLogOperateQueryVO;
import io.github.panxiaochao.system.application.api.vo.syslogoperate.SysLogOperateVO;
import io.github.panxiaochao.system.application.convert.ISysLogOperateDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysLogOperateReadModelService;
import io.github.panxiaochao.system.domain.entity.syslogoperate.SysLogOperateBO;
import io.github.panxiaochao.system.domain.repository.ISysLogOperateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-系统日志操作表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysLogOperateAppService {

    /**
     * 系统管理-系统日志操作表 Domain接口服务类
     */
    private final ISysLogOperateService sysLogOperateService;

    /**
     * 系统管理-系统日志操作表 读模型服务类
     */
    private final ISysLogOperateReadModelService sysLogOperateReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-系统日志操作表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysLogOperateQueryVO> page(SysLogOperatePageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysLogOperateQueryVO> list = sysLogOperateReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysLogOperateVO> getById(Integer id) {
        SysLogOperateBO sysLogOperate = sysLogOperateService.getById(id);
        SysLogOperateVO sysLogOperateVO = ISysLogOperateDTOConvert.INSTANCE.toVO(sysLogOperate);
        return R.ok(sysLogOperateVO);
    }
    
    /**
     * 保存
     * @param sysLogOperateCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysLogOperateVO> save(SysLogOperateCreateDTO sysLogOperateCreateDTO) {
        SysLogOperateBO sysLogOperate = ISysLogOperateDTOConvert.INSTANCE.fromCreateDTO(sysLogOperateCreateDTO);
        sysLogOperate = sysLogOperateService.save(sysLogOperate);
        SysLogOperateVO sysLogOperateVO = ISysLogOperateDTOConvert.INSTANCE.toVO(sysLogOperate);
        return R.ok(sysLogOperateVO);
    }
    
    /**
     * 根据主键更新
     * @param sysLogOperateUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysLogOperateUpdateDTO sysLogOperateUpdateDTO) {
        SysLogOperateBO sysLogOperate = ISysLogOperateDTOConvert.INSTANCE.fromUpdateDTO(sysLogOperateUpdateDTO);
        sysLogOperateService.update(sysLogOperate);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysLogOperateService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysLogOperateService.deleteByIds(idList);
        return R.ok();
    }

}
