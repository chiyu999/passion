# 1、搭建开发环境
> 安装 vscode

> 安装 nodejs

```java
npm install npm -g
```

> 安装 webpack

```java
npm install webpack -g
```

> 安装 vue-cli


```java
npm install vue-cli -g
```

> 配置淘宝镜像 

npm使用的是国外中央仓库，速度比较慢，国内可以使用淘宝镜像

```java
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

> 安装yarn

Yarn是Facebook发布的node.js包管理器，比npm更快，更高效

```java 
npm i yarn -g -verbose
```

安装完成之后配置淘宝镜像

```java
yarn config set registry https://registry.npm.taobao.org
```

# 2、创建项目

## 2.1、生成项目
```java
cd e: //路径到我们要存放项目的盘符
vue init webpack passion-ui //初始化项目
cd passion-ui //进入目录
yarn install //安装依赖
```

## 2.2、安装依赖

```java
cd passion-ui //进入目录
yarn install //安装依赖
```
安装完依赖后，项目文件夹下会生成node_modules文件夹，这个目录就是下载的依赖包的统一存放路径

## 2.3、启动运行

```java
npm run dev
```

```js
// 删除
export const batchDelete = (data) => {
    return axios({
        url: '/menu/delete',
        method: 'post',
        data
    })
}
// 查找导航菜单树
export const findNavTree = (params) => {
    return axios({
        url: '/menu/findNavTree',
        method: 'get',
        params
    })
}
```

在这个代码中，data和params之间是有区别的。


data代表请求体（request body）中的数据。它通常用于POST请求，将数据作为有效负载发送到服务器端。


params代表查询参数（query parameters），它通常用于GET请求，将参数附加到URL的查询字符串中发送给服务器端。在上述代码中，findNavTree函数使用的是GET请求，并且查询参数被添加到URL的末尾部分。


因此，data和params是传递给Axios请求的参数，并且在请求类型、发送方式和接收方式上存在区别。