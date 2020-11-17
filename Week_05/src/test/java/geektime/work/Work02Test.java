package geektime.work;

import geektime.work.work02.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Work02Test {
    private static Logger logger = LoggerFactory.getLogger(Work02Test.class);

    @Resource
    private Student student;

    /**
     * 测试注解加载 Bean
     */
    @Test
    public void testGetStudent() {
        logger.info("Student ==> id: {}, access equals 1", student.getId());
        Assert.assertEquals(1, student.getId());

        logger.info("Student ==> name: {}, access equals 'hotstrip'", student.getName());
        Assert.assertEquals("hotstrip", student.getName());
    }

}