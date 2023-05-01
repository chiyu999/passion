//引入自己封装的axios
import axios from "../axios"
/**
 * 角色管理模块
 */


//保存
export const save = (data) => {
    return axios({
        url: '/role/save',
        method: 'post',
        data
    })
}
//批量删除
export const batchDelete = (data) => {
    return axios({
        url: '/role/delete',
        method: 'post',
        data
    })
}

//分页查询
export const findPage = (data) => {
    return axios({
        url: '/role/findPage',
        method: 'post',
        data
    })
}

//查询全部
export const findAll = (data) => {
    return axios({
        url: '/role/findAll',
        method: 'get'
    })
}

//查询角色菜单集合
export const findRoleMenus = (params) => {
    return axios({
        url: '/role/findRoleMenus',
        method: 'get',
        params
    })
}

//保存角色菜单集合
export const saveRoleMenus = (data) => {
    return axios({
        url: '/role/findRoleMenus',
        method: 'post',
        data
    })
}
