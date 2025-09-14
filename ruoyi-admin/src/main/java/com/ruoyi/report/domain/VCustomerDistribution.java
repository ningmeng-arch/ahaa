package com.ruoyi.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户分布数据对象 v_customer_distribution
 * 
 * @author ruoyi
 * @date 2025-09-14
 */
public class VCustomerDistribution extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 所属行业 */
    private String industry;

    /** 客户数量 */
    private Long customerCount;

    public void setIndustry(String industry) 
    {
        this.industry = industry;
    }

    public String getIndustry() 
    {
        return industry;
    }

    public void setCustomerCount(Long customerCount) 
    {
        this.customerCount = customerCount;
    }

    public Long getCustomerCount() 
    {
        return customerCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("industry", getIndustry())
            .append("customerCount", getCustomerCount())
            .toString();
    }
}
