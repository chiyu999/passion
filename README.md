# passion权限管理系统

基于Springboot+SpringCloud+Vue+Element-UI 开发的权限管理系统

## 一、前端

### 1.1、开发环境

​			系统前端使用Vue.js 和 Element框架搭建，基于 npm 环境，使用VS Code开发。

```java
IDE : VS Code 
    
Node : 10.15.4
    
npm : 6.4.1
```

### 1.2、技术选型

```java
前端框架 ： vue 2.x

页面组件 ： Element 2.x

状态管理 ： Vuex 2.x

后台交互 ： axios 0.18.x

图标使用 : Font Awesome 4.x
```

### 1.3、项目结构

```java
passion-ui
    -- build: 项目编译相关模块，项目模板自动生成
    -- config: 项目配置相关模块，项目模板自动生成
    -- src： 项目源码模块，前端项目开发主要集中在此目录
        -- assets： 图标、字体、国际化信息等静态信息
        -- components: 组件库，对常用组件进行封装
        -- http: 后台交互模块，统一后台接口请求api
        -- i18n: 国际化模块，使用vue i18n 进行国际化
        -- mock: 模拟接口调用并返回定制数据
        -- permission: 权限控制模块，处理权限认证逻辑
        -- router: 路由管理模块，负责页面各种路由配置
        -- store: 状态管理模块，提供组件间状态共享
        -- utils： 工具模块，提供一些通用的工具方法
		-- views： 页面模块，主要放置各种页面视图组件
```



## 二、后端

### 2.1、开发环境

```java 
IDE : IDEA

JDK : JDK1.8.x

Maven : Maven 3.5.x

MySQL: MySQL 5.7.x

Consul: Consul 1.4.0

…
```

### 2.2、技术选型

```java
核心框架：Spring Boot 2.x

服务治理：Spring Cloud Finchley

安全框架：Spring Security 5.x

视图框架：Spring MVC 5.x

持久层框架：MyBatis 3.x

数据库连接池：Druid 1.x

消息队里：RabbitMQ

接口文档：Swagger 2.9.x

日志管理：SLF4J、Log4j

…
```



