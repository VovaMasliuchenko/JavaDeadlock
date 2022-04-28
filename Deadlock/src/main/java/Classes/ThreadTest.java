package Classes;

import org.apache.log4j.Logger;

public class ThreadTest extends Thread {

    private static final Logger LOGGER = Logger.getLogger(ThreadTest.class);

    private String name;

    public ThreadTest(){}

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            LOGGER.info(name + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

    }
}
