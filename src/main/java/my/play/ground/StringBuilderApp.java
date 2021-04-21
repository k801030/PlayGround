package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;

@Slf4j
public class StringBuilderApp {
    int n = 20000;

    public static void main(String[] args) {
        StringBuilderApp app = new StringBuilderApp();
        Stopwatch stopwatch = new Stopwatch();

        stopwatch.start();
        app.string();
        stopwatch.stop();
        log.info("string: {} ms", stopwatch.elapsedMs());

        stopwatch.start();
        app.stringBuilder();
        stopwatch.stop();
        log.info("string builder: {} ms", stopwatch.elapsedMs());

        stopwatch.start();
        app.stringBuffer();
        stopwatch.stop();
        log.info("string buffer: {} ms", stopwatch.elapsedMs());

        stopwatch.start();
        app.dynamicString();
        stopwatch.stop();
        log.info("dynamic string : {} ms", stopwatch.elapsedMs());

        stopwatch.start();
        app.dynamicStringBuilder();
        stopwatch.stop();
        log.info("dynamic string builder: {} ms", stopwatch.elapsedMs());

        app.address();
        app.equals();
    }

    public void address() {
        String s1 = "1";
        String s2 = s1;
        log.info("s1={}, s2={}", s1.hashCode(), s2.hashCode());
        s2 += "23";
        log.info("s1={}, s2={}", s1.hashCode(), s2.hashCode());
    }

    public void equals() {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        String s4 = new String("1") + "23";
        log.info("s1 == s2: {}", s1 == s2);
        log.info("s1 == s3: {}", s1 == s3);
        log.info("s1 == s4: {}", s1 == s4);

        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        log.info("i1 == i2: {}", i1 == i2);
        log.info("i1.equals(i2): {}", i1.equals(i2));
    }

    public String string() {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "abcdefghijklmnopqrstuvwxyz";
        }
        return s;
    }

    public String dynamicString() {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += randomString(26);
        }
        return s;
    }

    public String stringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        return sb.toString();
    }

    public String dynamicStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(randomString(26));
        }
        return sb.toString();
    }

    public String stringBuffer() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        return sb.toString();
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
