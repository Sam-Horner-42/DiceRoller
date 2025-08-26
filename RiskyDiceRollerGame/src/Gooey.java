
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Gooey {
    JFrame frame = new JFrame();
    JPanel map = new JPanel();
    JPanel rightSection = new JPanel(new BorderLayout());
    JPanel diceZone = new JPanel(new GridLayout());
    JPanel bSection = new JPanel();
    JLabel bottomText = new JLabel("example text");
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
    	// overarching panel containing our 3 components
    	rightSection.setBackground(Color.blue);
    	rightSection.setPreferredSize(new Dimension(200,0));
    	
    	//diceZone is where the dice will be displayed in the right panel, we can add things to it as it is not a local variable
    	diceZone.setBackground(Color.green);
    	diceZone.setPreferredSize(new Dimension(200, 100));
    	
    	//tsection, short for top section, just has the word dice on it
    	JPanel tSection = new JPanel(new BorderLayout());
    	JLabel dice = new JLabel("Dice");
        Font myFont = new Font("Arial", Font.PLAIN, 20); 
        dice.setFont(myFont);
    	tSection.add(dice,BorderLayout.CENTER);
    	dice.setHorizontalAlignment(SwingConstants.CENTER);
    	dice.setVerticalAlignment(SwingConstants.CENTER);
    	tSection.setBackground(Color.blue);
    	tSection.setPreferredSize(new Dimension(200, 150));
    	
    	// bsection, bottom section, since we need to add info to this, it can't be local
    	bSection.setBackground(Color.blue);
    	bSection.setPreferredSize(new Dimension(200, 100));
    	 bottomText.setFont(myFont);
     	bSection.add(bottomText,BorderLayout.CENTER);
     	bottomText.setHorizontalAlignment(SwingConstants.CENTER);
     	bottomText.setVerticalAlignment(SwingConstants.CENTER);
    	// scrollpane just makes it so that we can scroll down to see all our dice, we placed dicezone in it
    	JScrollPane diceScroll = new JScrollPane(diceZone,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	
    	// we add everythin to the overarching right panel, then add it to the frame
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
    
    
    //test pls
    
    
}
