package my.play.ground.cupid;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ExpressionGenerator {
    private static final String DIR = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        ExpressionGenerator.gen(1, "jsonLogic-1");
        ExpressionGenerator.gen(2, "jsonLogic-2");
        ExpressionGenerator.gen(10, "jsonLogic-10");
        ExpressionGenerator.gen(100, "jsonLogic-100");
        ExpressionGenerator.gen(500, "jsonLogic-500");
        ExpressionGenerator.gen(1000, "jsonLogic-1000");
        ExpressionGenerator.gen(5000, "jsonLogic-5000");
        ExpressionGenerator.gen(10000, "jsonLogic-10000");
        ExpressionGenerator.gen(20000, "jsonLogic-20000");
        ExpressionGenerator.gen(30000, "jsonLogic-30000");
        ExpressionGenerator.gen(50000, "jsonLogic-50000");
        ExpressionGenerator.gen(100000, "jsonLogic-100000");
        ExpressionGenerator.gen(200000, "jsonLogic-200000");
        ExpressionGenerator.gen(300000, "jsonLogic-300000");
        ExpressionGenerator.gen(500000, "jsonLogic-500000");
        ExpressionGenerator.gen(1000000, "jsonLogic-1000000");
        ExpressionGenerator.gen(2000000, "jsonLogic-2000000");
        ExpressionGenerator.gen(3000000, "jsonLogic-3000000");
        ExpressionGenerator.gen(5000000, "jsonLogic-5000000");
        ExpressionGenerator.gen(10000000, "jsonLogic-10000000");
    }

    public static void gen(int size, String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"in\":[{\"var\":\"productId\"},[");
        for (int i = 0; i < size; i++) {

            String data = "\"p0000" + String.format("%09d", i) + "\"";
            if (i == 0) {
                sb.append(data);
            } else {
                sb.append("," + data);
            }
        }
        sb.append("]]}");


        String result = sb.toString();
        log.info("size={}, length={}", size, result.length());

        PrintWriter writer = new PrintWriter(DIR + filename, "UTF-8");
        writer.println(result);
        writer.close();
    }
}
