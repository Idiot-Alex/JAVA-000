package geektime.java000.jvm;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
/**
 * 演示GC日志生成与解读
 * 使用命令输入 GC 日志
 * +UseSerialGC 表示使用 Serial GC
 * +UseParallelGC 表示使用 Parallel GC
 * +UseConcMarkSweepGC 表示使用 CMS GC
 * +UseG1Gc 表示使用 G1 GC
 * -Xloggc:xxx.log 表示输出到指定文件
 * java -XX:+UseSerialGC -Xmx512m -Xms512m -Xloggc:gc.serial.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
 *
 * 测试使用的指令，方便复制：
 * java -XX:+UseSerialGC -Xmx512m -Xms512m -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:serial.log GCLogAnalysis
 * java -XX:+UseParallelGC -Xmx512m -Xms512m -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:parallel.log GCLogAnalysis
 * java -XX:+UseConcMarkSweepGC -Xmx512m -Xms512m -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:cms.log GCLogAnalysis
 * java -XX:+UseG1GC -Xmx512m -Xms512m -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:g1.log GCLogAnalysis
*/
public class GCLogAnalysis {
    private static Random random = new Random();
    public static void main(String[] args) {
        // 当前毫秒时间戳
        long startMillis = System.currentTimeMillis();
        // 持续运行毫秒数; 可根据需要进行修改
        long timeoutMillis = TimeUnit.SECONDS.toMillis(1);
        // 结束时间戳
        long endMillis = startMillis + timeoutMillis;
        LongAdder counter = new LongAdder();
        System.out.println("正在执行...");
        // 缓存一部分对象; 进入老年代
        int cacheSize = 2000;
        Object[] cachedGarbage = new Object[cacheSize];
        // 在此时间范围内,持续循环
        while (System.currentTimeMillis() < endMillis) {
            // 生成垃圾对象
            Object garbage = generateGarbage(100*1024);
            counter.increment();
            int randomIndex = random.nextInt(2 * cacheSize);
            if (randomIndex < cacheSize) {
                cachedGarbage[randomIndex] = garbage;
            }
        }
        System.out.println("执行结束!共生成对象次数:" + counter.longValue());
    }

    // 生成对象
    private static Object generateGarbage(int max) {
        int randomSize = random.nextInt(max);
        int type = randomSize % 4;
        Object result = null;
        switch (type) {
            case 0:
                result = new int[randomSize];
                break;
            case 1:
                result = new byte[randomSize];
                break;
            case 2:
                result = new double[randomSize];
                break;
            default:
                StringBuilder builder = new StringBuilder();
                String randomString = "randomString-Anything";
                while (builder.length() < randomSize) {
                    builder.append(randomString);
                    builder.append(max);
                    builder.append(randomSize);
                }
                result = builder.toString();
                break;
        }
        return result;
    }
}