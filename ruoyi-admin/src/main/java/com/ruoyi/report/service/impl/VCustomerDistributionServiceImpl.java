package com.ruoyi.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.report.mapper.VCustomerDistributionMapper;
import com.ruoyi.report.domain.VCustomerDistribution;
import com.ruoyi.report.service.IVCustomerDistributionService;

/**
 * 客户分布数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-14
 */
@Service
public class VCustomerDistributionServiceImpl implements IVCustomerDistributionService 
{
    @Autowired
    private VCustomerDistributionMapper vCustomerDistributionMapper;

    /**
     * 查询客户分布数据
     * 
     * @param industry 客户分布数据主键
     * @return 客户分布数据
     */
    @Override
    public VCustomerDistribution selectVCustomerDistributionByIndustry(String industry)
    {
        return vCustomerDistributionMapper.selectVCustomerDistributionByIndustry(industry);
    }

    /**
     * 查询客户分布数据列表
     * 
     * @param vCustomerDistribution 客户分布数据
     * @return 客户分布数据
     */
    @Override
    public List<VCustomerDistribution> selectVCustomerDistributionList(VCustomerDistribution vCustomerDistribution)
    {
        return vCustomerDistributionMapper.selectVCustomerDistributionList(vCustomerDistribution);
    }

    /**
     * 新增客户分布数据
     * 
     * @param vCustomerDistribution 客户分布数据
     * @return 结果
     */
    @Override
    public int insertVCustomerDistribution(VCustomerDistribution vCustomerDistribution)
    {
        return vCustomerDistributionMapper.insertVCustomerDistribution(vCustomerDistribution);
    }

    /**
     * 修改客户分布数据
     * 
     * @param vCustomerDistribution 客户分布数据
     * @return 结果
     */
    @Override
    public int updateVCustomerDistribution(VCustomerDistribution vCustomerDistribution)
    {
        return vCustomerDistributionMapper.updateVCustomerDistribution(vCustomerDistribution);
    }

    /**
     * 批量删除客户分布数据
     * 
     * @param industrys 需要删除的客户分布数据主键
     * @return 结果
     */
    @Override
    public int deleteVCustomerDistributionByIndustrys(String[] industrys)
    {
        return vCustomerDistributionMapper.deleteVCustomerDistributionByIndustrys(industrys);
    }

    /**
     * 删除客户分布数据信息
     * 
     * @param industry 客户分布数据主键
     * @return 结果
     */
    @Override
    public int deleteVCustomerDistributionByIndustry(String industry)
    {
        return vCustomerDistributionMapper.deleteVCustomerDistributionByIndustry(industry);
    }
}
