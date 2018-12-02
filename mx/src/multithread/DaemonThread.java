package multithread;

public class DaemonThread implements Runnable {
    @Override
    public void run() {
        while(true){
            processing();
        }
    }

    private void processing(){
        System.out.println("processing");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
