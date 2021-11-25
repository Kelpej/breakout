import acm.graphics.GRect;
import acm.graphics.GRectangle;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Breakout{
    double x, y;
    private int width, height;
    private Color color;
    private int velocity;
    public GRect paddle;
    public GRectangle sq;

    /*public class GameKeyListener extends KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }*/

    public Paddle(double x, double y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.paddle = new GRect(x, y, width, height);
        this.paddle.setFilled(true);
        this.paddle.setFillColor(Color.DARK_GRAY);
        /*GameKeyListener listener = new GameKeyListener();
        this.paddle.addMouseMotionListener(listener);*/
    }

}
