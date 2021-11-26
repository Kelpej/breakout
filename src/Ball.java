import acm.graphics.GOval;
import acm.graphics.GRectangle;

import java.awt.*;

public class Ball{
    public double x, y;
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
    public void move(double vx, double vy){
        this.x = this.x + this.vx;
        this.y = this.y + this.vy;
    }
    public void checkBoardCollision(){
        if (this.x > Breakout.APPLICATION_WIDTH - this.radius || this.x < this.radius || this.y > Breakout.APPLICATION_HEIGHT - this.radius){
            this.vx = -this.vx;
        }
    }
    public void checkPaddleCollision(GRectangle paddle){
        if (this.b.getBounds().intersects(paddle)) {
            this.vx = -this.vx;
            this.vy = -this.vy;
        }
    }
    public void checkCeilingCollision(){
        if (this.y <= this.radius) {
            this.vx = -this.vx;
            this.vy = -this.vy;
        }
    }
    public GRectangle getCollisionElement(GRectangle i){
        if (this.b.getBounds().intersects(i)) {
            return i;
        }
        return null;
    }
}
