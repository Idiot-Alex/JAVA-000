package geektime.work;

import java.util.concurrent.*;

/**
 * 跟 CountDownLatch 效果类似的类，CyclicBarrier
 * 需要注意的是参数值
 */
public class Four {
    private static volatile int result = -1;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        long start = System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        // 启动线程拿到返回值
        Thread thread = new Thread(() -> {
            result = Demo.sum();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        // 等待执行完成
        cyclicBarrier.await();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出线程
    }
}
