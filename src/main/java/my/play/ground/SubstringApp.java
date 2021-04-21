package my.play.ground;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubstringApp {
    public static void main(String[] args) {
        String s = "123456";
        for (int i = 0; i < s.length(); i++) {
            log.info(s.substring(0, i));
        }
    }
}
