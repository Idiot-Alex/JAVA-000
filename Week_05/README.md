## 学习笔记

### 作业 1：写代码实现 Spring Bean 的装配

最简单的就是使用 @Component @Configuration 这类注解直接添加到类上面，
这样就可以直接被 Spring 管理。

其次可以使用一些注解组合实现功能多样化，比如使用 @Configuration 表明这是一个配置类，
然后使用 @Bean 注解到某个方法上完成对这个 Bean 做一些处理；
或者使用 @ImportResource 注解从 xml 等配置文件里面解析 Bean。

还可以使用 Spring 的上下文，根据某个类的名称或者类路径随时加载 Bean。

### 作业 2: 给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。

