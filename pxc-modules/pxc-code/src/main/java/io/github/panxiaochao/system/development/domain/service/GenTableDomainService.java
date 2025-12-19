package io.github.panxiaochao.system.development.domain.service;

import io.github.panxiaochao.system.development.domain.entity.gentable.GenTableBO;
import io.github.panxiaochao.system.development.domain.repository.IGenTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>代码生成表 Domain服务类.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
@Service
@RequiredArgsConstructor
public class GenTableDomainService {

    /**
     * GenTableBO Domain接口服务类
     */
    private final IGenTableService genTableService;

    public GenTableBO getById(String id) {
        return genTableService.getById(id);
    }

    public GenTableBO save(GenTableBO genTable) {
        return genTableService.save(genTable);
    }

    public List<GenTableBO> saveBatch(List<GenTableBO> genTableList) {
        return genTableService.saveBatch(genTableList);
    }

    public void update(GenTableBO genTable) {
        genTableService.update(genTable);
    }

    public void updateBatch(List<GenTableBO> genTableList) {
        genTableService.updateBatch(genTableList);
    }

    public void deleteById(String id) {
        genTableService.deleteById(id);
    }

    public void deleteByIds(List<String> idList) {
        genTableService.deleteByIds(idList);
    }

}
