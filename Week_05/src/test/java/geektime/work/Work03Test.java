package geektime.work;

import geektime.work.work03.hikari.IUserDao;
import geektime.work.work03.hikari.User;
import geektime.work.work03.jdbc.DBUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Work03Test {
    private static Logger logger = LoggerFactory.getLogger(Work03Test.class);

    @Resource
    private IUserDao userDao;

    /**
     * 测试 JDBC 连接
     * 需要启动数据库，新建对应的数据库和数据表
     */
    @Test
    public void testJDBC() throws Exception {
        logger.info("测试 JDBC 连接");
        DBUtil dbUtil = new DBUtil();
        Connection conn = null;
        // 使用PreparedStatement
        PreparedStatement pstmt = null;
        // SQL 语句
        String updateSql = "update user set name = ? , age = ? where id = 1";
        try {
            conn = dbUtil.getCon();
            pstmt = conn.prepareStatement(updateSql);
            // 设置值
            pstmt.setString(1, "test");
            pstmt.setInt(2, 20);
            pstmt.execute();
            conn.commit();
        } finally {
            dbUtil.close(pstmt, conn);
        }
    }

    /**
     * 测试 JDBC 连接
     * 需要启动数据库，新建对应的数据库和数据表
     */
    @Test
    public void testHikari() {
        User user = userDao.getOne(1L);
        if (user != null) {
            logger.info("user name: {}", user.getName());
        }
    }

}