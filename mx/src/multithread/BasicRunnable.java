package multithread;

public class BasicRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable start "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            Processing();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Runnable end "+Thread.currentThread().getName());
    }
    private void Processing() throws InterruptedException{
        System.out.println("Processing...");
        Thread.sleep(5000);
    }
}
