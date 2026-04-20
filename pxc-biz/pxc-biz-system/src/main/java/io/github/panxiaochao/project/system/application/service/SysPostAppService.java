package io.github.panxiaochao.project.system.application.service;

import io.github.panxiaochao.boot3.common.constants.CommonConstant;
import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.common.response.page.PageResponse;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.boot3.component.select.Select;
import io.github.panxiaochao.boot3.component.select.SelectBuilder;
import io.github.panxiaochao.boot3.component.select.SelectOption;
import io.github.panxiaochao.project.system.application.api.dto.syspost.SysPostCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.syspost.SysPostPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.syspost.SysPostUpdateDTO;
import io.github.panxiaochao.project.system.application.api.vo.syspost.SysPostQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.syspost.SysPostVO;
import io.github.panxiaochao.project.system.application.convert.ISysPostDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysPostReadModelService;
import io.github.panxiaochao.project.system.domain.entity.syspost.SysPostBO;
import io.github.panxiaochao.project.system.domain.repository.ISysPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统管理-岗位表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysPostAppService {

    /**
     * 系统管理-岗位表 Domain接口服务类
     */
    private final ISysPostService sysPostService;

    /**
     * 系统管理-岗位表 读模型服务类
     */
    private final ISysPostReadModelService sysPostReadModelService;

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-岗位表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysPostQueryVO> page(SysPostPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysPostQueryVO> list = sysPostReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysPostVO> getById(Integer id) {
        SysPostBO sysPost = sysPostService.getById(id);
        SysPostVO sysPostVO = ISysPostDTOConvert.INSTANCE.toVO(sysPost);
        return R.ok(sysPostVO);
    }

    /**
     * 保存
     * @param sysPostCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysPostVO> save(SysPostCreateDTO sysPostCreateDTO) {
        SysPostBO sysPost = ISysPostDTOConvert.INSTANCE.fromCreateDTO(sysPostCreateDTO);
        // 验证是否重复
        SysPostPageQueryDTO queryRequest = new SysPostPageQueryDTO();
        queryRequest.setPostCode(sysPost.getPostCode());
        queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
        SysPostVO one = sysPostReadModelService.getOne(queryRequest);
        if (Objects.nonNull(one)) {
            return R.fail("岗位编码[" + sysPost.getPostCode() + "]已存在");
        }
        sysPost = sysPostService.save(sysPost);
        SysPostVO sysPostVO = ISysPostDTOConvert.INSTANCE.toVO(sysPost);
        return R.ok(sysPostVO);
    }

    /**
     * 根据主键更新
     * @param sysPostUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysPostUpdateDTO sysPostUpdateDTO) {
        SysPostBO sysPost = ISysPostDTOConvert.INSTANCE.fromUpdateDTO(sysPostUpdateDTO);
        // 验证是否重复
        SysPostPageQueryDTO queryRequest = new SysPostPageQueryDTO();
        queryRequest.setStatus(CommonConstant.STATUS_NORMAL.toString());
        List<SysPostQueryVO> list = sysPostReadModelService.selectList(queryRequest);
        Optional<SysPostQueryVO> optionalSysPostQueryVO = list.stream()
            .filter(f -> f.getId().equals(sysPost.getId()) && f.getPostCode().equals(sysPost.getPostCode()))
            .findFirst();
        // 没有数据，说明岗位编码变动了，需要判断岗位编码是否有重复
        if (optionalSysPostQueryVO.isEmpty()) {
            optionalSysPostQueryVO = list.stream()
                .filter(f -> !f.getId().equals(sysPost.getId()) && f.getPostCode().equals(sysPost.getPostCode()))
                .findFirst();
            // 有数据，说明重复
            if (optionalSysPostQueryVO.isPresent()) {
                return R.fail("岗位编码[" + sysPost.getPostCode() + "]已存在");
            }
        }
        sysPostService.update(sysPost);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        sysPostService.deleteById(id);
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        sysPostService.deleteByIds(idList);
        return R.ok();
    }

    /**
     * 获取岗位下拉菜单
     * @return 返回通用下拉菜单
     */
    public List<Select<String>> selectPosts() {
        List<SysPostQueryVO> list = sysPostReadModelService.selectList(new SysPostPageQueryDTO());
        List<SelectOption<String>> selectOptionList = list.stream()
            .map(m -> SelectOption.of(m.getPostCode(), m.getPostName(), m.getSort(),
                    (extraMap) -> extraMap.put("label", m.getPostName())))
            .collect(Collectors.toList());
        List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
        return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
    }

}
