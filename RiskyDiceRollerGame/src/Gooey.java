
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.*;

public class Gooey {
    JFrame frame = new JFrame();
    JPanel map = new JPanel();
    JPanel diceZone = new JPanel(new GridBagLayout());
    
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
    
    /*
     * Makes Game map
     */
    public void initMap() {
    	map.setBackground(Color.white);
    	map.setPreferredSize(new Dimension(1200, 800));
    	frame.add(map, BorderLayout.CENTER);

        TileMap tileMap = new TileMap(); // adds the tile map inside the main map, so graphics can be placed dynamically
        frame.add(tileMap);
    }

    /*
     * Creates right panel
     */
    public void initDiceZone() {
    	diceZone.setBackground(Color.black);
    	diceZone.setPreferredSize(new Dimension(300, 0));
    	frame.add(diceZone,BorderLayout.EAST);
    }
    
    /*
     * Creates the main window and components for view.
     */
    public void initializeMainFrame(){
        createMainFrame();
        initMap();
        initDiceZone();
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    
    
}
