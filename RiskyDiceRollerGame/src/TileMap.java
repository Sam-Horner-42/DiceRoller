import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class TileMap extends JPanel implements Runnable {
    final int tileSize = 48;
    
    /* 16:9 aspect ratio */
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread; // runs the game

    public TileMap(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.blue);
        this.setDoubleBuffered(true); // useful for threads
    }

    /*
     * Starts the game, initializes the clock
     */
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        // while the game thread exists
        while(gameThread != null){
            
        }
    }
}
