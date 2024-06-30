import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private Basket basketBall;
    private JPanel p;

    public Controller(Basket basketBall, JPanel p) {
        this.basketBall = basketBall;
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.basketBall.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.basketBall.moveLeft();
        }
        p.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}