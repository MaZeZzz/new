package multithread;

public class DaemonExecutor {
    public static void main(String[] args) throws InterruptedException {
        Thread dt = new Thread(new DaemonThread(),"dt");
        dt.setDaemon(true);
        dt.start();

        Thread.sleep(3000);
        System.out.println("Finshing process");
    }
}
