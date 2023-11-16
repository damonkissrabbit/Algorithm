package MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadsTest {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executors.submit(() -> {
                System.out.println("thread is is: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
