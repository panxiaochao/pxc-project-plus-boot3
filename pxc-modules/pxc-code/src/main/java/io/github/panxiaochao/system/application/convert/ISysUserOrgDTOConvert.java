package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserorg.SysUserOrgQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysuserorg.SysUserOrgVO;
import io.github.panxiaochao.system.domain.entity.sysuserorg.SysUserOrgBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-用户机构/部门表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysUserOrgDTOConvert {

    /**
     * 系统管理-用户机构/部门表 数据传输对象结构映射实例
     */
    ISysUserOrgDTOConvert INSTANCE = Mappers.getMapper(ISysUserOrgDTOConvert.class);

    /**
     * 系统管理-用户机构/部门表 创建请求数据传输对象 转 系统管理-用户机构/部门表 实体
     *
     * @param createDto 系统管理-用户机构/部门表 创建请求数据传输对象
     * @return 系统管理-用户机构/部门表 实体
     */
    SysUserOrgBO fromCreateDTO(SysUserOrgCreateDTO createDto);

    /**
     * 系统管理-用户机构/部门表 更新请求数据传输对象 转 系统管理-用户机构/部门表 实体
     *
     * @param updateDto 系统管理-用户机构/部门表 更新请求数据传输对象
     * @return 系统管理-用户机构/部门表 实体
     */
    SysUserOrgBO fromUpdateDTO(SysUserOrgUpdateDTO updateDto);

    /**
     * 系统管理-用户机构/部门表 查询请求数据传输对象 转 系统管理-用户机构/部门表 实体
     *
     * @param queryDto 系统管理-用户机构/部门表 查询请求数据传输对象
     * @return 系统管理-用户机构/部门表 实体
     */
    SysUserOrgBO fromQueryRequest(SysUserOrgQueryDTO queryDto);

    /**
     * 系统管理-用户机构/部门表 实体 转 系统管理-用户机构/部门表 响应数据传输对象
     *
     * @param sysUserOrg 系统管理-用户机构/部门表 实体
     * @return 系统管理-用户机构/部门表 响应数据传输对象
     */
    SysUserOrgVO toVO(SysUserOrgBO sysUserOrg);

    /**
     * 系统管理-用户机构/部门表 实体 转 系统管理-用户机构/部门表 查询响应数据传输对象
     *
     * @param sysUserOrg 系统管理-用户机构/部门表 实体
     * @return 系统管理-用户机构/部门表 查询响应数据传输对象
     */
    SysUserOrgQueryVO toQueryVO(SysUserOrgBO sysUserOrg);

    /**
     * 系统管理-用户机构/部门表 实体列表 转 系统管理-用户机构/部门表 查询响应数据传输对象列表
     *
     * @param sysUserOrgList 系统管理-用户机构/部门表 实体列表
     * @return 系统管理-用户机构/部门表 查询响应数据传输对象列表
     */
    List<SysUserOrgQueryVO> toQueryVO(List<SysUserOrgBO> sysUserOrgList);
}
