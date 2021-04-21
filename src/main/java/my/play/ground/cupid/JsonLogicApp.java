package my.play.ground.cupid;

import com.google.common.base.Stopwatch;
import com.yahoo.nevec.jsonlogic.JsonLogic2;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JsonLogicApp {
    public static void main(String[] args) {
        JsonLogicApp app = new JsonLogicApp();

        // warm up
        String test = "{\"in\":[{\"var\":\"productId\"},[\"p0788133180273\",\"p0788118890223\"]]}";
        app.parse(test, "test");

        List<String> list = new ArrayList<>();
        list.add("jsonLogic-1");
        list.add("jsonLogic-10");
        list.add("jsonLogic-100");
        list.add("jsonLogic-500");
        list.add("jsonLogic-1000");
        list.add("jsonLogic-5000");
        list.add("jsonLogic-10000");
        list.add("jsonLogic-20000");
        list.add("jsonLogic-30000");
//        list.add("jsonLogic-50000");
//        list.add("jsonLogic-100000");
//        list.add("jsonLogic-200000");
//        list.add("jsonLogic-300000");
//        list.add("jsonLogic-500000");
//        list.add("jsonLogic-1000000");
//        list.add("jsonLogic-2000000");
//        list.add("jsonLogic-3000000");
//        list.add("jsonLogic-5000000");
//        list.add("jsonLogic-10000000");

        for (String file : list) {
            String s = FileUtil.readFromResource(file);
            app.parse(s, file);
        }
    }


    public void parse(String expression, String filename) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 100; i++) {
            JsonLogic2.parse(expression);
        }
        long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        log.info("file={}, elapsed={}, length={}", filename, elapsed, expression.length());
    }

}
