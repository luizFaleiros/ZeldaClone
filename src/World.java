import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static List<Block> blocks = new ArrayList<Block>();

    public World() {
        for (int i = 0; i <20; i++){
            blocks.add(new Block(i*32,0));
        }
        for (int i = 0; i <20; i++){
            blocks.add(new Block(i*32,480-32));
        }
        for (int j = 0; j <20; j++){
            blocks.add(new Block(0,j*32));
        }
        for (int j = 0; j <20; j++){
            blocks.add(new Block(640-32,j*32));
        }

    }

    public static boolean isFree(int x, int y){
        for (Block block :
                blocks) {
            if(block.intersects(new Rectangle(x,y,32,32))){
                return false;
            }
        }
        return true;
    }

    public void render(Graphics g) {
        for (Block block :
                blocks) {
            block.render(g);
        }
    }
}
