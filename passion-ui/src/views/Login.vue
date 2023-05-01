<template>
    <div>
        <h2>Login page</h2>
        <el-button type="primary" @click="login()">登录</el-button>
    </div>
</template>

<script>
import mock from '@/mock/index.js' //引入mock数据
import router from '@/router';
import Cookies from "js-cookie"
export default {
    name: 'Login',
    methods: {
        login() {
            this.$api.login.login().then(function (res) {
                alert(res.data.token)
                Cookies.set('token', res.data.token) //放置token到Cookie
                router.push('/') //登录成功跳转到主页
            }).catch(function (res) {
                alert(res);
            });
        }
    }
}
</script>