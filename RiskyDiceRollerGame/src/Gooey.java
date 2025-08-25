
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Gooey {
    JFrame frame = new JFrame();
    JPanel map = new JPanel();
    JPanel rightSection = new JPanel(new BorderLayout());
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
    	map.setBackground(Color.red);
    	map.setPreferredSize(new Dimension(1200, 800));
    	frame.add(map,BorderLayout.CENTER);
    }

    /*
     * Creates right panel
     */
    public void initDiceZone() {
    	rightSection.setBackground(Color.blue);
    	rightSection.setPreferredSize(new Dimension(200,0));
    	diceZone.setBackground(Color.green);
    	diceZone.setPreferredSize(new Dimension(200, 100));
    	JPanel tSection = new JPanel(new BorderLayout());
    	JLabel dice = new JLabel("Dice");
        Font myFont = new Font("Arial", Font.PLAIN, 20); 
        dice.setFont(myFont);
    	tSection.add(dice,BorderLayout.CENTER);
    	dice.setHorizontalAlignment(SwingConstants.CENTER);
    	dice.setVerticalAlignment(SwingConstants.CENTER);
    	tSection.setBackground(Color.blue);
    	tSection.setPreferredSize(new Dimension(200, 150));
    	JPanel bSection = new JPanel();
    	bSection.setBackground(Color.blue);
    	bSection.setPreferredSize(new Dimension(200, 100));
    	JScrollPane diceScroll = new JScrollPane(diceZone,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	
    	rightSection.add(tSection,BorderLayout.NORTH);
    	rightSection.add(diceScroll, BorderLayout.CENTER);
    	rightSection.add(bSection,BorderLayout.SOUTH);
    	frame.add(rightSection,BorderLayout.EAST);
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
    
    
    //test
    
}
