import acm.graphics.GRect;
import acm.graphics.GRectangle;

import java.awt.*;

public class Paddle{
    public double x, y;
    public int width, height;
    public Color color;
    public int velocity;
    public GRect paddle;
    public GRectangle sq;

    public Paddle(double x, double y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.paddle = new GRect(x, y, width, height);
        this.paddle.setFilled(true);
        this.paddle.setFillColor(Color.DARK_GRAY);
        this.sq = new GRectangle(this.x, this.y, this.width, this.height);
    }
}
