package io.github.panxiaochao.project.system.application.service;

import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.common.response.page.PageResponse;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.boot3.component.select.Select;
import io.github.panxiaochao.boot3.component.select.SelectBuilder;
import io.github.panxiaochao.boot3.component.select.SelectOption;
import io.github.panxiaochao.boot3.utils.DictUtil;
import io.github.panxiaochao.boot3.utils.StrUtil;
import io.github.panxiaochao.boot3.utils.StringPools;
import io.github.panxiaochao.project.system.application.api.dto.sysuserauths.SysUserAuthsCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuserauths.SysUserAuthsPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuserauths.SysUserAuthsQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuserauths.SysUserAuthsUpdateDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysuserauths.SysUserAuthsQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysuserauths.SysUserAuthsVO;
import io.github.panxiaochao.project.system.application.convert.ISysUserAuthsDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysUserAuthsReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysuserauths.SysUserAuthsBO;
import io.github.panxiaochao.project.system.domain.repository.ISysUserAuthsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
     * 登录类型 常量名
     */
    private static final String IDENTITY_TYPE = "IDENTITY_TYPE";

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-用户授权信息表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserAuthsQueryVO> page(SysUserAuthsPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysUserAuthsQueryVO> list = sysUserAuthsReadModelService.page(pagination, pageQueryDTO);
        list.forEach(s -> {
            String identityTypeStr = DictUtil.getDictText(IDENTITY_TYPE, s.getIdentityType());
            if (StrUtil.isBlank(identityTypeStr)) {
                s.setIdentityTypeStr(StringPools.EMPTY);
            }
            else {
                s.setIdentityTypeStr(identityTypeStr);
            }
        });
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
        SysUserAuthsQueryDTO queryRequest = new SysUserAuthsQueryDTO();
        List<SysUserAuthsQueryVO> list = sysUserAuthsReadModelService.selectList(queryRequest);
        if (!CollectionUtils.isEmpty(list)) {
            // 1.先判断登录类型有没有创建过
            final SysUserAuthsBO finalSysUserAuths = sysUserAuths;
            boolean hasData = list.stream()
                .anyMatch(f -> f.getIdentityType().equals(finalSysUserAuths.getIdentityType())
                        && f.getUserId().equals(finalSysUserAuths.getUserId()));
            if (hasData) {
                String identityTypeStr = DictUtil.getDictText(IDENTITY_TYPE, finalSysUserAuths.getIdentityType());
                return R.fail("登录类型[" + identityTypeStr + "]已存在");
            }
            // 2.再判断登录类型和登录账号，其他用户有没有新建过
            hasData = list.stream()
                .anyMatch(f -> f.getIdentityType().equals(finalSysUserAuths.getIdentityType())
                        && f.getIdentifier().equals(finalSysUserAuths.getIdentifier()));
            if (hasData) {
                String identityTypeStr = DictUtil.getDictText(IDENTITY_TYPE, finalSysUserAuths.getIdentityType());
                return R.fail("登录类型[" + identityTypeStr + "]下，登录账号[" + finalSysUserAuths.getIdentifier() + "]已存在");
            }
        }
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
        // 既然要更新，用户下查询必定有数据，至少一条
        SysUserAuthsQueryDTO queryRequest = new SysUserAuthsQueryDTO();
        queryRequest.setUserId(sysUserAuths.getUserId());
        List<SysUserAuthsQueryVO> list = sysUserAuthsReadModelService.selectList(queryRequest);
        Optional<SysUserAuthsQueryVO> optionalSysUserAuths = list.stream()
            .filter(f -> f.getId().equals(sysUserAuths.getId())
                    && f.getIdentityType().equals(sysUserAuths.getIdentityType()))
            .findFirst();
        // 1.有数据说明是更新的是同一个登录类型
        // 2.没有数据说明换登录类型了，需要判断这个人，其他登录类型是否有重复
        if (optionalSysUserAuths.isEmpty()) {
            optionalSysUserAuths = list.stream()
                .filter(f -> f.getIdentityType().equals(sysUserAuths.getIdentityType()))
                .findFirst();
            // 有数据了
            if (optionalSysUserAuths.isPresent()) {
                String identityTypeStr = DictUtil.getDictText(IDENTITY_TYPE, sysUserAuths.getIdentityType());
                return R.fail("登录类型[" + identityTypeStr + "]已存在");
            }
        }
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

    /**
     * 获取登录类型下拉菜单
     * @return 返回通用下拉菜单
     */
    public List<Select<String>> selectIdentityTypes() {
        Map<String, String> dictMap = DictUtil.getAllDictByDictCode(IDENTITY_TYPE);
        List<SelectOption<String>> selectOptionList = dictMap.entrySet()
            .stream()
            .map(m -> SelectOption.of(m.getKey(), m.getValue(), m.getValue(),
                    (extraMap) -> extraMap.put("label", m.getValue())))
            .collect(Collectors.toList());
        List<Select<String>> selectList = SelectBuilder.of(selectOptionList).fastBuild().toSelectList();
        return CollectionUtils.isEmpty(selectList) ? new ArrayList<>() : selectList;
    }

}
