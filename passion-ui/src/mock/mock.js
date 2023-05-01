// // 模拟接口，分别拦截用户和菜单的请求
// import Mock from 'mock.js'
// Mock.mock('http://localhost:8080/user', {
//     'name': '@name', //随机生成姓名
//     'email': '@email', //随机生成邮箱
//     'age|1-10': 5, //年龄在1-10之间
// })
// Mock.mock('http://localhost:8080/menu', {
//     'id': '@increment', //id自增
//     'name': 'menu', //名称为menu
//     'order|1-20': 5, //排序在1-10之间
// })
import Mock from 'mockjs'

Mock.mock('http://localhost:8080/user', {
    'name': '@name', // 随机生成姓名
    'name': '@email', // 随机生成邮箱
    'age|1-10': 5, // 年龄1-10之间
})
Mock.mock('http://localhost:8080/menu', {
    'id': '@increment', // id自增
    'name': 'menu', // 名称为menu
    'order|1-20': 5, // 排序1-20之间
})
Mock.mock('http://localhost:8001/login',{
    'token': '332fr3e3rfsdfd'
})