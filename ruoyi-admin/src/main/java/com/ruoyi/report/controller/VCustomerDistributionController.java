package com.ruoyi.report.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.report.domain.VCustomerDistribution;
import com.ruoyi.report.service.IVCustomerDistributionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户分布数据Controller
 * 
 * @author ruoyi
 * @date 2025-09-14
 */
@RestController
@RequestMapping("/report/customerstats")
public class VCustomerDistributionController extends BaseController
{
    @Autowired
    private IVCustomerDistributionService vCustomerDistributionService;

    /**
     * 查询客户分布数据列表
     */
    @PreAuthorize("@ss.hasPermi('report:customerstats:list')")
    @GetMapping("/list")
    public TableDataInfo list(VCustomerDistribution vCustomerDistribution)
    {
        startPage();
        List<VCustomerDistribution> list = vCustomerDistributionService.selectVCustomerDistributionList(vCustomerDistribution);
        return getDataTable(list);
    }

    /**
     * 导出客户分布数据列表
     */
    @PreAuthorize("@ss.hasPermi('report:customerstats:export')")
    @Log(title = "客户分布数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VCustomerDistribution vCustomerDistribution)
    {
        List<VCustomerDistribution> list = vCustomerDistributionService.selectVCustomerDistributionList(vCustomerDistribution);
        ExcelUtil<VCustomerDistribution> util = new ExcelUtil<VCustomerDistribution>(VCustomerDistribution.class);
        util.exportExcel(response, list, "客户分布数据数据");
    }

    /**
     * 获取客户分布数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:customerstats:query')")
    @GetMapping(value = "/{industry}")
    public AjaxResult getInfo(@PathVariable("industry") String industry)
    {
        return success(vCustomerDistributionService.selectVCustomerDistributionByIndustry(industry));
    }

    /**
     * 新增客户分布数据
     */
    @PreAuthorize("@ss.hasPermi('report:customerstats:add')")
    @Log(title = "客户分布数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VCustomerDistribution vCustomerDistribution)
    {
        return toAjax(vCustomerDistributionService.insertVCustomerDistribution(vCustomerDistribution));
    }

    /**
     * 修改客户分布数据
     */
    @PreAuthorize("@ss.hasPermi('report:customerstats:edit')")
    @Log(title = "客户分布数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VCustomerDistribution vCustomerDistribution)
    {
        return toAjax(vCustomerDistributionService.updateVCustomerDistribution(vCustomerDistribution));
    }

    /**
     * 删除客户分布数据
     */
    @PreAuthorize("@ss.hasPermi('report:customerstats:remove')")
    @Log(title = "客户分布数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{industrys}")
    public AjaxResult remove(@PathVariable String[] industrys)
    {
        return toAjax(vCustomerDistributionService.deleteVCustomerDistributionByIndustrys(industrys));
    }
}
