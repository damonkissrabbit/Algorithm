package MultiThreads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class submitExecute {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executors = Executors.newFixedThreadPool(2);
//        Future<Long> future = executors.submit(() -> {
//            System.out.println("task is submitted");
//            System.out.println(System.currentTimeMillis());
//            return System.currentTimeMillis();
//        });
//        System.out.println("future result: " + future.get());
//        executors.shutdownNow();
//        System.out.println(executors.isTerminated());
//        String a = "aaa";
//        executors.execute(() -> {
//            System.out.println(a);
//        });

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future<?> future = executor.submit(new DivTask(100, i));
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static class DivTask implements Runnable {
        int a, b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double result = a / b;
            System.out.println(result);
        }
    }
}
