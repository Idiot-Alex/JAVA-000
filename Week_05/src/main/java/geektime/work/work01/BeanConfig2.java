package geektime.work.work01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 使用 @Configuration 注解让 Spring 解析这个类
 * 然后使用 @ImportResource 让 Spring 加载这个配置文件
 */
@Configuration
@ImportResource(locations = {"classpath:bean.xml"})
public class BeanConfig2 {

}
