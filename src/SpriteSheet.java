import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    public static BufferedImage spriteSheet;

    public static BufferedImage player_front[];
    public static BufferedImage tileWall;

    public SpriteSheet(){
        try {
            spriteSheet = ImageIO.read(getClass().getResource("resources/spritesheet.png"));
            player_front = new BufferedImage[2];
            player_front[0] = getSpriteSheet(0,11,16,16);
            player_front[1] = getSpriteSheet(16,11,16,16);
            tileWall = getSpriteSheet(280,221,16,16);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage getSpriteSheet(int x, int y, int width, int height) {
        return spriteSheet.getSubimage(x,y,width,height);
    }
}
