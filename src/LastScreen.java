import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LastScreen extends JPanel {
    private JLabel play;
    private ImageIcon background;
    private JLabel end;
    private JPanel p = this;
    private JLabel score;


    public LastScreen(int x,int y, int width,int height){
        setLayout(null);
        setBounds(x, y, width, height);
        background = new ImageIcon("gameOver.jpg");

        score = new JLabel("Your score is: " + GameScreen.Ball.getScore());
        score.setBounds(300,20,200,50);
        score.setFont(new Font("MV Boli", Font.PLAIN, 20));
        score.setForeground(Color.CYAN);
        this.add(score);

        play = new JLabel();
        play.setBounds(250, 450, 200, 100);
        play.setText("play again");
        play.setFont(new Font("MV Boli", Font.PLAIN, 35));
        play.setForeground(Color.CYAN);
        play.setHorizontalTextPosition(JLabel.CENTER);
        this.add(play);
        play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                GameScreen.Ball.setStopGame(false);
                new Window(new GameScreen(0,0,800,600));

                Window window = (Window) SwingUtilities.getWindowAncestor(p);
                window.dispose();


            }
        });
        end = new JLabel();
        end.setBounds(500, 450, 100, 100);
        end.setText("quit");
        end.setFont(new Font("MV Boli", Font.PLAIN, 35));
        end.setForeground(Color.CYAN);
        end.setHorizontalTextPosition(JLabel.CENTER);
        this.add(end);
        end.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                System.exit(0);

            }
        });
    }
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background.getImage(),0,0,800,600,this);


    }
}
