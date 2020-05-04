import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author pdj
 * @date 2020-05-04 20:43
 */
public class Tank {
    //坦克移动坐标
    private int x, y;
    //坦克方向
    private Dir dir;
    //用于判断是否按下
    private boolean bL, bU, bR, bD;

    //移动速度
    public static final int SPEED = 5;


    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);

        move();
    }

    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = true;
                dir = Dir.L;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                dir = Dir.U;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                dir = Dir.R;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                dir = Dir.D;
                break;
        }

        setMainDir();
    }

    private void setMainDir() {
        if (!bL && !bU && !bR && !bD) {
            dir = Dir.STOP;
        }
        if (bL && !bU && !bR && !bD) {
            dir = Dir.L;
        }
        if (!bL && bU && !bR && !bD) {
            dir = Dir.U;
        }
        if (!bL && !bU && bR && !bD) {
            dir = Dir.R;
        }
        if (!bL && !bU && !bR && bD) {
            dir = Dir.D;
        }

    }

    private void move() {
        switch (dir) {
            case L:
                x -= SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case D:
                y += SPEED;
                break;
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
        }
        setMainDir();
    }
}
