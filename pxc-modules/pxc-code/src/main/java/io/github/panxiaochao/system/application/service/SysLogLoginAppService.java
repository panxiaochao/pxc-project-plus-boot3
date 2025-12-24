package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.boot3.core.response.R;
import io.github.panxiaochao.boot3.core.response.page.PageResponse;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysloglogin.SysLogLoginQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysloglogin.SysLogLoginVO;
import io.github.panxiaochao.system.application.convert.ISysLogLoginDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysLogLoginReadModelService;
import io.github.panxiaochao.system.domain.entity.sysloglogin.SysLogLoginBO;
import io.github.panxiaochao.system.domain.repository.ISysLogLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统管理-系统日志登录/登出表 App服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysLogLoginAppService {

    /**
     * 系统管理-系统日志登录/登出表 Domain接口服务类
     */
    private final ISysLogLoginService sysLogLoginService;

    /**
     * 系统管理-系统日志登录/登出表 读模型服务类
     */
    private final ISysLogLoginReadModelService sysLogLoginReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-系统日志登录/登出表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysLogLoginQueryVO> page(SysLogLoginPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysLogLoginQueryVO> list = sysLogLoginReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysLogLoginVO> getById(Integer id) {
        SysLogLoginBO sysLogLogin = sysLogLoginService.getById(id);
        SysLogLoginVO sysLogLoginVO = ISysLogLoginDTOConvert.INSTANCE.toVO(sysLogLogin);
        return R.ok(sysLogLoginVO);
    }
    
    /**
     * 保存
     * @param sysLogLoginCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysLogLoginVO> save(SysLogLoginCreateDTO sysLogLoginCreateDTO) {
        SysLogLoginBO sysLogLogin = ISysLogLoginDTOConvert.INSTANCE.fromCreateDTO(sysLogLoginCreateDTO);
        sysLogLogin = sysLogLoginService.save(sysLogLogin);
        SysLogLoginVO sysLogLoginVO = ISysLogLoginDTOConvert.INSTANCE.toVO(sysLogLogin);
        return R.ok(sysLogLoginVO);
    }
    
    /**
     * 根据主键更新
     * @param sysLogLoginUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysLogLoginUpdateDTO sysLogLoginUpdateDTO) {
        SysLogLoginBO sysLogLogin = ISysLogLoginDTOConvert.INSTANCE.fromUpdateDTO(sysLogLoginUpdateDTO);
        sysLogLoginService.update(sysLogLogin);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysLogLoginService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysLogLoginService.deleteByIds(idList);
        return R.ok();
    }

}
