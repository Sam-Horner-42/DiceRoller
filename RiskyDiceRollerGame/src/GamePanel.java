
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    final int tileSize = 48;
    
    /* 16:9 aspect ratio */
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread; // runs the game

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true); // useful for threads
    }

    /*
     * Starts the game, initializes the clock
     */
    public void startGameThread() {

        gameThread = new Thread(this); // starts the game thread
        gameThread.start(); // invokes run
    }

    /* Automatically called when the thread is created */
    @Override
    public void run(){
        // while the game thread exists
        while(gameThread != null){
            update(); // update information each frame
            repaint(); // redraw the screen with new information
        }
    }

    /* Built in class that runs every frame */
    public void update() {
        
    }

    /* Used to draw things on the screen */
    public void paintComponent(Graphics g){
        super.paintComponent(g); // makes the method work, Java handles the functionality (IDK tbh)
        
        Graphics2D g2 = (Graphics2D)g; // involves methods that are useful for games

        g2.setColor(Color.white);
        g2.fillRect(100, 100, tileSize, tileSize); // draws a rectangle on the screen the height and width of a tile

    }
}
