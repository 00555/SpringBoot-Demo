# SpringBoot-Demo
SpringBoot Demo学习 （Spring Boot + Spring MVC + Spring Security + MyBatis + RabbitMQ + Swagger + Thymeleaf + Restful API ）整合

## Quick Start

1. 安装RabbitMQ Server [安装RabbitMQ](https://github.com/loveincode/notes/blob/master/04%20-%20Middleware/%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97/RabbitMQ/rabbitMQ%E5%AE%89%E8%A3%85.md)

2. mysql 新建数据库sblearning ， 并执行sql文件 src/main/resources/sblearning.sql 

3. 资源文件 src/main/resources/application.properties 下配置rebbit IP,Port,druid mysql资源；

```
#rebbit
spring.rabbitmq.host=localhost
spring.rabbitmq.port=***
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

spring.datasource.url=jdbc:mysql://localhost:3306/sblearning?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false
spring.datasource.username=***
spring.datasource.password=***
```

4. 启动RabbitMQ Server，启动SpringBootDemoApplication 启动完成

5. 测试

    浏览器访问 http://localhost:8080/swagger-ui.html/ 查看swagger-ui提供的接口文档
    
    浏览器访问 http://localhost:8080/druid/login.html 查看druid监控 user pass在 com.loveincode.config.DruidMonitorConfig中配置的。
