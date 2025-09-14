package com.ruoyi.contract.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.contract.mapper.SalContractMapper;
import com.ruoyi.contract.domain.SalContract;
import com.ruoyi.contract.service.ISalContractService;

/**
 * 合同管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-14
 */
@Service
public class SalContractServiceImpl implements ISalContractService 
{
    @Autowired
    private SalContractMapper salContractMapper;

    /**
     * 查询合同管理
     * 
     * @param contractId 合同管理主键
     * @return 合同管理
     */
    @Override
    public SalContract selectSalContractByContractId(Long contractId)
    {
        return salContractMapper.selectSalContractByContractId(contractId);
    }

    /**
     * 查询合同管理列表
     * 
     * @param salContract 合同管理
     * @return 合同管理
     */
    @Override
    public List<SalContract> selectSalContractList(SalContract salContract)
    {
        return salContractMapper.selectSalContractList(salContract);
    }

    /**
     * 新增合同管理
     * 
     * @param salContract 合同管理
     * @return 结果
     */
    @Override
    public int insertSalContract(SalContract salContract)
    {
        salContract.setCreateTime(DateUtils.getNowDate());
        return salContractMapper.insertSalContract(salContract);
    }

    /**
     * 修改合同管理
     * 
     * @param salContract 合同管理
     * @return 结果
     */
    @Override
    public int updateSalContract(SalContract salContract)
    {
        salContract.setUpdateTime(DateUtils.getNowDate());
        return salContractMapper.updateSalContract(salContract);
    }

    /**
     * 批量删除合同管理
     * 
     * @param contractIds 需要删除的合同管理主键
     * @return 结果
     */
    @Override
    public int deleteSalContractByContractIds(Long[] contractIds)
    {
        return salContractMapper.deleteSalContractByContractIds(contractIds);
    }

    /**
     * 删除合同管理信息
     * 
     * @param contractId 合同管理主键
     * @return 结果
     */
    @Override
    public int deleteSalContractByContractId(Long contractId)
    {
        return salContractMapper.deleteSalContractByContractId(contractId);
    }
}
