package my.play.ground;

public class Stopwatch {
    private long start = 0;
    private long end = 0;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        end = System.currentTimeMillis();
    }

    public long elapsedMs() {
        return end - start;
    }
}
