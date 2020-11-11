package geektime.work;

/**
 * 单线程执行计算数据方法，主线程轮询判断是否拿到返回值
 */
public class One {
    private static volatile int result = -1;

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        // 启动线程拿到返回值
        Thread thread = new Thread(() -> {
            result = Demo.sum();
        });

        thread.start();

        // 这里只是用 -1 作为判断依据
        while (result == -1) {
            Thread.currentThread().sleep(10);
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }
}
