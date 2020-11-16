package geektime.work.work01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用 @Configuration 注解让 Spring 解析这个类
 * 然后使用 @Bean 让 Spring 执行这个方法并且返回对应的 Bean
 */
@Configuration
public class BeanConfig1 {

    @Bean
    public CustomerBean1 newBean() {
        return new CustomerBean1();
    }
}
