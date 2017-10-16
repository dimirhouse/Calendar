package TrzynastyOstatni.WielowatkowoscJV;

import java.lang.Runnable;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

    private int id;
    @Override
    public void run() {
        while (true){
            System.out.println("worker: " + id);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
