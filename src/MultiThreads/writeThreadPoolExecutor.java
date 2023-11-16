package MultiThreads;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class writeThreadPoolExecutor {

    private static int produceTaskSleepTime = 2;
    private static int producerTaskMaxNumber = 10;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 4, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i = 0; i < produceTaskSleepTime; i++) {
            try {
                String task = "task@" + i;
                System.out.println("put " + task);
                threadPool.execute(new ThreadPoolTask(task));
                Thread.sleep(produceTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

/**
 * 一般来说任务需要处理数据，数据通过构造犯法传给任务
 */
class ThreadPoolTask implements Runnable, Serializable {

    private static final long serialVersionUID = 0;
    private static final int consumerTaskSleepTime = 2000;

    private Object threadPoolTaskData;

    ThreadPoolTask(Object tasks) {
        this.threadPoolTaskData = tasks;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("start .." + threadPoolTaskData);

        try {
            Thread.sleep(consumerTaskSleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPoolTaskData = null;
    }

    public Object getTask() {
        return this.threadPoolTaskData;
    }
}
