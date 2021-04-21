package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class CompletableFutureApp {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName());
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> f = executorService.submit(() -> {
            Thread.sleep(1000);
            return "new thread";
        });
        // print(f.get());
        // f.isDone();


        CompletableFuture cf = new CompletableFuture();
        Future<Object> c2 = Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            cf.complete(500);
            return null;
        });
        // print(cf.complete(1000));
        print(cf.isDone());
        print(cf.get());

    }

    static void print(Object o) {
        log.info("{}", o);
    }
}
