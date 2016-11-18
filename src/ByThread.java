/**
 * Created by joewei on 11/18/2016.
 */
public class ByThread extends Thread {
    int times;

    ByThread(String name, int times) {
        super(name);
        this.times = times;
    //    start();
    }

    @Override
    public void run() {
        try {
            for(int i=0; i<times; i++) {
                sleep(10);
                System.out.println(getName() + "is running @ " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(getName() + " is terminated");
    }
}
