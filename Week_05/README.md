## 学习笔记

### 作业 1：写代码实现 Spring Bean 的装配

最简单的就是使用 @Component @Configuration 这类注解直接添加到类上面，
这样就可以直接被 Spring 管理。

其次可以使用一些注解组合实现功能多样化，比如使用 @Configuration 表明这是一个配置类，
然后使用 @Bean 注解到某个方法上完成对这个 Bean 做一些处理；
或者使用 @ImportResource 注解从 xml 等配置文件里面解析 Bean。

还可以使用 Spring 的上下文，根据某个类的名称或者类路径随时加载 Bean。

### 作业 2: 给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。

这道题需要先弄清楚 Spring Boot Starter 是如何工作的：
1. Spring Boot 会从 classpath:/META-INF/ 目录下寻找 spring.factories 文件
2. 这个文件里面就是需要自动加载的配置类清单，相当于企业招聘发送的 offer 名单，表示这些都是我要加载的配置类
3. 利用 @Configuration @Condition 等注解对类加载做一些额外处理，比如设置些默认值、或者从配置文件里读取属性等
4. 经过以上的处理，就会让需要的类给 Spring 管理，从而可以在程序里直接使用

一般来讲，Starter 都是重新建立一个项目，引入普通的依赖，然后让某些类可以被 Spring 管理（比如从配置文件读取属性），
然后打包成 jar 包给其他 Spring Boot 项目使用。

### 作业 3: 研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法

- 1）使用 JDBC 原生接口，实现数据库的增删改查操作。
- 2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
- 3）配置 Hikari 连接池，改进上述操作。提交代码到 Github。

使用原声的 JDBC 方式连接数据库，通常会有一个连接工具类，负责建立数据连接，做的考究一点可以写个连接池。
然后当业务需要操作数据库时就从工具类里获取一个数据库连接，构造 SQL 语句、传递参数交给 JDBC 驱动去执行，
等拿到返回值之后就继续执行业务。

使用 Hikari 连接池就简单多了，只需要在配置文件里面配置 datasource 为 HikariCP ,
设置好数据库的 url 、username、password，Spring Boot 会替我们完成剩下的工作。
需要查询数据库时，使用接口继承自 JpaRepository，就可以直接使用里面的方法去执行对应的 SQL 了。


