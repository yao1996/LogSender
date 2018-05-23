package info.ykqfrost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author Yao Keqi
 * @date 2018/4/16
 */
public class Main implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static boolean flag = true;
    private static int errorNum = 0;
    private static int infoNum = 0;
    private static int totalNum = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Main.flag = false;
            }
        };
        new Thread(runnable).start();
        new Thread(new Main()).start();
    }

    public void run() {
        Random random = new Random();
        while (flag) {
            if (random.nextInt(5) < 2) {
                logger.info(String.valueOf(infoNum));
                infoNum++;
            } else {
                logger.error(String.valueOf(errorNum));
                errorNum ++;
            }
            totalNum ++;
        }
        logger.debug(String.valueOf(totalNum));
    }
}
