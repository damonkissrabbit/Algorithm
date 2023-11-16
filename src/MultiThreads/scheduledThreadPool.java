package MultiThreads;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class scheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(1000L);
                System.out.println(System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(1000L);
                System.out.println(System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(
                () -> System.out.println("Execute 5 minute later, schedule."),
                5,
                TimeUnit.SECONDS
        );
    }
}
