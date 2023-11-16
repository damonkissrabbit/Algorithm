package MultiThreads;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class writeThreadPoolExecutor2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutorTest threadPoolExecutorTest = new ThreadPoolExecutorTest();
        threadPoolExecutorTest.createThreadPool();
    }
}

class ThreadPoolExecutorTest {
    private static int queueDeep = 4;

    public void createThreadPool() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 4, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (getQueueSize(threadPoolExecutor.getQueue()) >= queueDeep) {
                System.out.println("The queue is already full, please wait 3 seconds to add tasks.");
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            TaskThreadPool taskThreadPool = new TaskThreadPool(i);
            System.out.println("put i: " + i);
            threadPoolExecutor.execute(taskThreadPool);
        }
    }

    private synchronized int getQueueSize(Queue queue) {
        return queue.size();
    }
}

class TaskThreadPool implements Runnable {

    private int index;

    public TaskThreadPool(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " index: " + index);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
