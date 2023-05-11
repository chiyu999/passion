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
      // request 请求拦截器
      instance.interceptors.request.use(
        config => {
          let token = Cookies.get('token')
          // 发送请求时携带token
          if (token) {
            config.headers.token = token
          } else {
            // 重定向到登录页面
            router.push('/login')
          }
          return config
        },
        error => {
          // 请求发生错误时
          console.log('request:', error)
          // 判断请求超时
          if (error.code === 'ECONNABORTED' && error.message.indexOf('timeout') !== -1) {
            console.log('timeout请求超时')
          }
          // 需要重定向到错误页面
          const errorInfo = error.response
          console.log(errorInfo)
          if (errorInfo) {
            error = errorInfo.data  // 页面那边catch的时候就能拿到详细的错误信息,看最下边的Promise.reject
            const errorStatus = errorInfo.status; // 404 403 500 ...
            router.push({
              path: `/error/${errorStatus}`
            })
          }
          return Promise.reject(error) // 在调用的那边可以拿到(catch)你想返回的错误信息
        }
      )
      
      // response 响应拦截器
      instance.interceptors.response.use(
        response => {
          return response.data
        },
        err => {
          if (err && err.response) {
            switch (err.response.status) {
              case 400:
                err.message = '请求错误'
                break
              case 401:
                err.message = '未授权，请登录'
                break
              case 403:
                err.message = '拒绝访问'
                break
              case 404:
                err.message = `请求地址出错: ${err.response.config.url}`
                break
              case 408:
                err.message = '请求超时'
                break
              case 500:
                err.message = '服务器内部错误'
                break
              case 501:
                err.message = '服务未实现'
                break
              case 502:
                err.message = '网关错误'
                break
              case 503:
                err.message = '服务不可用'
                break
              case 504:
                err.message = '网关超时'
                break
              case 505:
                err.message = 'HTTP版本不受支持'
                break
              default:
            }
          }
          console.error(err)
          return Promise.reject(err) // 返回接口返回的错误信息
        }
      )
      // 请求处理
      instance(options).then(res => {
        resolve(res)
        return false
      }).catch(error => {
        reject(error)
      })
    })
  }
