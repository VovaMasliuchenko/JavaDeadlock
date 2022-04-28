import Classes.ThreadTest;
import Classes.ThreadTestWithInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //By using "Extends Thread"
        ThreadTest t1 = new ThreadTest("First thread (extends)");
        ThreadTest t2 = new ThreadTest("Second thread (extends)");
        ThreadTest t3 = new ThreadTest("Third thread (extends)");

        //By using "Implements Runnable"
        ThreadTestWithInterface twi1 = new ThreadTestWithInterface("First thread (implement)");
        Thread thread1 = new Thread(twi1);
        ThreadTestWithInterface twi2 = new ThreadTestWithInterface("Second thread (implement)");
        Thread thread2 = new Thread(twi2);
        ThreadTestWithInterface twi3 = new ThreadTestWithInterface("Third thread (implement)");
        Thread thread3 = new Thread(twi3);

        //Call threads just using method start()
        t1.start();
        t2.start();
        t3.start();

        //Using thread pool to store threads
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.execute(twi1);
        threadPool.execute(twi2);
        threadPool.execute(twi3);

        threadPool.shutdown();

    }
}
