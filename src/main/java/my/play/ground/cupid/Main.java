package my.play.ground.cupid;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;

@Slf4j
public class Main {
    static String filename = "jsonLogic-30000";
    static int size = 5;

    public static void main(String[] args) throws Exception {


        if (args.length >= 2) {
            filename = args[0];
            size = Integer.parseInt(args[1]);
        }


        log.info("start");
        Thread.sleep(10000);
        checkMemory();

        String s = readFile();
        log.info("finish");
    }

    private static void checkMemory() {
        for (MemoryPoolMXBean mpBean: ManagementFactory.getMemoryPoolMXBeans()) {
            if (mpBean.getType() == MemoryType.HEAP) {
                System.out.printf(
                        "Name: %s: %s\n",
                        mpBean.getName(), mpBean.getUsage()
                );
            }
        }
    }

    private static String readFile() {
        StringBuilder sb = new StringBuilder();
        String s = FileUtil.readFromResource(filename);
        for (int i = 0; i < size; i++) {
            try {
                sb.append(s);
            } catch (OutOfMemoryError e) {
                log.info("OOM: when append at {} round, with size {}", i, sb.length());
                throw e;
            }
        }
        return sb.toString();
    }
}
