package hello.concurrent;

/**
 * Created by pandeyu on 18/1/7.
 */
class MultiThreadingExample implements Runnable {

//    private  int testValue;
    private volatile int testValue;

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + i);

                if (Thread.currentThread().getName().equalsIgnoreCase("T1")) {
                    testValue = 10+i;
                }
                if (Thread.currentThread().getName().equalsIgnoreCase("T2")) {
                    System.out.println("Test value: " + testValue);
                }

                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class VolatileVisible {

    /**
     * @param args
     */
    public static void main(String[] args) {

        MultiThreadingExample volatileExample = new MultiThreadingExample();

        Thread t1 = new Thread(volatileExample, "T1");
        Thread t2 = new Thread(volatileExample, "T2");

        t1.start();
        t2.start();

    }
}