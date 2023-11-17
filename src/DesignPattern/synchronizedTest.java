package DesignPattern;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * synchronized修饰普通方法和静态方法不同，对于静态方法，synchronized加锁是全局的
 * 也就是整个程序运行期间，所有调用这个静态方法的对象都是互斥的，而普通方法是针对对象级别的，不同的对象对应
 * 这不同的锁
 */
public class synchronizedTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(() -> {
            staticMethod();
        });
        executorService.execute(() -> {
            staticMethod();
        });

        // 执行两次普通方法
        executorService.execute(() -> {
            synchronizedTest synchronizedTest = new synchronizedTest();
            synchronizedTest.method();
        });

        executorService.execute(() -> {
            synchronizedTest synchronizedTest = new synchronizedTest();
            synchronizedTest.method();
        });
    }

    public synchronized void method() {
        System.out.println("Execution time of normal method: " + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void staticMethod() {
        System.out.println("Execution time of static method: " + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
