import acm.graphics.GOval;
import acm.graphics.GRectangle;
import acm.util.RandomGenerator;

import java.awt.*;

public class Ball{
    public double x, y;
    public double radius;
    public double vx, vy;
    public Color color;
    public GOval b;

    RandomGenerator rgen = RandomGenerator.getInstance();

    public Ball(int x, int y, int radius, double vx, double vy, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vx = vx;
        this.vy = vy;
        this.color = color;
        this.b = new GOval(this.x, this.y, this.radius, this.radius);
        this.b.setFilled(true);
        this.b.setFillColor(Color.RED);
    }

    private void drawBall(){

    }
}
