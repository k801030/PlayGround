package my.play.ground;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorServiceApp {
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }
}
