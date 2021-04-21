package my.play.ground;

public class IntegerApp {
    public static void main(String[] args) {
        System.out.println(genArray(100000));

    }

    private static String genArray(int n) {
        String s = "[";
        for (int i = 0; i < n; i++) {
            if (i == 0) s += i;
            else s += "," + i;
        }
        s += "]";
        return s;
    }

}
