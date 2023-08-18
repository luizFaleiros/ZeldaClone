import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable, KeyListener {

    public static int WIDTH = 640, HEIGHT = 480;
    public static int SCALE = 3;
    public Player player;

    public World world;

    public Game() {
        new SpriteSheet();
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        player = new Player(32,32);
        world = new World();
    }

    public void tick(){
        player.tick();
    }
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH*SCALE,HEIGHT*SCALE);
        player.render(g);
        world.render(g);
        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();

        frame.add(game);
        frame.setTitle("Mini zelda");

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        game.requestFocus();
        new Thread(game).start();

    }

    @Override
    public void run() {
        while (true){
            try {
                tick();
                render();
                Thread.sleep(1000/60);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            player.right = true;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            player.left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            player.up = true;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            player.down = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            System.out.println("Direita solta");
            player.right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            player.left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            player.up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            player.down = false;
        }

    }
}