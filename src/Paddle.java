import acm.graphics.GRect;

import java.awt.*;

public class Paddle{
    public double x, y;
    public int width, height;
    public Color color;
    public int velocity;
    public GRect p;

    public Paddle(double x, double y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.p = new GRect(x, y, width, height);
        this.p.setFilled(true);
        this.p.setFillColor(Color.DARK_GRAY);
    }
}
