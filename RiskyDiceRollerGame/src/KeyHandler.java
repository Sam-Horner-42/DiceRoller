
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* Provides functionality for handling user keyboard interaction */
public class KeyHandler implements KeyListener{
    public boolean spacePressed;
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_SPACE) {
            spacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }
    }

    

}