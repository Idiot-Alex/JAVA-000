# JVM 垃圾回收器分析

下面是几种常用的垃圾回收器在不同堆大小的情况下，统计出的垃圾回收次数表格

![JVM 垃圾回收器表格](https://github.com/Idiot-Alex/JAVA-000/blob/main/Week_02/src/jvm/images/0.png?raw=true)

从表格里可以看出不同 GC 在 1000 毫秒内生成的对象数差距不大，为了减少变量的影响，重复执行了多次取近似值的方式进行统计。

主要分析的纬度有两个，一个是堆的大小，另一个是垃圾回收的次数。当然，垃圾回收又分为 Young GC 和 Full GC 两种。为了更加直观的表示，下面画出了对应的图表。

> 可以直接访问下面的链接查看完整信息
> https://www.yuque.com/hotstrip11/tev6bm/hbobe2

![分析图 1](https://github.com/Idiot-Alex/JAVA-000/blob/main/Week_02/src/jvm/images/1.png?raw=true)
![分析图 2](https://github.com/Idiot-Alex/JAVA-000/blob/main/Week_02/src/jvm/images/2.png?raw=true)
![分析图 3](https://github.com/Idiot-Alex/JAVA-000/blob/main/Week_02/src/jvm/images/3.png?raw=true)

可以明显的看出，在内存比较小的情况下，并行的 GC （Parallel GC 和 CMS GC）可能还不如串行的 GC。

而并行的 GC 在相同内存大小情况下，CMS GC 会比 Parallel GC 表现的更好一点。

G1 GC 在内存较小的情况下 Young GC 会频繁触发，但是内存足够的情况下，各方面就会表现的比其他垃圾回收器好。
