package my.play.ground;

public class InputGeneratorApp {

    public static void main(String[] args) {
        InputGeneratorApp app = new InputGeneratorApp();
        String result = app.printListOfInteger(3 * 10000);
        System.out.println(result);
    }

    public String printListOfInteger(int size) {
        int num = 1;
        String output = "[";
        for (int i = 0; i < size; i++) {
            if (i == 0) output += num;
            else output += "," + num;
        }
        output += "]";
        return output;
    }
}
