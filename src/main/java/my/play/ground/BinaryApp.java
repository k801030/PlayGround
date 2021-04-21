package my.play.ground;

public class BinaryApp {

    public static void main(String[] args) {


        BinaryApp app = new BinaryApp();

        int a = app.fromBinary("1001");
        int b = app.fromBinary("1100");

        app.print(31);
        app.print(31 * 2);
        app.print(32);
        app.print(32 * 2);

        // AND
        app.print(a & b);

        // XOR
        app.print(a ^ b);

        // OR
        app.print(a | b);

        // the same num
        app.print(a & a);
        app.print(a ^ a);
        app.print(a | a);

    }

    String toBinary(int num) {
        return Integer.toBinaryString(num);
    }

    int fromBinary(String bits) {
        final int BINARY = 2;
        return Integer.parseInt(bits, BINARY);
    }

    void print(int num) {
        print(toBinary(num));
    }

    void print(String string) {
        System.out.println(string);
    }
}
