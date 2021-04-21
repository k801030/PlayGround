package my.play.ground;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadApp {
    public static void main(String[] args) throws Exception {
        ThreadApp app = new ThreadApp();
        Thread t1 = new Thread(() -> app.start());
        Thread t2 = new Thread(() -> app.start());
        t1.start();
        t2.start();

        Thread.sleep(1000);
        t1.interrupt();
        t2.interrupt();

        test();
    }

    public synchronized void start()  {
        String name = Thread.currentThread().getName();
        log.info("{} notify", name);
        notify();
        try {
            log.info("{} wait", name);
            wait();
            log.info("{} finished", name);
        } catch (InterruptedException e) {
            log.error("{} interrupt exception", name, e);
        }
    }

    private static void test() throws Exception {
        Thread t = new TestThread();
        // t.stop();

        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
    }
}

@Slf4j
class TestThread extends Thread {
    @Override
    public void run() {
        long count = 0;
        while (!isInterrupted()) {
            count++;
        }
        log.info("count={}", count);
    }
}