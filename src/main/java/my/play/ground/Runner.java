package my.play.ground;

public class Runner implements One, Two {
    public void run() {
        // One.run();
        // super.One.run();
        One.super.run();
    }
}
