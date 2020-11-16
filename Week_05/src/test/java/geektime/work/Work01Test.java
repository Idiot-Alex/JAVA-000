package geektime.work;

import geektime.work.work01.CustomerBean1;
import geektime.work.work01.CustomerBean2;
import geektime.work.work01.CustomerBean;
import geektime.work.work01.SpringUtil;
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
public class Work01Test {
    private static Logger logger = LoggerFactory.getLogger(Work01Test.class);

    @Resource
    private CustomerBean1 customerBean1;

    @Resource
    private CustomerBean2 customerBean2;

    /**
     * 测试注解加载 Bean
     */
    @Test
    public void testAnnotationBean() {
        logger.info("使用 @Bean 注解加载 Bean");
        logger.info("CustomerBean1 ==> state: {}, access equals 0", customerBean1.getState());
        Assert.assertEquals(0, customerBean1.getState());

        customerBean1.setState(100);
        logger.info("CustomerBean1 ==> state: {}, access equals 100", customerBean1.getState());
        Assert.assertEquals(100, customerBean1.getState());
    }

    /**
     * 测试 xml 加载 Bean
     */
    @Test
    public void testXmlBean() {
        logger.info("使用 xml 加载 Bean");
        logger.info("CustomerBean2 ==> state: {}, access equals 0", customerBean2.getState());
        Assert.assertEquals(0, customerBean2.getState());

        customerBean2.setState(1000);
        logger.info("CustomerBean2 ==> state: {}, access equals 1000", customerBean2.getState());
        Assert.assertEquals(1000, customerBean2.getState());
    }

    /**
     * 使用 Spring 上下文加载 Bean
     */
    @Test
    public void testSpringContentBean() {
        logger.info("使用 Spring Content 加载 Bean");
        CustomerBean customerBean3 = (CustomerBean) SpringUtil.getBean("customerBean3");
        logger.info("CustomerBean3 ==> state: {}, access equals 0", customerBean3.getState());
        Assert.assertEquals(0, customerBean3.getState());

        customerBean3.setState(10);
        logger.info("CustomerBean3 ==> state: {}, access equals 10", customerBean3.getState());
        Assert.assertEquals(10, customerBean3.getState());
    }
}