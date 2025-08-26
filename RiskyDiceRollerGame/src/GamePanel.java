import java.awt.Color;
import java.awt.Dimension;
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
        this.setBackground(Color.blue);
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

        }
    }

    /* Built in class that runs every frame */
    public void update() {

    }

    /* Used to draw things on the screen */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
