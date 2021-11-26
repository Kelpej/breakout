import acm.graphics.GRect;
import acm.graphics.GRectangle;

import java.awt.*;

public class Brick{
    private static int width, height;
    int x, y;
    Color color;
    boolean broken;
    GRectangle rect;

    public Brick(int x, int y, int width, int height, Color color, boolean broken) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.broken = broken;
        this.rect = new GRectangle(x, y, width, height);
    }

    public GRect createBrick(int x, int y, int width, int height, Color color){
        GRect rect = new GRect(x, y, width, height);
        rect.setFilled(true);
        rect.setFillColor(color);
        return rect;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return this.y;
    }
    public static int getBrickWidth(){
        return width;
    }
    public static void setWidth(int w){
        width = w;
    }
    public static int getBrickHeight(){
        return height;
    }
    public static void setHeight(int h){
        height = h;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;
    }
}

