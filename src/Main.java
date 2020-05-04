import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * @author pdj
 * @date 2020-05-04 19:31
 */
public class Main {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();

        tf.setVisible(true);

        for (; ; ) {
            try {
                Thread.sleep(25);
                //TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //repaint 内部调用 paint方法
            //repaint -> update -> paint
            tf.repaint();
        }
    }
}
