package com.liao.jvm;

/**
 * <p>
 * start() 和 join() 的区别
 * </p>
 *
 * @author LiAo
 * @since 2021/3/23
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("22222222");
        });

        thread.start();
        thread.join();

        // 这段代码必须要等thread全部执行完毕才执行
        System.out.println("11111");
    }
}
