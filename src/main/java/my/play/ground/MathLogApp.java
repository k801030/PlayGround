package my.play.ground;

public class MathLogApp {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(i + ": " + Math.log(i) / Math.log(2));
        }
    }
}
