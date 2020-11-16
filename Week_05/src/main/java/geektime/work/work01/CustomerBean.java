package geektime.work.work01;

import org.springframework.stereotype.Component;

/**
 * 作业 1：写代码实现 Spring Bean 的装配
 */
@Component(value = "customerBean3")
public class CustomerBean {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
