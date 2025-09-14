package com.ruoyi.sales.service;

import java.util.List;
import com.ruoyi.sales.domain.SalOpportunity;

/**
 * 销售机会管理Service接口
 * 
 * @author ruoyi
 * @date 2025-09-13
 */
public interface ISalOpportunityService 
{
    /**
     * 查询销售机会管理
     * 
     * @param opportunityId 销售机会管理主键
     * @return 销售机会管理
     */
    public SalOpportunity selectSalOpportunityByOpportunityId(Long opportunityId);

    /**
     * 查询销售机会管理列表
     * 
     * @param salOpportunity 销售机会管理
     * @return 销售机会管理集合
     */
    public List<SalOpportunity> selectSalOpportunityList(SalOpportunity salOpportunity);

    /**
     * 新增销售机会管理
     * 
     * @param salOpportunity 销售机会管理
     * @return 结果
     */
    public int insertSalOpportunity(SalOpportunity salOpportunity);

    /**
     * 修改销售机会管理
     * 
     * @param salOpportunity 销售机会管理
     * @return 结果
     */
    public int updateSalOpportunity(SalOpportunity salOpportunity);

    /**
     * 批量删除销售机会管理
     * 
     * @param opportunityIds 需要删除的销售机会管理主键集合
     * @return 结果
     */
    public int deleteSalOpportunityByOpportunityIds(Long[] opportunityIds);

    /**
     * 删除销售机会管理信息
     * 
     * @param opportunityId 销售机会管理主键
     * @return 结果
     */
    public int deleteSalOpportunityByOpportunityId(Long opportunityId);
}
