package geektime.work;

import java.util.concurrent.*;

/**
 * 使用 Future 方式取得线程返回值
 */
public class Three {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        // 创建一个 Callable
        Callable<Integer> myCallable = () -> Demo.sum();

        // 启动线程拿到返回值
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(myCallable);

        // 等待执行完成
        Integer result = future.get();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出线程
        executor.shutdown();
    }
}
