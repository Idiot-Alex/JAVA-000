# 学习笔记

了解 Java 语言跨平台特性的原理：编译源代码成 JVM 可识别的字节码文件，JVM 本身屏蔽了底层操作系统的差异，不如说是 JVM 实现了跨平台。

JVM 的重点在于 JVM 的内存模型和垃圾回收机制。

至于字节码，虽然算是 Java 语言的黑科技，但是涉及字节码编程的工作不多。

了解 JVM 的内存模型对 Java 的并发编程以及多线程可能引起的线程安全问题很有作用。

同时，JVM 的垃圾回收机制也是针对 JVM 的堆内存，由于堆内存的「新生代」和「老年代」的区分，也就有了不同的 GC 算法。

# 实践

反编译 jvm.Demo 类获取到字节码内容，简单了解字节码构成。

自定义类加载器加载 Hello.xlass 文件，并且执行该文件里面的 hello 方法，详情见 ./src/main/java/jvm/MyClassLoader.java 文件

了解 JVM 参数对 JVM 内存模型的关系，画出对应的关系图，详情见 ./src/main/resources/ 目录里面的图片
![](https://github.com/Idiot-Alex/JAVA-000/blob/main/Week_01/src/main/resource/images/JVM-args.png?raw=true)


