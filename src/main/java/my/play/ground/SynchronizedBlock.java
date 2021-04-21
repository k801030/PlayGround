package my.play.ground;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SynchronizedBlock {
    public static void main(String[] args) throws Exception {
        int n = 400000;
        Path path = new Path();
        SyncPath syncPath = new SyncPath();

        int nThread = 4;
        CountDownLatch latch = new CountDownLatch(nThread);
        Stopwatch stopwatch = Stopwatch.createStarted();

        for (int i = 0; i < nThread; i++) {
            new Thread(() -> {
                for (int j = 0; j < n / nThread; j++) {
                    path.run();
                }
                latch.countDown();
            }).start();
        }

        latch.await();

        long duration = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        stopwatch.reset();
        stopwatch.start();
        for (int i = 0; i < n; i++) {
            syncPath.run();
        }

        long syncDuration = stopwatch.elapsed(TimeUnit.MILLISECONDS);

        log.info("duration={}, sync duration={}", duration, syncDuration);
        log.info("result={}, sync result={}", path.i, syncPath.i);
    }


}

class Path {
    int i = 0;

    void run() {
        i++;
    }
}

class SyncPath {
    int i = 0;

    synchronized void run() {
        i++;
    }
}
