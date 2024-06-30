import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public Window(JPanel panel) {
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new CardLayout());
        this.add(panel);
        this.setVisible(true);
    }
}