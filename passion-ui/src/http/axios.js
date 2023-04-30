// 二次封装axios模块，包含拦截器等信息
//axios拦截器，可以进行请求拦截和响应拦截，在发送请求和相应请求时执行一些操作

//1、这里导入配置文件的信息到axios对象，如baseUrl,headers,withCredentials
//2、发送请求的时候获取token，如果token不存在，说明未登录，就重定向到系统登录页面，否则携带token就继续发送token
//3、如果需要，可以在这里通过response响应拦截器对返回结果进行统一处理后再返回

import axios from 'axios'
import config from './config'
import Cookies from 'js-cookie'
import router from '@/router'

export default function $axios(options) {
    return new Promise((resolve, reject) => {
        const instance = axios.create({
            baseURL: config.baseUrl,
            headers: config.headers,
            timeout: config.timeout,
            withCredentials: config.withCredentials
        })
        //request请求拦截器
        instance.interceptors.request.use(
            config => {
                let token = Cookies.get('token')
                if (token) { //发送请求时携带了token
                    config.headers.token = token
                } else { //重定向到登录页面
                    router.push('login')
                }
                return config
            },
            error => {
                return Promise.reject(error)
            }
        )

        //response 响应拦截器
        instance.interceptors.response.use(
            response => {
                return response.data
            },
            err => {
                return response.reject(err)
            }
        )

        //请求处理
        instance(options).then(res => {
            resolve(res)
            return false
        }).catch(error => {
            reject(error)
        })
    })
}
