package multithread.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

class Counter implements Runnable{
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0 ; i<5; i++){
            process(i);
            int courret = count.incrementAndGet();
            System.out.println(Thread.currentThread().getName()+ " courret = " + courret);
        }
    }

    public void process(int i){
        try {
            Thread.sleep(i*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public int getCount(){
        return count.get();
    }
}

public class BasicAtom {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter,"t1");
        Thread t2 = new Thread(counter,"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counting to " +counter.getCount());
    }

}
