package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Slf4j
public class CheckFunctionalLog {
    public static void main(String[] args) {
        CheckFunctionalLog app = new CheckFunctionalLog();
        app.run();
    }

    public void run() {
        Set<String> execute = new HashSet<>();
        Set<String> success = new HashSet<>();
        int count = 0;
        try {
            File myObj = new File("/Users/zli02/repo/Playground/src/main/resources/functional-test-log4.txt");
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] strings = line.split("]");;
                if (strings.length == 2) {
                     // log.info("{} and {}", strings[0], strings[1]);
                     String type = strings[0];
                     String content = strings[1];
                     if (type.equals("Execute")) {
                         execute.add(content);
                     } else if (type.equals("Success")) {
                         success.add(content);
                     } else {
                         // log.warn("type error: type={}, line={}", type, line);
                     }
                } else {
                    // log.warn(line);
                }
                count++;
            }
        } catch (Exception e) {
            log.error("no such file", e);
        }




        log.info("total: {}", count);
        log.info("total execute: {}", execute.size());
        log.info("total success: {}", success.size());


        for (String s : success) {
            execute.remove(s);
        }

        log.info("Remain:");
        for (String remain : execute) {
            log.info(remain);
        }

        log.info("total execute: {}", execute.size());
        log.info("total success: {}", success.size());
    }
}
