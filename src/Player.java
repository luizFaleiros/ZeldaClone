import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle {

    public boolean right, up, down, left;
    public int spd = 4;

    public int curAnimation = 0;
    public int curFrames = 0, targetFrames = 15;

    public List<Bullet> bullets = new ArrayList<>();

    public Player(int x, int y) {
        super(x, y, 32, 32);
    }

    public void tick() {
        boolean moved = false;
        if (right && World.isFree(x + spd, y)) {
            moved = true;
            x += spd;
        } else if (left && World.isFree(x - spd, y)) {
            moved = true;
            x -= spd;
        }
        if (up && World.isFree(x, y - spd)) {
            moved = true;
            y -= spd;
        } else if (down && World.isFree(x, y + spd)) {
            moved = true;
            y += spd;
        }

        if (moved) {
            curFrames++;
            if (curFrames == targetFrames) {
                curFrames = 0;
                curAnimation++;
                if (curAnimation == SpriteSheet.player_front.length) {
                    curAnimation = 0;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.drawImage(SpriteSheet.player_front[curAnimation],x,y,32,32,null);
    }
}
