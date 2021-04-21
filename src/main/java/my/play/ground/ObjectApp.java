package my.play.ground;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectApp {

    public static void main(String[] args) throws Exception {
        ObjectApp app = new ObjectApp();
        app.object(new Object());
        app.object(new ObjectApp());
    }

    public void object(Object o) throws Exception {
        log.info("{}", o.equals(o));
        log.info("{}", o.hashCode());
        log.info("{}", o.getClass());
        log.info("{}", o.toString());

        // o.wait();
        // o.notify();
        // o.notifyAll();
    }
}
