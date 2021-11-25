import java.awt.*;

public class StoneBrick extends Brick {
    private static final boolean broken = false; //can't be broken
    public static final Color color = new Color(150, 75, 0); //brown
    public StoneBrick(int x, int y) {
        super(x, y, Brick.getBrickWidth(), Brick.getBrickHeight(), color, broken);
    }
}
