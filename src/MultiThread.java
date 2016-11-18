class TheThread implements Runnable {
    String threadName;

    TheThread(String name) {
        threadName = name;
    }

    public void run() {
        System.out.println(threadName + " staring");

        try {
             for (int count=0; count < 5; count++) {
                 Thread.sleep(1000);
                 System.out.println(threadName + " is running @ " + count);
             }
        } catch (InterruptedException e) {
            System.out.println(threadName + " is interrupted by " + e.getMessage());
        }

        System.out.println(threadName + " is terminated");
    }
}

class MultiThread {
    public static void main(String args[]) {
        TheThread firstthread = new TheThread("Firstthread");
        NewThread secondthread = new NewThread("SecondThread");
        ByThread thirdthread = new ByThread("ThirdThread", 1000);
        ByThread forththread = new ByThread("ForthThread", 100);
        ByThread fifththread = new ByThread("FifthThread", 100);

        Thread thread_1 = new Thread(firstthread);

        thread_1.start();
     //   firstthread.run();
 //       secondthread.run();
        do {
        //for (int i=0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } while(thirdthread.isAlive() || thread_1.isAlive());

        forththread.start();
        fifththread.start();
        try {
            forththread.join();
            System.out.println(forththread.getName() + " is joined");
            fifththread.join();
            System.out.println(fifththread.getName() + " is joined");
        } catch (InterruptedException e) {
            System.out.print(".");
        }
    }
}