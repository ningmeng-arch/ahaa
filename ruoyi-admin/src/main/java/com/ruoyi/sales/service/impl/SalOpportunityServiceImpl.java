package com.ruoyi.sales.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sales.mapper.SalOpportunityMapper;
import com.ruoyi.sales.domain.SalOpportunity;
import com.ruoyi.sales.service.ISalOpportunityService;

/**
 * 销售机会管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-13
 */
@Service
public class SalOpportunityServiceImpl implements ISalOpportunityService 
{
    @Autowired
    private SalOpportunityMapper salOpportunityMapper;

    /**
     * 查询销售机会管理
     * 
     * @param opportunityId 销售机会管理主键
     * @return 销售机会管理
     */
    @Override
    public SalOpportunity selectSalOpportunityByOpportunityId(Long opportunityId)
    {
        return salOpportunityMapper.selectSalOpportunityByOpportunityId(opportunityId);
    }

    /**
     * 查询销售机会管理列表
     * 
     * @param salOpportunity 销售机会管理
     * @return 销售机会管理
     */
    @Override
    public List<SalOpportunity> selectSalOpportunityList(SalOpportunity salOpportunity)
    {
        return salOpportunityMapper.selectSalOpportunityList(salOpportunity);
    }

    /**
     * 新增销售机会管理
     * 
     * @param salOpportunity 销售机会管理
     * @return 结果
     */
    @Override
    public int insertSalOpportunity(SalOpportunity salOpportunity)
    {
        salOpportunity.setCreateTime(DateUtils.getNowDate());
        return salOpportunityMapper.insertSalOpportunity(salOpportunity);
    }

    /**
     * 修改销售机会管理
     * 
     * @param salOpportunity 销售机会管理
     * @return 结果
     */
    @Override
    public int updateSalOpportunity(SalOpportunity salOpportunity)
    {
        salOpportunity.setUpdateTime(DateUtils.getNowDate());
        return salOpportunityMapper.updateSalOpportunity(salOpportunity);
    }

    /**
     * 批量删除销售机会管理
     * 
     * @param opportunityIds 需要删除的销售机会管理主键
     * @return 结果
     */
    @Override
    public int deleteSalOpportunityByOpportunityIds(Long[] opportunityIds)
    {
        return salOpportunityMapper.deleteSalOpportunityByOpportunityIds(opportunityIds);
    }

    /**
     * 删除销售机会管理信息
     * 
     * @param opportunityId 销售机会管理主键
     * @return 结果
     */
    @Override
    public int deleteSalOpportunityByOpportunityId(Long opportunityId)
    {
        return salOpportunityMapper.deleteSalOpportunityByOpportunityId(opportunityId);
    }
}
