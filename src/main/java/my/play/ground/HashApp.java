package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class HashApp {
    public static void main(String[] args) {
        int a = 11;
        int n = 7;
        log.info("11 & 7: {} & {} -> {}",
                Integer.toBinaryString(a),
                Integer.toBinaryString(n),
                Integer.toBinaryString(a & n));

        log.info("11 ^ 7: {} & {} -> {}",
                Integer.toBinaryString(a),
                Integer.toBinaryString(n),
                Integer.toBinaryString(a ^ n));

        log.info("10 >>> 1: {} -> {}", Integer.toBinaryString(10), Integer.toBinaryString(10 >>> 1));

        hash(65536);
        hash(131072);
        hash(65536 + 1);
        hash(65536 + 3);

        hash(256);
        hash(512);
        hash(256 + 1);

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
    }

    static final int hash(Object key) {
        int h = 0;
        int n = 256;
        int bucket = key.hashCode() % n;
        int result =  (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int newBucket = result % n;
        log.info("key={}, [old] hashCode={}, bit={}, bucket={}, [new] hashCode={}, bit={}, bucket={}",
                key, key.hashCode(), Integer.toBinaryString(key.hashCode()), bucket,
                result, Integer.toBinaryString(result), newBucket);
        log.info("{} ^ {} -> {}",
                Integer.toBinaryString(h), Integer.toBinaryString(h >>> 16), Integer.toBinaryString(result));
        return result;
    }
}
