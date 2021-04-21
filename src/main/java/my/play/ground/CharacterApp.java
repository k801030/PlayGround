package my.play.ground;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CharacterApp {

    public static void main(String[] args) {
        log.info("{}", Integer.valueOf('0'));
        log.info("{}", Integer.valueOf('1'));
        log.info("{}", Integer.valueOf('9'));
        log.info("{}", Integer.valueOf('['));
    }

    private void character() {
        String s = "abc";
        String b = s + 'b';

    }
}
