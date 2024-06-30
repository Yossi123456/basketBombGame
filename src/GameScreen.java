import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {
    private ArrayList<Ball> balls;
    private Basket basket;
    private JPanel p = this;
    private JLabel scoreLabel;
    private JLabel liveLabel;
    private ImageIcon background;
    private static int k = 90;

    public GameScreen(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);

        Ball.score = 0;
        Ball.live = 3;
        for (int i = 0; i < Ball.rndImg.length; i++) {
            Ball.rndImg[i] = Ball.COIN;
        }

        basket = new Basket(360, 485);
        background = new ImageIcon("back.png");
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new Controller(basket, this));


        scoreLabel = new JLabel("score: 0");
        liveLabel = new JLabel("live: 3");

        scoreLabel.setForeground(Color.BLACK);
        liveLabel.setForeground(Color.BLACK);

        scoreLabel.setBounds(300, 0, 100, 50);
        liveLabel.setBounds(400, 0, 100, 50);

        scoreLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        liveLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        this.add(scoreLabel);
        this.add(liveLabel);
        this.add(basket.getBasketLabel());


        balls = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Ball ball = new Ball();
            this.add(ball.getBallLabel());
            balls.add(ball);
            Thread thread = new Thread(ball);
            thread.start();
        }
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background.getImage(),0,0,800,600,this);
        if(Ball.getScore() > k){
            Ball ball = new Ball();
            this.add(ball.getBallLabel());
            balls.add(ball);
            Thread thread = new Thread(ball);
            thread.start();
            k++;
        }
        for(Ball ball: balls){
            ball.setBallLabel();
        }
        basket.setBasketLabel();

    }

    public class Ball implements Runnable{
        private static int score = 0;
        private static int live = 3;
        private static final int SIZE = 30;
        private int x;
        private int y;
        private int speed;
        private static boolean stopGame = false;
        private static final ImageIcon BOMB = new ImageIcon("bom.png");
        private static final ImageIcon COIN = new ImageIcon("basketball1.png");
        private JLabel ballLabel;

        private static ImageIcon [] rndImg = new ImageIcon[10];
        public Ball(){
            this.x = new Random().nextInt(760);
            this.y = -30;
            this.speed = new Random().nextInt(3)+5;

            ballLabel = new JLabel();
            ballLabel.setIcon(rndImg[new Random().nextInt(10)]);
            ballLabel.setBounds(this.x,this.y,SIZE,SIZE);
        }
        public JLabel getBallLabel(){
            return ballLabel;
        }
        public void setBallLabel(){
            this.ballLabel.setBounds(this.x,this.y,SIZE,SIZE);
        }
        @Override
        public void run() {
            while(!stopGame){
                y+=speed;
                if(collision(this.getBallAsRectangle(), basket.getBasketAsRectangle())){
                    if(ballLabel.getIcon() == BOMB){
                        live--;
                        liveLabel.setText("live: "+ live);
                        if(live == 0){
                            new Window(new LastScreen(0,0,800,600));
                            Window window = (Window) SwingUtilities.getWindowAncestor(p);
                            window.dispose();
                            stopGame = true;
                        }
                    }
                    else {
                        score++;
                        scoreLabel.setText("score: "+ score);
                        if(score/10<9)
                            rndImg[score/10] = BOMB;
                    }
                    this.y = -30;
                    this.x = new Random().nextInt(760);
                    this.speed = new Random().nextInt(3)+5;
                    ballLabel.setIcon(rndImg[new Random().nextInt(10)]);
                }
                else if(y > 600){
                    this.y = -30;
                    this.x = new Random().nextInt(760);
                    this.speed = new Random().nextInt(3)+3;
                    ballLabel.setIcon(rndImg[new Random().nextInt(10)]);

                }
                repaint();
                try{
                    Thread.sleep(20);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        public boolean collision (Rectangle rect1,Rectangle rect2)
        {
            return rect1.intersects(rect2);
        }
        public Rectangle getBallAsRectangle(){
            Rectangle rectangle = new Rectangle(
                    this.x,
                    this.y,
                    SIZE,
                    SIZE
            );
            return rectangle;
        }

        public static void setStopGame(boolean stopGame) {
            Ball.stopGame = stopGame;
        }

        public static int getScore() {
            return score;
        }
    }

}