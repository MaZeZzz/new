package multithread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExecutor {
    public static void main(String[] args) {
        TimerTask timerTask  = new TimerThread();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask,0,4*1000);
        System.out.println("TimerTask started");

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
