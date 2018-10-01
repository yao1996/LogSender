import org.junit.Test;

import java.util.Random;

/**
 * @author Yao Keqi
 * @date 2018/6/1
 */
public class RandomTest {

    @Test
    public void randomTest() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(2));
        }
    }
}
