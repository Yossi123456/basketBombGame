import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HelpScreen extends JPanel {

    private JLabel play;
    private ImageIcon back;
    private JLabel instructions;

    private JPanel p = this;

    public HelpScreen(int x, int y, int width, int height) {
        setLayout(null);
        setBounds(x, y, width, height);

        back = new ImageIcon("qmBackground.jpg");
        instructions = new JLabel("<html>Instructions!!! " +
                " <br> You need to move the basket to catch the basketballs," +
                " <br> but carefully because there are also bombs that falls down. " +
                " <br> if you catch one you lose 1 live and if you go down to 0 lives" +
                " <br> you will lose the game, the difficulty will be increased as you catch more balls" +
                " <br> try to get 100 - 120 points but that will be hard " +
                "<br> good luck!!!</html>", SwingConstants.CENTER);
        instructions.setForeground(Color.WHITE);
        instructions.setVerticalAlignment(SwingConstants.CENTER);
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setFont(new Font("MV Boli", Font.PLAIN, 20));
        instructions.setBounds(100,100,600,300);
        this.add(instructions);
        //back = new ImageIcon("qmBackground.jpg");


        play = new JLabel();
        play.setBounds(300, 350, 150, 100);
        play.setText("play");
        play.setFont(new Font("MV Boli", Font.PLAIN, 70));
        play.setForeground(Color.CYAN);
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

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(back.getImage(),0,0,800,600,this);

    }
}