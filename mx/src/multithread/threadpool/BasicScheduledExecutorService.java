package multithread.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class SchEduledTask implements Runnable{
    private int taskId;

    public SchEduledTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Task #" + this.taskId + "run at" + currentDateTime);
    }
}

public class BasicScheduledExecutorService {
    public static void main(String[] args) {
        final int threadPoolSize = 3;
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(threadPoolSize);

        SchEduledTask task1 = new SchEduledTask(1);
        SchEduledTask task2 = new SchEduledTask(2);

        scheduledExecutorService.schedule(task1,2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(task2, 0,10,TimeUnit.SECONDS);

        try{
            TimeUnit.SECONDS.sleep(25);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();

    }
}
