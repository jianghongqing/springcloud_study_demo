# springcloud-app

## 系统介绍

- springcloud-app 是J2EE集群分布式基础开发平台，技术栈包括：springCloud-eureka，springCloud-zuul，springCloud-ribbon，springCloud-feign，springCloud-config，springCloud-bus、MyBatis、Shiro、redis、quartz、hibernate-validation、easyui，业务模块包括：用户管理，角色管理、权限管理，字典管理，定时任务。

## 核心流程概要

- 用户->nginx->HTML->ZUUL(路由中心)->eureka(注册中心)->具体服务（必须引入SHIRO权限）->eureka(注册中心)->核心服务（SHIRO权限认证授权）->REDIS/MYSQL
- 外部通信,方式HTTP,协议HTTP,权限SHIRO,注意ZUUL过滤器屏蔽内部接口（防止内部接口对外暴露）
- 内部通信,方式Feign,协议HTTP,权限eureka账号密码,注意SHIRO要开放内部接口

## 业务功能

- 1.用户管理：用户增删改查与角色关系
- 2.角色管理：角色增删改查与权限关系
- 3.菜单管理：菜单增删改查（树形结构）
- 4.字典管理：字典增删改查
- 5.定时器管理：定时器添加删除暂停，更改表达式

## 技术栈

- springCloud-eureka 注册中心
- springCloud-zuul 路由中心
- springCloud-ribbon 通信
- springCloud-feign 注解通信
- springCloud-config 配置中心
- springCloud-bus 实时配置中心功能
- springBoot ioc，aop
- mybatis ORM  
- shiro 会话 
- hibernate-validation 验证 
- redis 集群会话，shiro缓存，mybatis二级缓存
- 连接池 druid
- quartz 定时任务
- easyui 页面UI 

## 部署

- 1.导入数据库脚本springcloud.sql
- 2.安装nginx配置参考nginx.txt
- 3.启动redis
- 4.启动rabbitmq
- 5.启动注册中心springcloud-app-eureka位置com.wangsong.springcloudAppEurekaApplication
- 6.启动配置中心springcloud-app-config位置com.wangsong.springcloudAppConfigApplication
- 7.启动路由中心springcloud-app-zuul位置com.wangsong.springcloudAppZuulApplication
- 8.启动服务中心springcloud-app-service位置com.wangsong.springcloudAppServiceApplication
- 9.访问nginx端口/springcloud-app-html

## qq交流群

- 74745979