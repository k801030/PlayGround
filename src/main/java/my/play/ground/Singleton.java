package my.play.ground;

public class Singleton {

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private Singleton() {

    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}