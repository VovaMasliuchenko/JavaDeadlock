package Classes;

import org.apache.log4j.Logger;

public class ThreadTestWithInterface implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(ThreadTestWithInterface.class);

    private String name;

    ThreadTestWithInterface(){}

    public ThreadTestWithInterface(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            LOGGER.info(name + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
