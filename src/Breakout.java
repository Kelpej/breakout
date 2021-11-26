/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 *
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Breakout extends GraphicsProgram {
    private RandomGenerator rgen = RandomGenerator.getInstance();

    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_OFFSET = 30;

    /** Number of bricks per row */
    private static final int BRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int BRICK_ROWS = 10;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
            (WIDTH - (BRICKS_PER_ROW - 1) * BRICK_SEP) / BRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_OFFSET = 70;

    Paddle paddle = new Paddle((WIDTH-PADDLE_WIDTH)/2, HEIGHT-PADDLE_HEIGHT- PADDLE_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT, Color.DARK_GRAY);

    public void mouseMoved(MouseEvent e) {
        if ((e.getX() < WIDTH - PADDLE_WIDTH/2) && (e.getX() > PADDLE_WIDTH/2)) {
            paddle.x = e.getX()-PADDLE_WIDTH/2;
        }
    }
    private void drawPaddle(){
        paddle.paddle.setVisible(false);
        paddle.paddle = new GRect(paddle.x, paddle.y, paddle.width, paddle.height);
        paddle.sq = new GRectangle(paddle.x, paddle.y, paddle.width, paddle.height);
        paddle.paddle.setFilled(true);
        paddle.paddle.setFillColor(paddle.color);
        add(paddle.paddle);
        addMouseListeners();
    }

    Ball ball = new Ball(200, 300, BALL_RADIUS, 0, 4, Color.RED);

    private void drawBall(){
        GOval b = new GOval(ball.x, ball.y, ball.radius, ball.radius);
        b.setFilled(true);
        b.setFillColor(ball.color);
        ball.b = b;
        ball.sq = new GRectangle(ball.x, ball.y, ball.radius, ball.radius);
        add(ball.b);
    }

    private void drawBricks(){
        Color color;
        for (int j = 0; j < BRICK_ROWS; j++) {
            color = rgen.nextColor();
            for (int i = 0; i < BRICKS_PER_ROW; i++) {
                Brick brick = new Brick((BRICK_WIDTH + BRICK_SEP) * i, BRICK_OFFSET + (Brick.getBrickHeight() + BRICK_SEP) * j, Brick.getBrickWidth(), Brick.getBrickHeight(), color, false);
                add(brick.createBrick(brick.x, brick.y, Brick.getBrickWidth(), Brick.getBrickHeight(), brick.getColor()));
            }
        }
    }
    public void init(){
        Brick.setWidth(BRICK_WIDTH);
        Brick.setHeight(BRICK_HEIGHT);
        drawBricks();
    }
    /* Method: run() */
    /** Runs the Breakout program. */

    public void run() {
        /* Initializing */

        //create bricks
        add(paddle.paddle);
        while(true){
            drawPaddle();
            drawBall();
            ball.checkPaddleCollision(paddle.sq);
            ball.checkBoardCollision();
            ball.checkCeilingCollision();
            ball.move(ball.vx, ball.vy);
            if (ball.y >= HEIGHT-paddle.height) break;
            pause(10);
            ball.b.setVisible(false);
        }
    }

}