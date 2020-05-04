import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author pdj
 * @date 2020-05-04 19:31
 */
public class TankFrame extends Frame {
    //x 坐标
    private Tank myTank;
    private Tank enemy;


    public TankFrame() {

        this.setName("tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);

        //监听 Observer 观察者模式
        this.addKeyListener(new TankKeyListener());

        myTank = new Tank(100, 100, Dir.R);
        enemy = new Tank(200, 200, Dir.D);
    }

    //谁初始化了Graphics g这个参数， 系统初始化的可以直接用
    //g 是画笔
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        enemy.paint(g);

    }

    private class TankKeyListener extends KeyAdapter {

        //按键盘
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            myTank.keyPressed(keyEvent);

        }

        //按后抬起
        @Override
        public void keyReleased(KeyEvent keyEvent) {
            myTank.keyReleased(keyEvent);
        }
    }
}
