/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 *
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

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
    private static final int PADDLE_Y_OFFSET = 30;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Number of turns */
    private static final int NTURNS = 3;


    /* Method: run() */
    /** Runs the Breakout program. */
    public void run() {
        /* Initializing */
        Brick.setWidth(BRICK_WIDTH);
        Brick.setHeight(BRICK_HEIGHT);

        double vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) vx = -vx;
        double vy = rgen.nextDouble(1.0, 3.0);
        Ball ball = new Ball(200, 300, BALL_RADIUS, vx, vy, Color.RED);
        ball.drawBall();
        add(ball.b);

        GRectangle sq = new GRectangle(200, 300, 11, 10);
        System.out.println(ball.getCollisionElement(sq));

        Paddle paddle = new Paddle((WIDTH-PADDLE_WIDTH)/2, HEIGHT-PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLUE);

        int x = 0;
        int y = 0;
        Color color;
        for (int j = 0; j < NBRICK_ROWS; j++) {
            color = rgen.nextColor();
            for (int i = 0; i < NBRICKS_PER_ROW; i++) {
                Brick kirpich = new Brick(x + (BRICK_WIDTH + BRICK_SEP) * i, y + (Brick.getBrickHeight() + BRICK_SEP) * j, Brick.getBrickWidth(), Brick.getBrickHeight(), color, false);
                add(kirpich.createBrick(kirpich.x, kirpich.y, Brick.getBrickWidth(), Brick.getBrickHeight(), kirpich.getColor()));
            }
        }
        add(paddle.paddle);
    }

}