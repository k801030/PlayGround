import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockApp {
    private final ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockApp app = new ReentrantLockApp();

        Runnable runnable = () -> {
            try {
                app.lock.lockInterruptibly();
                System.out.println(String.format("%s %s locked", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
            }
            catch (InterruptedException e) {
                System.out.println(String.format("%s %s interrupted", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
            }
        };
        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");

        threadA.start();
        Thread.sleep(1000);
        threadB.start();
        threadB.interrupt();
    }
}
