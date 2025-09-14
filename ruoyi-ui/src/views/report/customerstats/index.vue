<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="24">
        <el-card>
          <template #header>
            <div class="card-header">
              <span>客户行业分布分析</span>
            </div>
          </template>

          <el-row :gutter="20">
            <el-col :span="14">
              <div ref="barChart" style="height: 400px;"></div>
            </el-col>
            <el-col :span="10">
              <div ref="pieChart" style="height: 400px;"></div>
            </el-col>
          </el-row>

          <el-table :data="tableData" style="width: 100%; margin-top: 20px">
            <el-table-column prop="industry" label="行业" min-width="150" />
            <el-table-column prop="customerCount" label="客户数量" width="120">
              <template #default="scope">
                <el-tag>{{ scope.row.customerCount }}</el-tag>
              </template>
            </el-table-column>
            <el-table-column prop="percentage" label="占比" width="120">
              <template #default="scope">
                {{ scope.row.percentage }}%
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import { listCustomerdistribution } from '@/api/report/customerstats'

export default {
  name: 'CustomerDistribution',
  data() {
    return {
      tableData: []
    }
  },
  mounted() {
    this.loadData()
  },
  methods: {
    async loadData() {
      const response = await listCustomerdistribution()
      if (response.code === 200) {
        this.tableData = this.calculatePercentage(response.rows)
        this.initCharts(this.tableData)
      }
    },

    calculatePercentage(data) {
      const total = data.reduce((sum, item) => sum + item.customerCount, 0)
      return data.map(item => ({
        ...item,
        percentage: ((item.customerCount / total) * 100).toFixed(1)
      }))
    },

    initCharts(data) {
      this.initBarChart(data)
      this.initPieChart(data)
    },

    initBarChart(data) {
      const chart = echarts.init(this.$refs.barChart)
      const option = {
        title: { text: '客户数量行业分布', left: 'center' },
        tooltip: { trigger: 'axis' },
        xAxis: {
          type: 'category',
          data: data.map(item => item.industry),
          axisLabel: { rotate: 45 }
        },
        yAxis: { type: 'value' },
        series: [{
          data: data.map(item => item.customerCount),
          type: 'bar',
          itemStyle: { color: '#5470c6' }
        }]
      }
      chart.setOption(option)
    },

    initPieChart(data) {
      const chart = echarts.init(this.$refs.pieChart)
      const option = {
        title: { text: '行业占比', left: 'center' },
        tooltip: { trigger: 'item' },
        series: [{
          name: '客户分布',
          type: 'pie',
          radius: '60%',
          data: data.map(item => ({
            value: item.customerCount,
            name: item.industry
          })),
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }]
      }
      chart.setOption(option)
    }
  }
}
</script>

<style scoped>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
