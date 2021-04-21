package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WaitforApp {

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(new CURL(20)));
        }

        for (Thread t : list) {
            log.info("{} start", t.getName());
            t.start();
        }
    }
}

@Slf4j
class CURL implements Runnable {
    int count;

    public CURL(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        String url = "https://s.yimg.com/aw/api/res/1.2/r8znM3pVnJ.ZapgYXX3J7A--/YXBwaWQ9eXR3YXVjdGlvbnNlcnZpY2U7aD0yNzA7cT04NTtyb3RhdGU9YXV0bztzcj0xLjI7c3M9MS4yO3c9MTk0/https://s.yimg.com/yn/image/e447cae6-d5d3-4e18-91e5-0a49d4de439c.jpg.cf.jpg";
        String command = "curl -I -f -m 5 "  + url;
        try {
            List<Process> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Process p = Runtime.getRuntime().exec(command);
                list.add(p);
            }

            for (Process p : list) {
                log.info("[{}] {}", Thread.currentThread().getName(), "wait for p");
                p.waitFor();
                log.info("[{}] {}", Thread.currentThread().getName(), p.exitValue());
            }
        } catch (IOException e) {
            log.error("IOException", e);
        } catch (InterruptedException e) {
            log.error("InterruptedException", e);
        }

    }
}
