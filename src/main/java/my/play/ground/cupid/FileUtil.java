package my.play.ground.cupid;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Slf4j
public class FileUtil {
    private static final String base = "/Users/zli02/repo/Playground/src/main/resources/";

    public static String readFromResource(String filename) {
        File myObj = new File(base + filename);
        try {
            Scanner reader = new Scanner(myObj);
            StringBuilder sb = new StringBuilder();
            while (reader.hasNextLine()) {
                sb.append(reader.nextLine());
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            log.info("file not found", filename);
            return "";
        }

    }
}
