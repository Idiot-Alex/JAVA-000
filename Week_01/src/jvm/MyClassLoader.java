package jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作业：加载同包下面的 Hello.xlass 文件，里面有个 Hello 类
 * 执行里面的 hello 方法
 */
public class MyClassLoader extends ClassLoader {
    private static String CLASS_NAME = "Hello.xlass";

    /**
     * 重写 findClass 方法，根据当前类路径查找指定的 Hello.xclass 文件
     * 读取文件流，并且解码，返回 Class
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = this.getClass().getResource("").getPath() + CLASS_NAME;
        File file = new File(filePath);
        byte[] bytes = new byte[(int) file.length()];
        BufferedInputStream bufferedInputStream = null;
        try {
            // 加载文件流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            if (bufferedInputStream != null) {
                int n = bufferedInputStream.read(bytes);
                if (n != file.length()) {
                    throw new IOException("read file error...");
                }
                // 对字节流数据解码
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (255 - bytes[i]);
                }
            }
        } catch (IOException e) {
            throw new ClassNotFoundException("class not found");
        }
        // 返回 class
        return this.defineClass(name, bytes,0, bytes.length);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        // 利用重写的类加载器加载指定的类
        Class cls = myClassLoader.findClass("Hello");
        Object obj = cls.newInstance();
        // 获取对应的方法，执行
        Method method = cls.getMethod("hello");
        method.invoke(obj);
    }
}