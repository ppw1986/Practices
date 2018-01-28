package hello.concurrent;

/**
 * Created by pandeyu on 17/12/12.
 */
public class PossibleReordering {
    volatile static int x=0,y=0;
    volatile static int a=0,b=0;

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                a=1;
                x=b;
            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                b=1;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                y=a;
            }
        });

        two.start();
        one.start();


        one.join(); two.join();
        System.out.println("{"+x+","+y+"}");
    }
}
