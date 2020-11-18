package geektime.work.work03.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC 数据库连接工具类
 */
public class DBUtil {

    // 数据库地址
    private static final String dbUrl="jdbc:mysql://localhost:3306/test?useSSL=true&serverTimezone=UTC";
    // 用户名
    private static final String dbUserName="xxx";
    // 密码
    private static final String dbPassword="xxx";
    // 驱动名称
    private static final String jdbcName="com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     * 	1.加载数据库驱动
     *  2.获取数据库连接
     */
    public Connection getCon() throws Exception {

        Class.forName(jdbcName);//加载数据库驱动

        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        return con;
    }

    /**
     * 关闭连接
     */
    public void close(Statement stmt, Connection con) throws Exception {
        if(stmt != null) {
            stmt.close();
        }
        if(con != null) {
            con.close();
        }
    }

}
