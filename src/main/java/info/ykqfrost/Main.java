package info.ykqfrost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yao Keqi
 * @date 2018/4/16
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i%2==0) {
                LOGGER.info("hello storm " + i);
            } else {
                LOGGER.error("error sink " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
