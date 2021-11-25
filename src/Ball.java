import acm.graphics.GOval;
import acm.graphics.GRectangle;

import java.awt.*;

public class Ball extends Breakout{
    public double x;
    public double y;
    public double radius;
    public double vx, vy;
    public Color color;
    public GOval b;

    public Ball(int x, int y, int radius, double vx, double vy, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vx = vx;
        this.vy = vy;
        this.color = color;
    }
    public void drawBall(){
        GOval b = new GOval(this.x, this.y, this.radius, this.radius);
        b.setFilled(true);
        b.setFillColor(this.color);
        this.b = b;
    }
    public GRectangle getCollisionElement(GRectangle i){
        if (this.b.getBounds().intersects(i)) {
            return i;
        }
        return null;
    }
}
