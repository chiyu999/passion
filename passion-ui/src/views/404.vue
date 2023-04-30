<template>
    <div class="page-404">
        <div class="container">
            <h1>404</h1>
            <p>抱歉，您访问的页面不存在。</p>
            <el-button type="primary" @click="goBack">返回上一页</el-button>
            <el-button @click="goHome">返回首页</el-button>
        </div>
    </div>
</template>
  
<script>
export default {
    name: '404',
    methods: {
        // 返回上一页
        goBack() {
            this.$router.go(-1);
        },
        // 返回首页
        goHome() {
            this.$router.push("/");
        },
    },
};
</script>
  
<style scoped>
.page-404 {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    text-align: center;
}

.container {
    max-width: 600px;
}

h1 {
    font-size: 8rem;
    margin: 0;
}

p {
    font-size: 2rem;
}
</style>
  
<!-- <template>
    <el-container class="copntain">
        <el-main class="main">
            <h2 class="msg">{{ msg }}</h2>
            <p class="not-found-desc">抱歉！您访问的页面<em>失联</em>啦 ...</p>
            <el-button @click="$router.go(-1)">返回上一页</el-button>
            <el-button type="primary" @click="$router.push('/')">进入首页</el-button>
        </el-main>
    </el-container>
</template>
  
<script>
export default {
    name: '404',
    data() {
        return {
            msg: '404'
        }

    }
}
</script>
<style>
.msg {
    margin: 20px 0 15px;
    font-size: 8em;
    font-weight: 500;
    color: rgb(55, 71, 79);
}
</style> -->

