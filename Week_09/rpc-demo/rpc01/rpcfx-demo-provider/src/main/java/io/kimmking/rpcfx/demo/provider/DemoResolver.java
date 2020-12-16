package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.api.RpcfxResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.LinkedList;

public class DemoResolver implements RpcfxResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(String serviceClass) {
//        Class<?> clazz = null;
//        try {
//            clazz = Class.forName(serviceClass);
//        } catch (ClassNotFoundException e) {
//            return null;
//        }
//        Object object = this.applicationContext.getBeansOfType(clazz).values().stream().findFirst();
//        return object;
        return this.applicationContext.getBean(serviceClass);
    }
}
