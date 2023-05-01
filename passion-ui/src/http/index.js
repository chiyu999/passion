// 将axios封装成插件，按照插件方式引入
//这里把axios注册为Vue插件使用，并将api挂在在Vue原型的$api对象上，这样在获取this引用的地方就能通过this.$api.子模块.方法 的方式调用api

import api from './api' //导入所有接口

const install = Vue => {
    if (install.installed)
        return;
    install.installed = true;
    Object.defineProperties(Vue.prototype, {
        //此处挂在在Vue原型的$api对象上
        $api: {
            get() {
                return api
            }
        }
    })
}

export default install