public class Deadlock {
    public static void main(String[] args) {

        //Simple Deadlock realization
        Object o1 = new Object();
        Object o2 = new Object();

        Thread DThread1 = new Thread(() -> {
            //I wrote (start) and (end) to check if this thread ends
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (o1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o2) {

                }
            }

            System.out.println(Thread.currentThread().getName() + " end");
        }, "DThread1");

        Thread DThread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (o2) {

                synchronized (o1) {

                }
            }

            System.out.println(Thread.currentThread().getName() + " end");
        }, "DThread2");

        DThread1.start();
        DThread2.start();
    }
}
