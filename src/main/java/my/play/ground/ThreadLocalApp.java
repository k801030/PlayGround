package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class ThreadLocalApp {

    public ThreadLocal<StringBuilder> value = ThreadLocal.withInitial(() -> new StringBuilder());

    public static void main(String[] args) throws Exception {
        ThreadLocalApp app = new ThreadLocalApp();
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(new MyRunnable(5, app.value, countDownLatch)).start();
        }
        countDownLatch.await();
    }

}

@Slf4j
class MyRunnable implements Runnable {
    int count;
    ThreadLocal<StringBuilder> value;
    CountDownLatch countDownLatch;

    public MyRunnable(int count, ThreadLocal<StringBuilder>  value, CountDownLatch countDownLatch) {
        this.count = count;
        this.value = value;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            value.get().append(i);
            log.info("Thread: {}, instance: {}, value: {}",
                    Thread.currentThread().getName(), value.get().hashCode(), value.get().toString());
            countDownLatch.countDown();
        }
    }
}



