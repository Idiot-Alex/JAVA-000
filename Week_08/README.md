#学习笔记

### 设计对前面的订单表数据进行水平分库分表，拆分2个库，每个库16张表并在新结构在演示常见的增删改查操作

借助 ShardingSphere-Proxy 中间件完成分库分表，这个就相当于是个数据库代理，
换句话说可以通过连接数据库的方式去连接 ShardingSphere-Proxy。
具体步骤如下：
1. 下载 ShardingSphere-Proxy 服务安装包，这里没法用 Docker 构建，Docker Hub 里面没有 Apache 官方的容器
2. 修改目录里面的 server.yaml 配置文件，因为 ShardingSphere-Proxy 是个代理，这里配置的就是代理数据库的相关属性
3. 修改 config-sharding.yaml 配置文件，这里面配置代理的数据库和分库分表的规则，比如按照某个 id 取模算法分库分表
4. 启动 ShardingSphere-Proxy 之前还需要配置数据库的驱动，比如用 MySQL 就需要 mysql-connector-java-5.1.47.jar
5. 在数据库创建完成之后，使用 /bin/ 目录里面的脚本启动 ShardingSphere-Proxy 服务，启动之后就可以用 MySQL 客户端直接连接了，
这时候执行的 SQL 会被代理去解析按照配置里面的算法去对应的数据库执行。

对应 SQL 和修改之后的配置文件在 resources 目录里面。

这里使用了数据库 demo_ds_0 和 demo_ds_1 两个数据库，每个数据库里面有 t_order_0 和 t_order_1 两张表。

由于分了 2 个数据库，userId 为奇数会进入 demo_ds_0，偶数会进入 demo_ds_1；
再加上 order_id % 16，进入这两个数据库的数据又会被分散到不同的表里面。

虽然单个数据库数据表的数据量变小了，但是由于是按照 userId 分库的，所以所有的查询都需要带上 userId 参数才会提高查询效率。

[] 我在用 JPA 测试的时候发现修改的 SQL 会无法执行，想来是因为修改会涉及到数据的重新分库分表，并非简单的执行修改，这样的问题该如何解决？