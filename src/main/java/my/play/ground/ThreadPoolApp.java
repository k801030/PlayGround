package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ThreadPoolApp {
    public static void main(String[] args) {
        ThreadPoolApp app = new ThreadPoolApp();
        app.start();
    }

    public void start() {
        int corePoolSize = 1;
        int maxPoolSize = 2;
        long keepAliveTime = 1000;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new SynchronousQueue<>();
        RejectedExecutionHandler handler = (r, executor) -> log.error("reject {}", ((Task)r).getId());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                handler
        );
        executor.execute(new Task(1));
        executor.execute(new Task(2));
        executor.execute(new Task(3));
    }

    class Task implements Runnable {
        private int id;
        public Task(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public void run() {
            try {
                log.info("{} is executed", getId());
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
        }
    }
}
