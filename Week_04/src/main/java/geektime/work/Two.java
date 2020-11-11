package geektime.work;

import java.util.concurrent.CountDownLatch;

/**
 * 使用 CountDownLatch，当线程中的计算方法执行完成就 countDown
 * 主线程通过 await 等待拿到最终结果
 */
public class Two {

    private static volatile int result = -1;

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        // 启动线程拿到返回值
        Thread thread = new Thread(() -> {
            result = Demo.sum();
            countDownLatch.countDown();
        });

        thread.start();

        // 等待执行完成
        countDownLatch.await();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出线程
    }
}
