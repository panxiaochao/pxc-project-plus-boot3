package io.github.panxiaochao.project.system.application.service;

import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.common.response.page.PageResponse;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.boot3.utils.DictUtil;
import io.github.panxiaochao.project.common.core.constants.GlobalConstant;
import io.github.panxiaochao.project.common.core.constants.GlobalRedisConstant;
import io.github.panxiaochao.project.system.application.api.dto.sysparam.SysParamCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysparam.SysParamPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysparam.SysParamQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysparam.SysParamUpdateDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysparam.SysParamQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysparam.SysParamVO;
import io.github.panxiaochao.project.system.application.convert.ISysParamDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysParamReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysparam.SysParamBO;
import io.github.panxiaochao.project.system.domain.repository.ISysParamService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统管理-系统参数 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysParamAppService {

    /**
     * 系统管理-系统参数 Domain接口服务类
     */
    private final ISysParamService sysParamService;

    /**
     * 系统管理-系统参数 读模型服务类
     */
    private final ISysParamReadModelService sysParamReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-系统参数 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysParamQueryVO> page(SysParamPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysParamQueryVO> list = sysParamReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysParamVO> getById(Integer id) {
        SysParamBO sysParam = sysParamService.getById(id);
        SysParamVO sysParamVO = ISysParamDTOConvert.INSTANCE.toVO(sysParam);
        return R.ok(sysParamVO);
    }

    /**
     * 保存
     * @param sysParamCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysParamVO> save(SysParamCreateDTO sysParamCreateDTO) {
        SysParamBO sysParam = ISysParamDTOConvert.INSTANCE.fromCreateDTO(sysParamCreateDTO);
        sysParam = sysParamService.save(sysParam);
        SysParamVO sysParamVO = ISysParamDTOConvert.INSTANCE.toVO(sysParam);
        return R.ok(sysParamVO);
    }

    /**
     * 根据主键更新
     * @param sysParamUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysParamUpdateDTO sysParamUpdateDTO) {
        SysParamBO sysParam = ISysParamDTOConvert.INSTANCE.fromUpdateDTO(sysParamUpdateDTO);
        sysParamService.update(sysParam);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysParamService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysParamService.deleteByIds(idList);
        return R.ok();
    }

    /**
     * 发布数据字典
     */
    @Async
    public void publishedData() {
        SysParamQueryDTO queryDto = new SysParamQueryDTO();
        queryDto.setStatus(GlobalConstant.STATUS_NORMAL);
        List<SysParamQueryVO> list = sysParamReadModelService.selectList(queryDto);
        // 按照 paramType 分组，并转换为 Map<String, Map<String, String>>
        // @formatter:off
        Map<String, Map<String, Map<String, String>>> dictMap = list.stream()
            .collect(Collectors.groupingBy(SysParamQueryVO::getParamKey,
                    Collectors.toMap(
                            item -> GlobalRedisConstant.KEY_SYS_PARAM + item.getParamKey(),
                            item ->  Map.of(item.getParamKey(), item.getParamValue())  ,
                            (a, b) -> a,
                            LinkedHashMap::new)));
        // @formatter:on
        // 加载所有数据字典
        dictMap.forEach((key, value) -> DictUtil.loadAllDict(GlobalRedisConstant.KEY_SYS_PARAM, value));
    }

}
