package info.ykqfrost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/test.txt")));
            String s;
            Random random = new Random();
            int errorNum = 0;
            while ((s = br.readLine()) != null) {
                logger.info(s);
                Thread.sleep(500);
                if (random.nextInt(5) < 2) {
                    errorNum++;
                    logger.error(String.valueOf(errorNum));
                    Thread.sleep(500);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
