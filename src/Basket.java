import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Basket {
    private int x;
    private int y;
    private static final int WIDTH = 80;
    private static final int HEIGHT = 80;
    private JLabel basketLabel;

    public Basket(int x, int y) {
        this.x = x;
        this.y = y;
        basketLabel = new JLabel();
        basketLabel.setIcon(new ImageIcon("baskett.png"));
        basketLabel.setBounds(this.x,this.y,WIDTH,HEIGHT);
    }
    public JLabel getBasketLabel(){
        return basketLabel;
    }
    public void setBasketLabel(){
        this.basketLabel.setBounds(this.x,this.y,WIDTH,HEIGHT);
    }
    public Rectangle getBasketAsRectangle(){
        Rectangle rectangle = new Rectangle(
                this.x+30,
                this.y+30,
                WIDTH-60,
                HEIGHT-50
        );
        return rectangle;
    }
    public void moveRight(){
        if(this.x<710)
            this.x+=15;
    }
    public void moveLeft(){
        if(x>0)
            this.x-=15;
    }
}