package info.ykqfrost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yao Keqi
 * @date 2018/4/16
 */
public class TestMain implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);
    private static boolean flag = true;
    private static AtomicInteger errorNum = new AtomicInteger(0);
    private static AtomicInteger infoNum = new AtomicInteger(0);
    private static AtomicInteger totalNum = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TestMain.flag = false;
            }
        };
        new Thread(runnable).start();
        new Thread(new TestMain()).start();
    }

    public void run() {
        Random random = new Random();
        while (flag) {
            if (random.nextInt(5) < 2) {
                logger.info(String.valueOf(infoNum));
                infoNum.incrementAndGet();
            } else {
                logger.error(String.valueOf(errorNum));
                errorNum.incrementAndGet();
            }
            totalNum.incrementAndGet();
        }
        logger.debug(String.valueOf(totalNum.get()));
    }
}
