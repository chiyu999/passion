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