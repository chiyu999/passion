// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue, { h } from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import i18n from './i18n'
import api from './http' //导入api模块
import global from '@/utils/global'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'



// Vue.config.productionTip = false
Vue.use(ElementUI) //注册使用element
Vue.use(api) //注册使用api,可以通过this.$api.子模块.方法 的方式调用后台接口

Vue.prototype.global = global //挂载全局配置模块

/* eslint-disable no-new */
new Vue({
  el: '#app',
  i18n,
  router,
  render: h => h(App)
  // components: { App },
  // template: '<App/>'
}) 
