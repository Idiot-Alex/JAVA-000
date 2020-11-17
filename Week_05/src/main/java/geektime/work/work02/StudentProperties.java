package geektime.work.work02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 读取配置文件的属性
 * 加载到类中
 */
@ConfigurationProperties(prefix = "student")
public class StudentProperties {

    @Value("${student.id}")
    private int id;

    @Value("${student.name}")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
