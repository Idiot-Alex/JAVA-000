package geektime.work.work02;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 自动配置类
 * 主要目的：让 Spring Boot 加载这个配置类，从配置文件中加载属性，
 * 构造带属性的 Student 实例
 */
@Configuration
@ConditionalOnClass(Student.class)
@EnableConfigurationProperties(StudentProperties.class)
public class StudentAutoConfig {

    @Resource
    private StudentProperties studentProperties;

    @Bean
    public Student student() {
        Student student = new Student();
        student.setId(studentProperties.getId());
        student.setName(studentProperties.getName());
        return student;
    }
}
