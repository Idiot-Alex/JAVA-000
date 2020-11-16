package geektime.work.work01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * 拿到 Spring 上下文
 */
@Configuration
public class SpringUtil implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(SpringUtil.class);

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public static Object getBean(String name,Class<?> classz) {
        return context.getBean(name,classz);
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
