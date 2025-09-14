package com.ruoyi.product.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.product.mapper.ProdProductMapper;
import com.ruoyi.product.domain.ProdProduct;
import com.ruoyi.product.service.IProdProductService;

/**
 * 产品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-14
 */
@Service
public class ProdProductServiceImpl implements IProdProductService 
{
    @Autowired
    private ProdProductMapper prodProductMapper;

    /**
     * 查询产品管理
     * 
     * @param productId 产品管理主键
     * @return 产品管理
     */
    @Override
    public ProdProduct selectProdProductByProductId(Long productId)
    {
        return prodProductMapper.selectProdProductByProductId(productId);
    }

    /**
     * 查询产品管理列表
     * 
     * @param prodProduct 产品管理
     * @return 产品管理
     */
    @Override
    public List<ProdProduct> selectProdProductList(ProdProduct prodProduct)
    {
        return prodProductMapper.selectProdProductList(prodProduct);
    }

    /**
     * 新增产品管理
     * 
     * @param prodProduct 产品管理
     * @return 结果
     */
    @Override
    public int insertProdProduct(ProdProduct prodProduct)
    {
        prodProduct.setCreateTime(DateUtils.getNowDate());
        return prodProductMapper.insertProdProduct(prodProduct);
    }

    /**
     * 修改产品管理
     * 
     * @param prodProduct 产品管理
     * @return 结果
     */
    @Override
    public int updateProdProduct(ProdProduct prodProduct)
    {
        prodProduct.setUpdateTime(DateUtils.getNowDate());
        return prodProductMapper.updateProdProduct(prodProduct);
    }

    /**
     * 批量删除产品管理
     * 
     * @param productIds 需要删除的产品管理主键
     * @return 结果
     */
    @Override
    public int deleteProdProductByProductIds(Long[] productIds)
    {
        return prodProductMapper.deleteProdProductByProductIds(productIds);
    }

    /**
     * 删除产品管理信息
     * 
     * @param productId 产品管理主键
     * @return 结果
     */
    @Override
    public int deleteProdProductByProductId(Long productId)
    {
        return prodProductMapper.deleteProdProductByProductId(productId);
    }
}
