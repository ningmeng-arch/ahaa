import request from '@/utils/request'

// 查询销售机会管理列表
export function listOpportunity(query) {
  return request({
    url: '/sales/opportunity/list',
    method: 'get',
    params: query
  })
}

// 查询销售机会管理详细
export function getOpportunity(opportunityId) {
  return request({
    url: '/sales/opportunity/' + opportunityId,
    method: 'get'
  })
}

// 新增销售机会管理
export function addOpportunity(data) {
  return request({
    url: '/sales/opportunity',
    method: 'post',
    data: data
  })
}

// 修改销售机会管理
export function updateOpportunity(data) {
  return request({
    url: '/sales/opportunity',
    method: 'put',
    data: data
  })
}

// 删除销售机会管理
export function delOpportunity(opportunityId) {
  return request({
    url: '/sales/opportunity/' + opportunityId,
    method: 'delete'
  })
}
