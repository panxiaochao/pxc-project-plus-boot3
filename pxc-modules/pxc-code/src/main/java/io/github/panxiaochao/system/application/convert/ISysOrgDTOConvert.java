package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysorg.SysOrgUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysorg.SysOrgQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysorg.SysOrgVO;
import io.github.panxiaochao.system.domain.entity.sysorg.SysOrgBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-机构部门表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysOrgDTOConvert {

    /**
     * 系统管理-机构部门表 数据传输对象结构映射实例
     */
    ISysOrgDTOConvert INSTANCE = Mappers.getMapper(ISysOrgDTOConvert.class);

    /**
     * 系统管理-机构部门表 创建请求数据传输对象 转 系统管理-机构部门表 实体
     *
     * @param createDto 系统管理-机构部门表 创建请求数据传输对象
     * @return 系统管理-机构部门表 实体
     */
    SysOrgBO fromCreateDTO(SysOrgCreateDTO createDto);

    /**
     * 系统管理-机构部门表 更新请求数据传输对象 转 系统管理-机构部门表 实体
     *
     * @param updateDto 系统管理-机构部门表 更新请求数据传输对象
     * @return 系统管理-机构部门表 实体
     */
    SysOrgBO fromUpdateDTO(SysOrgUpdateDTO updateDto);

    /**
     * 系统管理-机构部门表 查询请求数据传输对象 转 系统管理-机构部门表 实体
     *
     * @param queryDto 系统管理-机构部门表 查询请求数据传输对象
     * @return 系统管理-机构部门表 实体
     */
    SysOrgBO fromQueryRequest(SysOrgQueryDTO queryDto);

    /**
     * 系统管理-机构部门表 实体 转 系统管理-机构部门表 响应数据传输对象
     *
     * @param sysOrg 系统管理-机构部门表 实体
     * @return 系统管理-机构部门表 响应数据传输对象
     */
    SysOrgVO toVO(SysOrgBO sysOrg);

    /**
     * 系统管理-机构部门表 实体 转 系统管理-机构部门表 查询响应数据传输对象
     *
     * @param sysOrg 系统管理-机构部门表 实体
     * @return 系统管理-机构部门表 查询响应数据传输对象
     */
    SysOrgQueryVO toQueryVO(SysOrgBO sysOrg);

    /**
     * 系统管理-机构部门表 实体列表 转 系统管理-机构部门表 查询响应数据传输对象列表
     *
     * @param sysOrgList 系统管理-机构部门表 实体列表
     * @return 系统管理-机构部门表 查询响应数据传输对象列表
     */
    List<SysOrgQueryVO> toQueryVO(List<SysOrgBO> sysOrgList);
}
