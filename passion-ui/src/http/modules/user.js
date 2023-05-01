import axios from '../axios'

/**
 * 用户管理模块
 * @constructor chiyu999
 */

//保存
export const save = (data) => {
    return axios({ url: '/user/save', method: 'POST', data })
}

//删除
export const batchDelete = (data) => {
    return axios({ url: '/user/delete', method: 'POST', data })
}

//分页查询
export const findPage = (data) => {
    return axios({ url: '/user/findPage', method: 'POST', data })
}

//查找用户的菜单权限标识集合
export const findPermission = (params) => {
    return axios({ url: '/user/findPermission', method: 'GET', params })
}