# springcloud-app

## 系统介绍

- springcloud-app 是J2EE集群分布式基础开发平台，技术栈包括：springcloud-eureka，springcloud-zuul，springcloud-ribbon，springcloud-feign，springcloud-config，springcloud-bus、springcloud-hystrix，springcloud-turbine，springcloud-zipkin，MyBatis、Shiro、redis、quartz、hibernate-validation、easyui，业务模块包括：用户管理，角色管理、权限管理，字典管理，定时任务。

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

- springcloud-eureka 注册中心
- springcloud-zuul 路由中心
- springcloud-ribbon 通信
- springcloud-feign 注解通信
- springcloud-config 配置中心
- springcloud-bus 实时配置中心功能
- springcloud-hystrix 断路器监控
- springcloud-turbine 断路器监控聚合
- springcloud-zipkin 链路监控
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
- 5.启动注册中心springcloud-app-eureka 访问端口1001
- 6.启动配置中心springcloud-app-config
- 7.启动路由中心springcloud-app-zuul
- 8.启动服务中心springcloud-app-system
- 8.启动调度中心springcloud-app-schedule
- 8.启动断路器监控汇总springcloud-app-turbine 访问端口8989
- 8.启动断路器监控springcloud-app-hystrix 访问端口1301/hystrix
- 8.启动链路追踪springcloud-app-zipkin 访问端口9411
- 9.启动nginx 访问端口80/springcloud-app-html

## qq交流群

- 74745979