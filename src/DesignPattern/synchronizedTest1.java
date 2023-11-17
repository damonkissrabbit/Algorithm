package DesignPattern;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/***
 * 使用synchronized加锁this和xxx.class是完全不同的，当加锁this时，表示用当前的对象进行加锁
 * 每个对象都对应一把锁；而当使用xxx.class加锁时，表示使用某个类来加锁，它是应用程序级别的，是全局生效的
 */
public class synchronizedTest1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(() -> {
            synchronizedTest1 synchronizedTest1 = new synchronizedTest1();
            synchronizedTest1.thisMethod();
        });

        executorService.execute(() -> {
            synchronizedTest1 synchronizedTest1 = new synchronizedTest1();
            synchronizedTest1.thisMethod();
        });

        executorService.execute(() -> {
            synchronizedTest1 synchronizedTest1 = new synchronizedTest1();
            synchronizedTest1.classMethod();
        });

        executorService.execute(() -> {
            synchronizedTest1 synchronizedTest1 = new synchronizedTest1();
            synchronizedTest1.classMethod();
        });

    }

    public void thisMethod() {
        synchronized (this) {
            System.out.println("Synchronized(this) lock time: " + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void classMethod() {
        synchronized (synchronizedTest1.class) {
            System.out.println("synchronized(xxx.class) lock time: " + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
