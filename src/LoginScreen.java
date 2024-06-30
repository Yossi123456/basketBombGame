import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginScreen extends JPanel{
    private JLabel play;
    private JLabel help;
    private JLabel nameOfGame;
    private ImageIcon background;
    private ImageIcon backButtonPlay;
    private ImageIcon backButtonHelp;

    private JPanel p = this;

    public LoginScreen(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);

        background = new ImageIcon("background1.png");
        backButtonPlay = new ImageIcon("BasketballButton.png");
        backButtonHelp = new ImageIcon("questionMark.png");

        play = new JLabel();
        play.setBounds(350, 250, 100, 100);
        play.setText("play");
        play.setFocusable(false);
        play.setFont(new Font("MV Boli", Font.PLAIN, 35));
        play.setForeground(Color.CYAN);
        play.setIcon(backButtonPlay);
        play.setHorizontalTextPosition(JLabel.CENTER);
        this.add(play);
        play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new Window(new GameScreen(0,0,800,600));

                Window window = (Window) SwingUtilities.getWindowAncestor(p);
                window.dispose();
            }
        });

        nameOfGame = new JLabel("BasketBomb");
        nameOfGame.setFont(new Font("MV Boli", Font.PLAIN, 60));
        nameOfGame.setFocusable(false);
        nameOfGame.setBounds(200, 400 ,400, 100);
        nameOfGame.setHorizontalAlignment(JLabel.CENTER);
        nameOfGame.setVerticalAlignment(JLabel.CENTER);
        nameOfGame.setForeground(Color.WHITE);
        this.add(nameOfGame);

        help = new JLabel();
        help.setBounds(0, 0, 75, 75);
        help.setFocusable(false);
        help.setHorizontalAlignment(JLabel.CENTER);
        help.setVerticalAlignment(JLabel.CENTER);
        help.setIcon(backButtonHelp);
        this.add(help);
        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new Window(new HelpScreen(0,0,800,600));
                Window window = (Window) SwingUtilities.getWindowAncestor(p);
                window.dispose();

            }
        });

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background.getImage(),0,0,800,600,this);


    }
}