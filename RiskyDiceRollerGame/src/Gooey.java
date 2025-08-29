
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Gooey extends JPanel {

	String levelName;
	int levelMinRange;
	int levelMaxRange = 0; // Will always start at 0 because the player has not selected dice
	int currentMinRange = 0; // Same as above
	int currentMaxRange = 0;

	JFrame frame = new JFrame();
	ImageIcon bgIcon = new ImageIcon(getClass().getResource("/assets/mapBackground.png"));
	ImagePanel map = new ImagePanel(bgIcon, new GridBagLayout());
	JPanel mainArea = new JPanel(new CardLayout());
	JPanel levelView = new JPanel(new GridBagLayout());
	JLabel cityName = new JLabel("PlaceHolder");
	JLabel tMinRange = new JLabel("PlaceHolder");
	JLabel tMaxRange = new JLabel("PlaceHolder");
	JLabel cMinRange = new JLabel("PlaceHolder");
	JLabel cMaxRange = new JLabel("PlaceHolder");

	JPanel selectedDiceHolder = new JPanel(new GridLayout(0, 5));
	JPanel selectedItemHolder = new JPanel(new GridLayout(1, 3));

	JLabel itemSlot1 = new JLabel("PlaceHolder");
	JLabel itemSlot2 = new JLabel("PlaceHolder");
	JLabel itemSlot3 = new JLabel("PlaceHolder");
	JTextPane messageBoard = new JTextPane();
	JPanel diceZone = new JPanel(new GridLayout(0,2));
	JPanel itemZone = new JPanel(new GridLayout());
	Window popup = new JWindow(frame);
	JLabel popupLabel =new JLabel();
	
	ArrayList<JLabel> levelLabels = new ArrayList<>();
	boolean labelListFilled = false;
	boolean mapOnScreen = true;
	Controller controller;
	Model model;
	// chocolate chip islands
	JLabel chocoChip1 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip2 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip3 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip4 = new JLabel(loadImage("chocoChip"));
	
	// macaron islands
	JLabel macaron1 = new JLabel(loadImage("macaron"));
	JLabel macaron2 = new JLabel(loadImage("macaron"));
	JLabel macaron3 = new JLabel(loadImage("macaron"));

	// fudge islands
	JLabel fudge1 = new JLabel(loadImage("fudge"));
	JLabel fudge2 = new JLabel(loadImage("fudge"));
	JLabel fudge3 = new JLabel(loadImage("fudge"));

	// peanut-cookie islands
	JLabel peanut_cookie1 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie2 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie3 = new JLabel(loadImage("peanut_cookie"));


	// red-eyes filled islands
	JLabel red_jelly1 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly2 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly3 = new JLabel(loadImage("red_jelly"));
	
	static final Color DARK_BROWN = new Color(176, 137, 112);
	

	/**
	 * Predefined green color for UI elements.
	 */
	static final Color BEIGE = new Color(235, 213, 161);

	/**
	 * Predefined beige color for UI elements.
	 */
	static final Color LIGHT_BROWN = new Color(230, 190, 150);
	
	static final Color PURPLE = new Color(153, 77, 115);



	/**
	 * Method name: createMainFrame Purpose: Initializes and configures the main
	 * game frame. Algorithm: Instantiate a new JFrame with the title "Crazy
	 * Eights". Set the default close operation. Disable frame resizing. Set the
	 * layout manager to BorderLayout.
	 */
	public void createMainFrame() {
		frame = new JFrame("Cookie Conquest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
	}
	
	public void createPopup() {
	    popup.setLayout(new BorderLayout());
	    popup.setSize(250, 75);	
		popup.add(popupLabel, BorderLayout.CENTER);
		popup.setVisible(false);
	}
	
	public void usePopup(String text) {
		popupLabel.setText(text);
	}
	
	public void useMessageBoard(String text) {
		Font myFont = new Font("Arial", Font.PLAIN, 20);
		messageBoard.setText("");
		messageBoard.setFont(myFont);
		messageBoard.setText(text);

	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setModel(Model model){
		this.model = model;
	}

	public void initMenu(){
		
	}

	/*
	 * Makes Game map
	 */
	public void initMap() {
		map.setBackground(Color.white);
		map.setPreferredSize(new Dimension(900, 900));
		GridBagConstraints outer = new GridBagConstraints();
		GridBagConstraints inner = new GridBagConstraints();
		Dimension small_panel = new Dimension(100, 100);

		
		// North West Section 
		JPanel northWestSection = new JPanel(new GridBagLayout());
		northWestSection.setPreferredSize(new Dimension(300, 300));
		northWestSection.setOpaque(false);

		// North West Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel nw00 = new JPanel();
		nw00.setPreferredSize(small_panel);
		nw00.setOpaque(false);
		northWestSection.add(nw00, inner);

		// North West Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel nw10 = new JPanel();
		nw10.setPreferredSize(small_panel);
		nw10.setOpaque(false);
		northWestSection.add(nw10, inner);

		// North West Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel nw20 = new JPanel();
		nw20.setPreferredSize(small_panel);
		nw20.setOpaque(false);
		northWestSection.add(nw20, inner);

		// North West Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel nw01 = new JPanel();
		nw01.setPreferredSize(small_panel);
		nw01.setOpaque(false);
		northWestSection.add(nw01, inner);

		// North West Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel nw11 = new JPanel();
		nw11.setPreferredSize(small_panel);
		nw11.setOpaque(false);
		northWestSection.add(nw11, inner);

		// North West Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel nw21 = new JPanel();
		nw21.setPreferredSize(small_panel);
		nw21.setOpaque(false);
		nw21.add(peanut_cookie3);
		peanut_cookie3.addMouseListener(new LevelMouseListener(this, controller, model, peanut_cookie3));
		northWestSection.add(nw21, inner);

		// North West Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel nw02 = new JPanel();
		nw02.setPreferredSize(small_panel);
		nw02.setOpaque(false);
		northWestSection.add(nw02, inner);

		// North West Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel nw12 = new JPanel();
		nw12.setPreferredSize(small_panel);
		nw12.setOpaque(false);
		northWestSection.add(nw12, inner);

		// North West Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel nw22 = new JPanel();
		nw22.setPreferredSize(small_panel);
		nw22.setOpaque(false);
		northWestSection.add(nw22, inner);

		outer.gridx = 0;
		outer.gridy = 0;
		map.add(northWestSection, outer);

		// North Section
		JPanel northSection = new JPanel(new GridBagLayout());
		northSection.setPreferredSize(new Dimension(300, 300));
		northSection.setOpaque(false);

		// North Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel n00 = new JPanel();
		n00.setPreferredSize(small_panel);
		n00.setOpaque(false);
		northSection.add(n00, inner);

		// North Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel n10 = new JPanel();
		n10.setPreferredSize(small_panel);
		n10.setOpaque(false);
		northSection.add(n10, inner);

		// North Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel n20 = new JPanel();
		n20.setPreferredSize(small_panel);
		n20.setOpaque(false);
		northSection.add(n20, inner);

		// North Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel n01 = new JPanel();
		n01.setPreferredSize(small_panel);
		n01.setOpaque(false);
		northSection.add(n01, inner);

		// North Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel n11 = new JPanel();
		n11.setPreferredSize(small_panel);
		n11.setOpaque(false);
		northSection.add(n11, inner);

		// North Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel n21 = new JPanel();
		n21.setPreferredSize(small_panel);
		n21.setOpaque(false);
		northSection.add(n21, inner);

		// North Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel n02 = new JPanel();
		n02.setPreferredSize(small_panel);
		n02.setOpaque(false);
		northSection.add(n02, inner);

		// North Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel n12 = new JPanel();
		n12.setPreferredSize(small_panel);
		n12.setOpaque(false);
		northSection.add(n12, inner);

		// North Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel n22 = new JPanel();
		n22.setPreferredSize(small_panel);
		n22.setOpaque(false);
		northSection.add(n22, inner);

		outer.gridx = 1;
		outer.gridy = 0;
		map.add(northSection, outer);

		// North East Section
		JPanel northEastSection = new JPanel(new GridBagLayout());
		northEastSection.setPreferredSize(new Dimension(300, 300));
		northEastSection.setOpaque(false);

		// North East Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel nE00 = new JPanel();
		nE00.setPreferredSize(small_panel);
		nE00.setOpaque(false);
		northEastSection.add(nE00, inner);

		// North East Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel nE10 = new JPanel();
		nE10.setPreferredSize(small_panel);
		nE10.setOpaque(false);
		northEastSection.add(nE10, inner);

		// North East Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel nE20 = new JPanel();
		nE20.setPreferredSize(small_panel);
		nE20.setOpaque(false);
		northEastSection.add(nE20, inner);

		// North East Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel nE01 = new JPanel();
		nE01.setPreferredSize(small_panel);
		nE01.setOpaque(false);
		northEastSection.add(nE01, inner);

		// North East Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel nE11 = new JPanel();
		nE11.setPreferredSize(small_panel);
		nE11.setOpaque(false);
		nE11.add(red_jelly3);
		red_jelly3.addMouseListener(new LevelMouseListener(this, controller, model, red_jelly3));
		northEastSection.add(nE11, inner);

		// North East Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel nE21 = new JPanel();
		nE21.setPreferredSize(small_panel);
		nE21.setOpaque(false);
		northEastSection.add(nE21, inner);

		// North East Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel nE02 = new JPanel();
		nE02.setPreferredSize(small_panel);
		nE02.setOpaque(false);
		northEastSection.add(nE02, inner);

		// North East Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel nE12 = new JPanel();
		nE12.setPreferredSize(small_panel);
		nE12.setOpaque(false);
		nE12.add(red_jelly2);
		red_jelly2.addMouseListener(new LevelMouseListener(this, controller, model, red_jelly2));
		northEastSection.add(nE12, inner);

		// North East Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel nE22 = new JPanel();
		nE22.setPreferredSize(small_panel);
		nE22.setOpaque(false);
		northEastSection.add(nE22, inner);

		outer.gridx = 2;
		outer.gridy = 0;
		map.add(northEastSection, outer);

		// West Section
		JPanel westSection = new JPanel(new GridBagLayout());
		westSection.setPreferredSize(new Dimension(300, 300));
		westSection.setOpaque(false);
		
		// West Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel W00 = new JPanel();
		W00.setPreferredSize(small_panel);
		W00.setOpaque(false);
		westSection.add(W00, inner);

		// West Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel W10 = new JPanel();
		W10.setPreferredSize(small_panel);
		W10.setOpaque(false);
		westSection.add(W10, inner);

		// West Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel W20 = new JPanel();
		W20.setPreferredSize(small_panel);
		W20.setOpaque(false);
		W20.add(peanut_cookie2);
		peanut_cookie2.addMouseListener(new LevelMouseListener(this, controller, model, peanut_cookie2));
		westSection.add(W20, inner);

		// West Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel W01 = new JPanel();
		W01.setPreferredSize(small_panel);
		W01.setOpaque(false);
		westSection.add(W01, inner);

		// West Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel W11 = new JPanel();
		W11.setPreferredSize(small_panel);
		W11.setOpaque(false);
		W11.add(peanut_cookie1);
		peanut_cookie1.addMouseListener(new LevelMouseListener(this, controller, model, peanut_cookie1));
		westSection.add(W11, inner);

		// West Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel W21 = new JPanel();
		W21.setPreferredSize(small_panel);
		W21.setOpaque(false);
		westSection.add(W21, inner);

		// West Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel W02 = new JPanel();
		W02.setPreferredSize(small_panel);
		W02.setOpaque(false);
		westSection.add(W02, inner);

		// West Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel W12 = new JPanel();
		W12.setPreferredSize(small_panel);
		W12.setOpaque(false);
		westSection.add(W12, inner);

		// West Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel W22 = new JPanel();
		W22.setPreferredSize(small_panel);
		W22.setOpaque(false);
		westSection.add(W22, inner);
		
		outer.gridx = 0;
		outer.gridy = 1;
		map.add(westSection, outer);

		// Center Section
		JPanel centerSection = new JPanel(new GridBagLayout());
		centerSection.setPreferredSize(new Dimension(300, 300));
		centerSection.setOpaque(false);

		// Center Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel C00 = new JPanel();
		C00.setPreferredSize(small_panel);
		C00.setOpaque(false);
		centerSection.add(C00, inner);

		// Center Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel C10 = new JPanel();
		C10.setPreferredSize(small_panel);
		C10.setOpaque(false);
		C10.add(red_jelly1);
		red_jelly1.addMouseListener(new LevelMouseListener(this, controller, model, red_jelly1));
		centerSection.add(C10, inner);

		// Center Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel C20 = new JPanel();
		C20.setPreferredSize(small_panel);
		C20.setOpaque(false);
		C20.add(macaron3);
		macaron3.addMouseListener(new LevelMouseListener(this, controller, model, macaron3));
		centerSection.add(C20, inner);

		// Center Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel C01 = new JPanel();
		C01.setPreferredSize(small_panel);
		C01.setOpaque(false);
		centerSection.add(C01, inner);

		// Center Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel C11 = new JPanel();
		C11.setPreferredSize(small_panel);
		C11.setOpaque(false);
		centerSection.add(C11, inner);

		// Center Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel C21 = new JPanel();
		C21.setPreferredSize(small_panel);
		C21.setOpaque(false);
		centerSection.add(C21, inner);

		// Center Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel C02 = new JPanel();
		C02.setPreferredSize(small_panel);
		C02.setOpaque(false);
		centerSection.add(C02, inner);

		// Center Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel C12 = new JPanel();
		C12.setPreferredSize(small_panel);
		C12.setOpaque(false);
		centerSection.add(C12, inner);

		// Center Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel C22 = new JPanel();
		C22.setPreferredSize(small_panel);
		C22.setOpaque(false);
		centerSection.add(C22, inner);

		outer.gridx = 1;
		outer.gridy = 1;
		map.add(centerSection, outer);

		// East Section
		JPanel eastSection = new JPanel(new GridBagLayout());
		eastSection.setPreferredSize(new Dimension(300, 300));
		eastSection.setOpaque(false);

		// East Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel E00 = new JPanel();
		E00.setPreferredSize(small_panel);
		E00.setOpaque(false);
		eastSection.add(E00, inner);

		// East Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel E10 = new JPanel();
		E10.setPreferredSize(small_panel);
		E10.setOpaque(false);
		eastSection.add(E10, inner);

		// East Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel E20 = new JPanel();
		E20.setPreferredSize(small_panel);
		E20.setOpaque(false);
		eastSection.add(E20, inner);

		// East Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel E01 = new JPanel();
		E01.setPreferredSize(small_panel);
		E01.setOpaque(false);
		eastSection.add(E01, inner);

		// East Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel E11 = new JPanel();
		E11.setPreferredSize(small_panel);
		E11.setOpaque(false);
		eastSection.add(E11, inner);

		// East Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel E21 = new JPanel();
		E21.setPreferredSize(small_panel);
		E21.setOpaque(false);
		eastSection.add(E21, inner);

		// East Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel E02 = new JPanel();
		E02.setPreferredSize(small_panel);
		E02.setOpaque(false);
		E02.add(fudge3);
		fudge3.addMouseListener(new LevelMouseListener(this, controller, model, fudge3));
		eastSection.add(E02, inner);

		// East Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel E12 = new JPanel();
		E12.setPreferredSize(small_panel);
		E12.setOpaque(false);
		eastSection.add(E12, inner);

		// East Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel E22 = new JPanel();
		E22.setPreferredSize(small_panel);
		E22.setOpaque(false);
		eastSection.add(E22, inner);

		outer.gridx = 2;
		outer.gridy = 1;
		map.add(eastSection, outer);

		// South West Section
		JPanel southWestSection = new JPanel(new GridBagLayout());
		southWestSection.setPreferredSize(new Dimension(300, 300));
		southWestSection.setOpaque(false);

		// South West Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel SW00 = new JPanel();
		SW00.setPreferredSize(small_panel);
		SW00.setOpaque(false);
		southWestSection.add(SW00, inner);

		// South West Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel SW10 = new JPanel();
		SW10.setPreferredSize(small_panel);
		SW10.setOpaque(false);
		SW10.add(chocoChip2);
		chocoChip2.addMouseListener(new LevelMouseListener(this, controller, model, chocoChip2));
		southWestSection.add(SW10, inner);

		// South West Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel SW20 = new JPanel();
		SW20.setPreferredSize(small_panel);
		SW20.setOpaque(false);
		southWestSection.add(SW20, inner);

		// South West Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel SW01 = new JPanel();
		SW01.setPreferredSize(small_panel);
		SW01.setOpaque(false);
		southWestSection.add(SW01, inner);

		// South West Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel SW11 = new JPanel();
		SW11.setPreferredSize(small_panel);
		SW11.setOpaque(false);
		southWestSection.add(SW11, inner);

		// South West Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel SW21 = new JPanel();
		SW21.setPreferredSize(small_panel);
		SW21.setOpaque(false);
		SW21.add(chocoChip3);
		chocoChip3.addMouseListener(new LevelMouseListener(this, controller, model, chocoChip3));
		southWestSection.add(SW21, inner);

		// South West Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel SW02 = new JPanel();
		SW02.setPreferredSize(small_panel);
		SW02.setOpaque(false);
		SW02.add(chocoChip1);
		chocoChip1.addMouseListener(new LevelMouseListener(this, controller, model, chocoChip1));
		southWestSection.add(SW02, inner);

		// South West Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel SW12 = new JPanel();
		SW12.setPreferredSize(small_panel);
		SW12.setOpaque(false);
		southWestSection.add(SW12, inner);

		// South West Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel SW22 = new JPanel();
		SW22.setPreferredSize(small_panel);
		SW22.setOpaque(false);
		southWestSection.add(SW22, inner);

		outer.gridx = 0;
		outer.gridy = 2;
		map.add(southWestSection, outer);

		// South Section
		JPanel southSection = new JPanel(new GridBagLayout());
		southSection.setPreferredSize(new Dimension(300, 300));
		southSection.setOpaque(false);
		
		// South Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel S00 = new JPanel();
		S00.setPreferredSize(small_panel);
		S00.setOpaque(false);
		S00.add(macaron1);		
		macaron1.addMouseListener(new LevelMouseListener(this, controller, model, macaron1));
		southSection.add(S00, inner);

		// South Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel S10 = new JPanel();
		S10.setPreferredSize(small_panel);
		S10.setOpaque(false);
		southSection.add(S10, inner);

		// South Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel S20 = new JPanel();
		S20.setPreferredSize(small_panel);
		S20.setOpaque(false);
		S20.add(macaron2);		
		macaron2.addMouseListener(new LevelMouseListener(this, controller, model, macaron2));
		southSection.add(S20, inner);

		// South Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel S01 = new JPanel();
		S01.setPreferredSize(small_panel);
		S01.setOpaque(false);
		southSection.add(S01, inner);

		// South Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel S11 = new JPanel();
		S11.setPreferredSize(small_panel);
		S11.setOpaque(false);
		S11.add(chocoChip4);
		chocoChip4.addMouseListener(new LevelMouseListener(this, controller, model, chocoChip4));
		southSection.add(S11, inner);

		// South Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel S21 = new JPanel();
		S21.setPreferredSize(small_panel);
		S21.setOpaque(false);
		southSection.add(S21, inner);

		// South Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel S02 = new JPanel();
		S02.setPreferredSize(small_panel);
		S02.setOpaque(false);
		southSection.add(S02, inner);

		// South Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel S12 = new JPanel();
		S12.setPreferredSize(small_panel);
		S12.setOpaque(false);
		southSection.add(S12, inner);

		// South Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel S22 = new JPanel();
		S22.setPreferredSize(small_panel);
		S22.setOpaque(false);
		southSection.add(S22, inner);
		
		outer.gridx = 1;
		outer.gridy = 2;
		map.add(southSection, outer);

		// South East Section
		JPanel southEastSection = new JPanel(new GridBagLayout());
		southEastSection.setPreferredSize(new Dimension(300, 300));
		southEastSection.setOpaque(false);
		
		// South East Top Left
		inner.gridx = 0;
		inner.gridy = 0;
		JPanel SE00 = new JPanel();
		SE00.setPreferredSize(small_panel);
		SE00.setOpaque(false);
		southEastSection.add(SE00, inner);

		// South East Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel SE10 = new JPanel();
		SE10.setPreferredSize(small_panel);
		SE10.setOpaque(false);
		southEastSection.add(SE10, inner);

		// South East Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel SE20 = new JPanel();
		SE20.setPreferredSize(small_panel);
		SE20.setOpaque(false);
		southEastSection.add(SE20, inner);

		// South East Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel SE01 = new JPanel();
		SE01.setPreferredSize(small_panel);
		SE01.setOpaque(false);
		SE01.add(fudge2);
		fudge2.addMouseListener(new LevelMouseListener(this, controller, model, fudge2));
		southEastSection.add(SE01, inner);

		// South East Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel SE11 = new JPanel();
		SE11.setPreferredSize(small_panel);
		SE11.setOpaque(false);
		southEastSection.add(SE11, inner);

		// South East Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel SE21 = new JPanel();
		SE21.setPreferredSize(small_panel);
		SE21.setOpaque(false);
		southEastSection.add(SE21, inner);

		// South East Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel SE02 = new JPanel();
		SE02.setPreferredSize(small_panel);
		SE02.setOpaque(false);
		SE02.add(fudge1);
		fudge1.addMouseListener(new LevelMouseListener(this, controller, model, fudge1));
		southEastSection.add(SE02, inner);

		// South East Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel SE12 = new JPanel();
		SE12.setPreferredSize(small_panel);
		SE12.setOpaque(false);
		southEastSection.add(SE12, inner);

		// South East Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel SE22 = new JPanel();
		SE22.setPreferredSize(small_panel);
		SE22.setOpaque(false);
		southEastSection.add(SE22, inner);
		
		outer.gridx = 2;
		outer.gridy = 2;
		map.add(southEastSection, outer);

		mainArea.add(map, "map");
	}

	public void initLevelView() {
		GridBagConstraints gbc = new GridBagConstraints();
		Font myFont = new Font("Arial", Font.PLAIN, 20);
		levelView.setBackground(Color.black);
		
		// Top Row 1st Column
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 0; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		JButton back = new JButton();
		back.addActionListener(controller);
		back.setActionCommand("Back");
		back.setIcon(loadImage("backArrow"));
		back.setPreferredSize(new Dimension(225,130));
		levelView.add(back,gbc);
		gbc = new GridBagConstraints();
		
		// Top Row 2nd Column
		gbc.gridx = 1; gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0; 
		gbc.fill = GridBagConstraints.BOTH;
		JPanel namePanel = new JPanel(new BorderLayout());
		//namePanel.setPreferredSize(new Dimension(675,225));
		namePanel.setBackground(DARK_BROWN);
		namePanel.add(cityName,BorderLayout.CENTER);
		cityName.setFont(myFont);
		cityName.setHorizontalAlignment(SwingConstants.CENTER);
		cityName.setVerticalAlignment(SwingConstants.CENTER);
		levelView.add(namePanel,gbc);
		gbc = new GridBagConstraints();

		
		// Second Row 1st Column
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.weightx = 0; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		JPanel tRange = new JPanel(new BorderLayout());
		tRange.setPreferredSize(new Dimension(225,100));
		tRange.setBackground(DARK_BROWN);
		JLabel trange = new JLabel("Target Range");
		trange.setFont(myFont);
		trange.setHorizontalAlignment(SwingConstants.CENTER);
		trange.setVerticalAlignment(SwingConstants.CENTER);
		tRange.add(trange, BorderLayout.CENTER);
		levelView.add(tRange,gbc);
		gbc = new GridBagConstraints();

		
		// 2nd Row 2nd Column
		gbc.gridx = 1; gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0; 
		gbc.fill = GridBagConstraints.BOTH;
		JPanel tRangePanel = new JPanel(new GridLayout());
		tRangePanel.setBackground(LIGHT_BROWN);
		JLabel dash1 = new JLabel("To");
		dash1.setFont(myFont);
		dash1.setHorizontalAlignment(SwingConstants.CENTER);
		dash1.setVerticalAlignment(SwingConstants.CENTER);
		tMinRange.setFont(myFont);
		tMinRange.setHorizontalAlignment(SwingConstants.CENTER);
		tMinRange.setVerticalAlignment(SwingConstants.CENTER);
		tMaxRange.setFont(myFont);
		tMaxRange.setHorizontalAlignment(SwingConstants.CENTER);
		tMaxRange.setVerticalAlignment(SwingConstants.CENTER);
		tRangePanel.add(tMinRange);
		tRangePanel.add(dash1);
		tRangePanel.add(tMaxRange);
		levelView.add(tRangePanel, gbc);
		gbc = new GridBagConstraints();

		// 3rd Row 1st Column
		gbc.gridx = 0; gbc.gridy = 2;
		gbc.weightx = 0; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		JPanel cRange = new JPanel(new BorderLayout());
		cRange.setBackground(PURPLE);
		cRange.setPreferredSize(new Dimension(225,100));
		JLabel crange = new JLabel("Current Possible Range");
		crange.setFont(myFont);
		crange.setHorizontalAlignment(SwingConstants.CENTER);
		crange.setVerticalAlignment(SwingConstants.CENTER);
		cRange.add(crange, BorderLayout.CENTER);
		levelView.add(cRange, gbc);
		gbc = new GridBagConstraints();


		// 3rd Row 2nd Column
		gbc.gridx = 1; gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0; 
		gbc.fill = GridBagConstraints.BOTH;
		JPanel cRangePanel = new JPanel(new GridLayout());
		cRangePanel.setBackground(DARK_BROWN);
		JLabel dash2 = new JLabel("To");
		dash2.setFont(myFont);
		dash2.setHorizontalAlignment(SwingConstants.CENTER);
		dash2.setVerticalAlignment(SwingConstants.CENTER);
		cMinRange.setFont(myFont);
		cMinRange.setHorizontalAlignment(SwingConstants.CENTER);
		cMinRange.setVerticalAlignment(SwingConstants.CENTER);
		cMaxRange.setFont(myFont);
		cMaxRange.setHorizontalAlignment(SwingConstants.CENTER);
		cMaxRange.setVerticalAlignment(SwingConstants.CENTER);
		cRangePanel.add(cMinRange);
		cRangePanel.add(dash2);
		cRangePanel.add(cMaxRange);
		levelView.add(cRangePanel, gbc);
		gbc = new GridBagConstraints();

		// 4th row, First column
		gbc.gridx = 0; gbc.gridy = 3;
		gbc.gridwidth = 2;
		//gbc.gridheight = 2;
		gbc.weightx = 1.0; 
		gbc.fill = GridBagConstraints.BOTH;

		selectedItemHolder.setPreferredSize(new Dimension(675,250));
		selectedItemHolder.setBackground(LIGHT_BROWN);
		levelView.add(selectedItemHolder,gbc);
		gbc = new GridBagConstraints();

		// 4th row, Second column
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.LINE_END;
		messageBoard.setEditable(false);
		messageBoard.setPreferredSize(new Dimension(225,250));
		messageBoard.setBackground(BEIGE);
		messageBoard.setForeground(PURPLE);
		levelView.add(messageBoard, gbc);
		gbc = new GridBagConstraints();

		// 5th row, First column pls
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		// gbc.gridheight = 2;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		selectedDiceHolder.setPreferredSize(new Dimension(675,250));
		selectedDiceHolder.setBackground(BEIGE);
		levelView.add(selectedDiceHolder, gbc);
		gbc = new GridBagConstraints();

		// 5th row, 2nd column
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.LINE_END;
		JButton roll = new JButton();
		roll.addActionListener(controller);
		roll.setIcon(loadImage("RollButton"));
		roll.setBackground(PURPLE);
		roll.setActionCommand("Roll");
		levelView.add(roll, gbc);

		mainArea.add(levelView, "level");
	}

	public void addMainArea() {
		frame.add(mainArea, BorderLayout.CENTER);
	}

	public void changeMainArea() {
		CardLayout cl = (CardLayout) mainArea.getLayout();
		if (mapOnScreen) {
			cl.show(mainArea, "level");
			mapOnScreen = false;
		} else {
			cl.show(mainArea, "map");
			mapOnScreen = true;
		}
	}

	/* Probably the ugliest way I could have coded this */
	public void fillLevelInfo(Level level) {
		levelName = level.getName();
		levelMinRange = level.getMinRange();
		levelMaxRange = level.getMaxRange(); 
		cityName.setText(levelName);
		tMinRange.setText("" + levelMinRange);
		tMaxRange.setText("" + levelMaxRange);
		cMinRange.setText("" + 0);
		cMaxRange.setText("" + 0);
		
	}
	
	public void fillLabelList() {
		levelLabels.add(chocoChip1);
		levelLabels.add(chocoChip2);
		levelLabels.add(chocoChip3);
		levelLabels.add(chocoChip4);
		levelLabels.add(macaron1);
		levelLabels.add(macaron2);
		levelLabels.add(macaron3);
		levelLabels.add(fudge1);
		levelLabels.add(fudge2);
		levelLabels.add(fudge3);
		levelLabels.add(peanut_cookie1);
		levelLabels.add(peanut_cookie2);
		levelLabels.add(peanut_cookie3);
		levelLabels.add(red_jelly1);
		levelLabels.add(red_jelly2);
		levelLabels.add(red_jelly3);
		labelListFilled = true;
	}
	
	public void updateLabels() {
		for(int i=0;i<levelLabels.size();i++) {
			boolean change = model.getLevels().get(levelLabels.get(i)).getIsComplete();
			if(change) {
				levelLabels.get(i).setIcon(loadImage(model.getLevels().get(levelLabels.get(i)).getDefaultImgPath() + "flag"));
			}
			
		}
	}
	
	/*
	 * Creates right panel
	 */
	public void initDiceZone() {
		// overarching panel containing our 3 components
		JPanel rightSection = new JPanel(new GridBagLayout());
		rightSection.setBackground(Color.blue);
		rightSection.setPreferredSize(new Dimension(300, 0));
		GridBagConstraints gbc = new GridBagConstraints();

		// diceZone is where the dice will be displayed in the right panel, we can add
		// things to it as it is not a local variable
		diceZone.setBackground(DARK_BROWN);
		diceZone.setPreferredSize(new Dimension(300, 300));
		itemZone.setBackground(DARK_BROWN);
		itemZone.setPreferredSize(new Dimension(300, 300));

		// tsection, short for top section, just has the word dice on it
		JPanel tSection = new JPanel(new BorderLayout());
		JLabel dice = new JLabel("Dice");
		Font myFont = new Font("Arial", Font.PLAIN, 20);
		dice.setFont(myFont);
		tSection.add(dice, BorderLayout.CENTER);
		dice.setHorizontalAlignment(SwingConstants.CENTER);
		dice.setVerticalAlignment(SwingConstants.CENTER);
		tSection.setBackground(LIGHT_BROWN);
		tSection.setPreferredSize(new Dimension(300, 50));

		// bsection, bottom section, since we need to add info to this, it can't be
		// local
		JPanel bSection = new JPanel(new BorderLayout());
		JLabel bottomText = new JLabel("Items");
		bSection.setBackground(LIGHT_BROWN);
		bSection.setPreferredSize(new Dimension(300, 50));
		bottomText.setFont(myFont);
		bSection.add(bottomText, BorderLayout.CENTER);
		bottomText.setHorizontalAlignment(SwingConstants.CENTER);
		bottomText.setVerticalAlignment(SwingConstants.CENTER);
		// scrollpane just makes it so that we can scroll down to see all our dice, we
		// placed dicezone in it
		JScrollPane diceScroll = new JScrollPane(diceZone, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane itemScroll = new JScrollPane(itemZone, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		diceScroll.setPreferredSize(new Dimension(300,300));
		itemScroll.setPreferredSize(new Dimension(300,300));


		// we add everythin to the overarching right panel, then add it to the frame
		gbc.gridx = 1;
		gbc.gridy = 0;
		rightSection.add(tSection, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weighty = 1;
		rightSection.add(diceScroll, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		rightSection.add(bSection, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		rightSection.add(itemScroll, gbc);
		frame.add(rightSection, BorderLayout.EAST);
	}

	public void updateDiceZone() {
		ArrayList<Die> playerDice = model.getPlayerDice();
		Collections.sort(playerDice);

		diceZone.removeAll(); // clear previous dice

		for (Die die : playerDice) {
			JPanel panel = new JPanel(new BorderLayout());
			panel.setOpaque(false);
			JLabel label = new JLabel(loadImage(die.getFileName()));
			label.setHorizontalAlignment(SwingConstants.CENTER);
        	label.setVerticalAlignment(SwingConstants.CENTER);
			label.addMouseListener(new DiceMouseListener(this, controller, label, die));
			panel.add(label, BorderLayout.CENTER);
			diceZone.add(panel);
		}

		diceZone.revalidate(); // relayout
    	diceZone.repaint();    // refresh
	}

	public void updateSelectedDice() {
		selectedDiceHolder.removeAll();

		ArrayList<Die> selectedDice = model.getSelectedDice();

		for(int i = 0; i < selectedDice.size(); i++){
			if(selectedDice.get(i) != null){
			JLabel selectedDiceIcon = new JLabel(loadImage(selectedDice.get(i).getFileName()));
			selectedDiceIcon.addMouseListener(new DiceMouseListener(this,controller,selectedDiceIcon,selectedDice.get(i)));
			selectedDiceHolder.add(selectedDiceIcon);
			}
		}
		selectedDiceHolder.revalidate(); // relayout
		selectedDiceHolder.repaint(); 
	}

	public void selectedDiceHelper(int index){
		
	}

	public ImageIcon loadImage(String dieName) {
		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/assets/" + dieName + ".png"));
			return new ImageIcon(image);
		} catch (IOException | IllegalArgumentException e) {
			System.err.println("Error loadingimage");
		}
		return null;
	}

	/*
	 * Creates the main window and components for view.
	 */
	public void initializeMainFrame() {
		if(labelListFilled == false) {
			fillLabelList();
		}
		createMainFrame();
		createPopup();
		updateLabels();
		initMap();
		initLevelView();
		addMainArea();
		initDiceZone();
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	

	
	// test pls

}
