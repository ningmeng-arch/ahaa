<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="机会名称" prop="opportunityName">
        <el-input
          v-model="queryParams.opportunityName"
          placeholder="请输入机会名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关联客户ID" prop="customerId">
        <el-input
          v-model="queryParams.customerId"
          placeholder="请输入关联客户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预期金额" prop="expectedAmount">
        <el-input
          v-model="queryParams.expectedAmount"
          placeholder="请输入预期金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售阶段" prop="salesStage">
        <el-select v-model="queryParams.salesStage" placeholder="请选择销售阶段" clearable>
          <el-option
            v-for="dict in dict.type.sal_opportunity_stage"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="成功概率(%)" prop="successProbability">
        <el-input
          v-model="queryParams.successProbability"
          placeholder="请输入成功概率(%)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预计成交日期" prop="estimateCloseDate">
        <el-date-picker clearable
          v-model="queryParams.estimateCloseDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预计成交日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['sales:opportunity:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['sales:opportunity:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['sales:opportunity:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['sales:opportunity:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="opportunityList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="销售机会ID" align="center" prop="opportunityId" />
      <el-table-column label="机会名称" align="center" prop="opportunityName" />
      <el-table-column label="关联客户ID" align="center" prop="customerId" />
      <el-table-column label="预期金额" align="center" prop="expectedAmount" />
      <el-table-column label="销售阶段" align="center" prop="salesStage">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sal_opportunity_stage" :value="scope.row.salesStage"/>
        </template>
      </el-table-column>
      <el-table-column label="成功概率(%)" align="center" prop="successProbability" />
      <el-table-column label="预计成交日期" align="center" prop="estimateCloseDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.estimateCloseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['sales:opportunity:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['sales:opportunity:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改销售机会管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="机会名称" prop="opportunityName">
          <el-input v-model="form.opportunityName" placeholder="请输入机会名称" />
        </el-form-item>
        <el-form-item label="关联客户ID" prop="customerId">
          <el-input v-model="form.customerId" placeholder="请输入关联客户ID" />
        </el-form-item>
        <el-form-item label="预期金额" prop="expectedAmount">
          <el-input v-model="form.expectedAmount" placeholder="请输入预期金额" />
        </el-form-item>
        <el-form-item label="销售阶段" prop="salesStage">
          <el-select v-model="form.salesStage" placeholder="请选择销售阶段">
            <el-option
              v-for="dict in dict.type.sal_opportunity_stage"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="成功概率(%)" prop="successProbability">
          <el-input v-model="form.successProbability" placeholder="请输入成功概率(%)" />
        </el-form-item>
        <el-form-item label="预计成交日期" prop="estimateCloseDate">
          <el-date-picker clearable
            v-model="form.estimateCloseDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预计成交日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOpportunity, getOpportunity, delOpportunity, addOpportunity, updateOpportunity } from "@/api/sales/opportunity"

export default {
  name: "Opportunity",
  dicts: ['sal_opportunity_stage'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 销售机会管理表格数据
      opportunityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        opportunityName: null,
        customerId: null,
        expectedAmount: null,
        salesStage: null,
        successProbability: null,
        estimateCloseDate: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        opportunityName: [
          { required: true, message: "机会名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询销售机会管理列表 */
    getList() {
      this.loading = true
      listOpportunity(this.queryParams).then(response => {
        this.opportunityList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        opportunityId: null,
        opportunityName: null,
        customerId: null,
        expectedAmount: null,
        salesStage: null,
        successProbability: null,
        estimateCloseDate: null,
        remark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.opportunityId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加销售机会管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const opportunityId = row.opportunityId || this.ids
      getOpportunity(opportunityId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改销售机会管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.opportunityId != null) {
            updateOpportunity(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addOpportunity(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const opportunityIds = row.opportunityId || this.ids
      this.$modal.confirm('是否确认删除销售机会管理编号为"' + opportunityIds + '"的数据项？').then(function() {
        return delOpportunity(opportunityIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('sales/opportunity/export', {
        ...this.queryParams
      }, `opportunity_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
