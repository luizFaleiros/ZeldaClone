import java.awt.*;

public class Block extends Rectangle {
    public Block(int x, int y) {
        super(x, y, 32, 32);
    }

    public void render(Graphics g) {
        g.drawImage(SpriteSheet.tileWall, x, y, 32, 32, null);
    }
}
