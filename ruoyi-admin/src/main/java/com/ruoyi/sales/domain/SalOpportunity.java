package com.ruoyi.sales.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售机会管理对象 sal_opportunity
 * 
 * @author ruoyi
 * @date 2025-09-13
 */
public class SalOpportunity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售机会ID */
    private Long opportunityId;

    /** 机会名称 */
    @Excel(name = "机会名称")
    private String opportunityName;

    /** 关联客户ID */
    @Excel(name = "关联客户ID")
    private Long customerId;

    /** 预期金额 */
    @Excel(name = "预期金额")
    private BigDecimal expectedAmount;

    /** 销售阶段（初步接触、需求分析、报价、谈判、赢单） */
    @Excel(name = "销售阶段", readConverterExp = "初=步接触、需求分析、报价、谈判、赢单")
    private String salesStage;

    /** 成功概率(%) */
    @Excel(name = "成功概率(%)")
    private Long successProbability;

    /** 预计成交日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计成交日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date estimateCloseDate;

    public void setOpportunityId(Long opportunityId) 
    {
        this.opportunityId = opportunityId;
    }

    public Long getOpportunityId() 
    {
        return opportunityId;
    }

    public void setOpportunityName(String opportunityName) 
    {
        this.opportunityName = opportunityName;
    }

    public String getOpportunityName() 
    {
        return opportunityName;
    }

    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }

    public void setExpectedAmount(BigDecimal expectedAmount) 
    {
        this.expectedAmount = expectedAmount;
    }

    public BigDecimal getExpectedAmount() 
    {
        return expectedAmount;
    }

    public void setSalesStage(String salesStage) 
    {
        this.salesStage = salesStage;
    }

    public String getSalesStage() 
    {
        return salesStage;
    }

    public void setSuccessProbability(Long successProbability) 
    {
        this.successProbability = successProbability;
    }

    public Long getSuccessProbability() 
    {
        return successProbability;
    }

    public void setEstimateCloseDate(Date estimateCloseDate) 
    {
        this.estimateCloseDate = estimateCloseDate;
    }

    public Date getEstimateCloseDate() 
    {
        return estimateCloseDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("opportunityId", getOpportunityId())
            .append("opportunityName", getOpportunityName())
            .append("customerId", getCustomerId())
            .append("expectedAmount", getExpectedAmount())
            .append("salesStage", getSalesStage())
            .append("successProbability", getSuccessProbability())
            .append("estimateCloseDate", getEstimateCloseDate())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
