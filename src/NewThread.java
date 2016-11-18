/**
 * Created by joewei on 11/18/2016.
 */
public class NewThread implements Runnable{
    Thread thread;

    NewThread(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    public void run () {
        System.out.println("Start " + thread.getName());
        try {
            for(int count = 0; count < 5; count++) {
                thread.sleep(1000);
                System.out.println(thread.getName() + "is running @ " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(thread.getName() + " is terminated");
    }
}
