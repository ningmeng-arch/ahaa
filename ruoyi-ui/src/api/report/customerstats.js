import request from '@/utils/request'

// 查询客户分布列表
export function listCustomerdistribution(query) {
  return request({
    url: '/report/customerstats/list',
    method: 'get',
    params: query
  })
}

// 查询客户分布详细
export function getCustomerdistribution(industry) {
  return request({
    url: '/report/customerstats/' + industry,
    method: 'get'
  })
}

// 新增客户分布
// export function addCustomerdistribution(data) {
//   return request({
//     url: '/report/customerstats',
//     method: 'post',
//     data: data
//   })
// }

// 修改客户分布
// export function updateCustomerdistribution(data) {
//   return request({
//     url: '/report/customerstats',
//     method: 'put',
//     data: data
//   })
// }

// 删除客户分布
// export function delCustomerdistribution(industry) {
//   return request({
//     url: '/report/customerstats/' + industry,
//     method: 'delete'
//   })
// }

// 导出客户分布
// export function exportCustomerdistribution(query) {
//   return request({
//     url: '/report/customerstats/export',
//     method: 'get',
//     params: query
//   })
// }
