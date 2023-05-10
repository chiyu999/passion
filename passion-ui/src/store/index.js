/*
 * @Author: chixiaoyu 
 * @Date: 2023-05-10 21:31:33 
 * @Last Modified by:   chixiaoyu 
 * @Last Modified time: 2023-05-10 21:31:33 
 */
//引入vuex并统一组织导入和管理子模块
import Vue from 'vue'
import vuex from 'vuex'

Vue.use(vuex);

// 引入子模块
import app from './modules/app'
import tab from './modules/tab'
import user from './modules/user'
import menu from './modules/menu'

const store = new vuex.Store({
    modules: {
        app: app,
        tab: tab,
        user: user,
        menu: menu
    }
})

export default store