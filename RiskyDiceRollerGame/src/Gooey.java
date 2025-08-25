
import java.awt.BorderLayout;
import javax.swing.*;

public class Gooey {
    JFrame frame = new JFrame();

    JPanel panel = new JPanel();
    /**
        Method name: createMainFrame
        Purpose: Initializes and configures the main game frame.
        Algorithm:
        Instantiate a new JFrame with the title "Crazy Eights".
        Set the default close operation.
        Disable frame resizing.
        Set the layout manager to BorderLayout.
    */
    public void createMainFrame() {
        frame = new JFrame("Cookie Conquest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
    }

    public void initializeMainFrame(){
        createMainFrame();
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    
    
}
