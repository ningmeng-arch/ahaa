package com.ruoyi.report.mapper;

import java.util.List;
import com.ruoyi.report.domain.VCustomerDistribution;

/**
 * 客户分布数据Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-14
 */
public interface VCustomerDistributionMapper 
{
    /**
     * 查询客户分布数据
     * 
     * @param industry 客户分布数据主键
     * @return 客户分布数据
     */
    public VCustomerDistribution selectVCustomerDistributionByIndustry(String industry);

    /**
     * 查询客户分布数据列表
     * 
     * @param vCustomerDistribution 客户分布数据
     * @return 客户分布数据集合
     */
    public List<VCustomerDistribution> selectVCustomerDistributionList(VCustomerDistribution vCustomerDistribution);

    /**
     * 新增客户分布数据
     * 
     * @param vCustomerDistribution 客户分布数据
     * @return 结果
     */
    public int insertVCustomerDistribution(VCustomerDistribution vCustomerDistribution);

    /**
     * 修改客户分布数据
     * 
     * @param vCustomerDistribution 客户分布数据
     * @return 结果
     */
    public int updateVCustomerDistribution(VCustomerDistribution vCustomerDistribution);

    /**
     * 删除客户分布数据
     * 
     * @param industry 客户分布数据主键
     * @return 结果
     */
    public int deleteVCustomerDistributionByIndustry(String industry);

    /**
     * 批量删除客户分布数据
     * 
     * @param industrys 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVCustomerDistributionByIndustrys(String[] industrys);
}
