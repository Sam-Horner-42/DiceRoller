
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
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
	JScrollPane namePanel;
	JTextPane cityName = new JTextPane();
	
	JLabel tMinToMaxRange = new JLabel("PlaceHolder");
	JLabel cMinToMaxRange = new JLabel("PlaceHolder");

	

	JPanel selectedDiceHolder = new JPanel(new GridLayout(0, 5));
	JPanel selectedItemHolder = new JPanel(new GridLayout(0, 3));

	JTextPane messageBoard = new JTextPane();
	JPanel diceZone = new JPanel(new GridLayout(0,2));
	JPanel itemZone = new JPanel(new GridLayout(0,2));
	JTextPane popup = new JTextPane();
	
	ArrayList<JLabel> levelLabels = new ArrayList<>();
	boolean labelListFilled = false;
	boolean mapOnScreen = true;
	Controller controller;
	Model model = new Model();
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
	
	JLabel dice = new JLabel("Dice  " + model.getDiceCount() + "/8");
	JLabel items = new JLabel("Items  " + model.getItemCount() + "/6");
	
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
	static final Color LIGHT_PURPLE = new Color(203, 127, 165);
	static final Color DARK_PURPLE = new Color(123, 47, 95);
	static final Color WHITE = new Color(250,243,225);
	static Font coinyRegular;


	/**
	 * Method name: createMainFrame Purpose: Initializes and configures the main
	 * game frame. Algorithm: Instantiate a new JFrame with the title "Crazy
	 * Eights". Set the default close operation. Disable frame resizing. Set the
	 * layout manager to BorderLayout.
	 */
	public void createMainFrame() {
		Image image = null;
		frame = new JFrame("Cookie Conquest");
		try {
			 image = ImageIO.read(getClass().getResource("/assets/chocoChip.png"));
		}
		catch(IOException | IllegalArgumentException e){
		
		}
		frame.setIconImage(image);
		frame.setBackground(PURPLE);
		frame.setForeground(BEIGE);
		frame.setFont(coinyRegular);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		setUpFont();
		
	}

	public void setUpFont(){
		try {
			InputStream is = getClass().getResourceAsStream("/fonts/COINY-REGULAR.TTF");
			coinyRegular = Font.createFont(Font.TRUETYPE_FONT, is);
			coinyRegular = coinyRegular.deriveFont(Font.BOLD, 30);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	

	
	public void usePopup(String text) {
		popup.setText(text);
	}
	
	public void useMessageBoard(String text) {
		Font myFont = coinyRegular.deriveFont(Font.PLAIN, 20);
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
		Font myFont = coinyRegular.deriveFont(Font.PLAIN, 18);
		Font myFontbig = coinyRegular.deriveFont(Font.PLAIN, 22);
		Font myFontbigger = coinyRegular.deriveFont(Font.PLAIN, 30);

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
		 namePanel  = new JScrollPane(cityName, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//namePanel.setPreferredSize(new Dimension(675,225));
		namePanel.setBackground(DARK_BROWN);
		namePanel.setPreferredSize(new Dimension(275,130));
		//namePanel.add(cityName,BorderLayout.CENTER);
		Font cityFont = coinyRegular.deriveFont(Font.PLAIN, 55);
		cityName.setFont(cityFont);
		cityName.setBackground(DARK_BROWN);
		cityName.setForeground(Color.black);
		cityName.setEditable(false); //LIGHT_PURPLE  DARK_PURPLE
		levelView.add(namePanel,gbc);
		gbc = new GridBagConstraints();

		
		// Second Row 1st Column
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.weightx = 0; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		JPanel cRange = new JPanel(new BorderLayout());
		cRange.setBackground(LIGHT_BROWN);
		cRange.setPreferredSize(new Dimension(225,125));
		JLabel crange = new JLabel("Possible Range");
		crange.setForeground(DARK_PURPLE);	
		crange.setFont(myFontbig);
		crange.setHorizontalAlignment(SwingConstants.CENTER);
		crange.setVerticalAlignment(SwingConstants.CENTER);
		cRange.add(crange, BorderLayout.CENTER);
		levelView.add(cRange, gbc);
		gbc = new GridBagConstraints();

		
		// 2nd Row 2nd Column
		gbc.gridx = 1; gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0; 
		gbc.fill = GridBagConstraints.BOTH;
		JPanel cRangePanel = new JPanel(new BorderLayout());
		cRangePanel.setBackground(LIGHT_BROWN);
		cMinToMaxRange.setFont(myFontbigger);
		cMinToMaxRange.setForeground(DARK_PURPLE);
		cMinToMaxRange.setHorizontalAlignment(SwingConstants.CENTER);
		cMinToMaxRange.setVerticalAlignment(SwingConstants.CENTER);
		cRangePanel.add(cMinToMaxRange, BorderLayout.CENTER);
		levelView.add(cRangePanel, gbc);
		gbc = new GridBagConstraints();

		// 3rd Row 1st Column
		gbc.gridx = 0; gbc.gridy = 2;
		gbc.weightx = 0; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		JPanel tRange = new JPanel(new BorderLayout());
		tRange.setPreferredSize(new Dimension(225,125));
		tRange.setBackground(PURPLE);
		JLabel trange = new JLabel("Target Range");
		trange.setFont(myFontbig);
		trange.setForeground(BEIGE);
		trange.setHorizontalAlignment(SwingConstants.CENTER);
		trange.setVerticalAlignment(SwingConstants.CENTER);
		tRange.add(trange, BorderLayout.CENTER);
		levelView.add(tRange,gbc);
		gbc = new GridBagConstraints();


		// 3rd Row 2nd Column
		gbc.gridx = 1; gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0; 
		gbc.fill = GridBagConstraints.BOTH;
		JPanel tRangePanel = new JPanel(new BorderLayout());
		tRangePanel.setBackground(PURPLE);
		tMinToMaxRange.setFont(myFontbigger);
		tMinToMaxRange.setForeground(BEIGE);
		tMinToMaxRange.setHorizontalAlignment(SwingConstants.CENTER);
		tMinToMaxRange.setVerticalAlignment(SwingConstants.CENTER);
		tRangePanel.add(tMinToMaxRange, BorderLayout.CENTER);
		levelView.add(tRangePanel, gbc);
		gbc = new GridBagConstraints();

		// 4th row, First column
		//myFont = coinyRegular.deriveFont(Font.PLAIN, 20);
		gbc.gridx = 0; gbc.gridy = 3;
		gbc.gridwidth = 2;
		//gbc.gridheight = 2;
		gbc.weightx = 1.0; 
		gbc.fill = GridBagConstraints.BOTH;

		selectedItemHolder.setPreferredSize(new Dimension(675,200));
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
		messageBoard.setFont(myFont);
		messageBoard.setBackground(BEIGE);
		messageBoard.setForeground(DARK_PURPLE);
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
		cityName.setText("       " +levelName);
		tMinToMaxRange.setText("" + levelMinRange + " to " + levelMaxRange);
		cMinToMaxRange.setText(0 + " to " + 0);

		
	}

	/* Updates the current range for the dice currently selected */
	public void updateRanges(int min, int max){
		cMinToMaxRange.setText("" + min + " to " + max);

	}
	
	/*  */
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
			boolean changeFlag = model.getLevels().get(levelLabels.get(i)).getIsComplete();
			boolean changeLock = model.getLevels().get(levelLabels.get(i)).getIsLocked();
			if(changeFlag) {
				levelLabels.get(i).setIcon(loadImage(model.getLevels().get(levelLabels.get(i)).getDefaultImgPath() + "Flag"));
			} else if(changeLock) {
				levelLabels.get(i).setIcon(loadImage(model.getLevels().get(levelLabels.get(i)).lockedImgPath));
			} else {
				levelLabels.get(i).setIcon(loadImage(model.getLevels().get(levelLabels.get(i)).defaultImgPath));
			}
		}
		mainArea.repaint();
		mainArea.revalidate();
		
	}
	
	/*
	 * Creates right panel
	 */
	public void initDiceZone() {
		// overarching panel containing our 3 components
		JPanel rightSection = new JPanel(new GridBagLayout());
		rightSection.setBackground(DARK_BROWN);
		rightSection.setPreferredSize(new Dimension(300,900));
		GridBagConstraints gbc = new GridBagConstraints();
		Font myFont = coinyRegular.deriveFont(Font.PLAIN, 20);
		// diceZone is where the dice will be displayed in the right panel, we can add
		// things to it as it is not a local variable
		diceZone.setBackground(DARK_BROWN);
		itemZone.setBackground(DARK_BROWN);
		popup.setBackground(BEIGE);
		popup.setEditable(false);
		popup.setFont(myFont);
		popup.setForeground(DARK_PURPLE);
		


		// tsection, short for top section, just has the word dice on it
		JPanel tSection = new JPanel(new BorderLayout());

		dice.setFont(coinyRegular);
		tSection.add(dice, BorderLayout.CENTER);
		dice.setHorizontalAlignment(SwingConstants.CENTER);
		dice.setVerticalAlignment(SwingConstants.CENTER);
		tSection.setBackground(LIGHT_BROWN);

		// bsection, bottom section, since we need to add info to this, it can't be
		// local
		JPanel bSection = new JPanel(new BorderLayout());
		bSection.setBackground(LIGHT_BROWN);
		items.setFont(coinyRegular);
		bSection.add(items, BorderLayout.CENTER);
		items.setHorizontalAlignment(SwingConstants.CENTER);
		items.setVerticalAlignment(SwingConstants.CENTER);
		// scrollpane just makes it so that we can scroll down to see all our dice, we
		// placed dicezone in it
		JScrollPane txtScroll = new JScrollPane(popup, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// we add everythin to the overarching right panel, then add it to the frame
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weightx = 1;
		gbc.weighty = 0.08;
		rightSection.add(tSection, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0.3;
		rightSection.add(diceZone, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		rightSection.add(txtScroll, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0.08;
		rightSection.add(bSection, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0.3;
		rightSection.add(itemZone, gbc);
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
		dice.setText("Dice  " + model.getDiceCount() + "/8");
		
    	diceZone.revalidate(); // relayout
    	diceZone.repaint();    // refresh
	}
	
	public void updateItemZone() {
		ArrayList<Item> playerItems = model.getPlayerItems();

		itemZone.removeAll();
		for (Item item : playerItems) {
			JPanel panel = new JPanel(new BorderLayout());
			panel.setOpaque(false);
			JLabel label = new JLabel(loadImage(item.getName()));
			label.setHorizontalAlignment(SwingConstants.CENTER);
        	label.setVerticalAlignment(SwingConstants.CENTER);
			label.addMouseListener(new ItemMouseListener(this, controller, label, item));
			panel.add(label, BorderLayout.CENTER);
			itemZone.add(panel);
		}
		items.setText("Items  " + model.getItemCount() + "/6");
		
		itemZone.revalidate(); // relayout
		itemZone.repaint();    // refresh
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
	
	public void updateSelectedItem() {
		selectedItemHolder.removeAll();

		ArrayList<Item> selectedItems = model.getSelectedItems();

		for(int i = 0; i < selectedItems.size(); i++){
			if(selectedItems.get(i) != null){
			JLabel selectedItemIcon = new JLabel(loadImage(selectedItems.get(i).getName()));
			selectedItemIcon.addMouseListener(new ItemMouseListener(this,controller,selectedItemIcon,selectedItems.get(i)));
			selectedItemHolder.add(selectedItemIcon);
			}
		}
		selectedItemHolder.revalidate(); // relayout
		selectedItemHolder.repaint(); 
	}

	
	public void winDialog(int rollResult, ArrayList<Die> diceReward, ArrayList<Item> itemReward) {
		changeMainArea();
		 // Create the dialog (modal)
        JDialog dialog = new JDialog(frame, "WINNER! GANGANT!", true);
        dialog.setResizable(false);
		Font myFont = coinyRegular.deriveFont(Font.PLAIN, 18);
		Font myFonts = coinyRegular.deriveFont(Font.PLAIN, 16);
        dialog.setLayout(new BorderLayout());

        // Message at the top
        JTextPane message = new JTextPane();
        message.setText("	You rolled a " + rollResult + "! \nYou conquered this kingdom!");
        message.setFont(myFont);
        message.setForeground(BEIGE);
        message.setBackground(PURPLE);
        message.setEditable(false);
        dialog.add(message, BorderLayout.NORTH);

        // Extra panel in the middle
        JPanel rewardPanel = new JPanel(new GridLayout(0,1));
        rewardPanel.setBackground(PURPLE);
        JTextPane rewardMessage = new JTextPane();
        rewardMessage.setFont(myFonts);
        rewardMessage.setText(" You didn't even get anything :(");
        rewardMessage.setBackground(PURPLE);
        rewardMessage.setForeground(BEIGE);
        rewardMessage.setEditable(false);
        JPanel rewardHolder = new JPanel(new GridLayout(0,3));
        rewardHolder.setBackground(PURPLE);

        if(!diceReward.isEmpty()) {
        	rewardMessage.setText("        You received a reward");
        	for(Die dice: diceReward) {
        		JLabel dreward = new JLabel(loadImage(dice.getFileName()));
        		rewardHolder.add(dreward);
        	}
        }
        if(!itemReward.isEmpty()) {
        	rewardMessage.setText("        You recieved a reward");
        	for(Item item: itemReward) {
        		JLabel dreward = new JLabel(loadImage(item.getName()));
        		rewardHolder.add(dreward);
        	}
        	
        }

        rewardPanel.add(rewardMessage);
        rewardPanel.add(rewardHolder);
        dialog.add(rewardPanel, BorderLayout.CENTER);
        

        // OK button at the bottom
        JButton okButton = new JButton("OK");
        okButton.setBackground(LIGHT_BROWN);
        okButton.setForeground(PURPLE);

        okButton.addActionListener(e -> dialog.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(PURPLE);
        buttonPanel.add(okButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Size + position
        dialog.setSize(300, 250);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true); // blocks until closed
	}
	
	public void loseDialog(int rollResult, ArrayList<Die> diceLost) {

				 // Create the dialog (modal)
		        JDialog dialog = new JDialog(frame, "Defeated :(", true);
		        dialog.setResizable(false);
		        dialog.setLayout(new BorderLayout());
		        Font myFont = coinyRegular.deriveFont(Font.PLAIN, 18);
				Font myFonts = coinyRegular.deriveFont(Font.PLAIN, 16);

		        // Message at the top
				JTextPane message = new JTextPane();
		        message.setText("	You rolled " + rollResult + "...\n   You've been defeated..."); 
		        message.setEditable(false);
		        message.setBackground(PURPLE);
		        message.setForeground(BEIGE);
		        message.setFont(myFont);

		        dialog.add(message, BorderLayout.NORTH);

		        // Extra panel in the middle
		        JPanel diceLossPanel = new JPanel(new GridLayout(0,1));
		        diceLossPanel.setBackground(PURPLE);
		        JTextPane diceLossMessage = new JTextPane();  
		        diceLossMessage.setEditable(false);
		        diceLossMessage.setBackground(PURPLE);
		        diceLossMessage.setForeground(BEIGE);
		        diceLossMessage.setFont(myFonts);
		        diceLossMessage.setText("      You've lost these dice");
		        JPanel lostDiceHolder = new JPanel(new GridLayout(0,5));
		        lostDiceHolder.setBackground(PURPLE);
		        	for(Die dice: diceLost) {
		        		JLabel lostDice = new JLabel(loadImage(dice.getFileName()));
		        		lostDiceHolder.add(lostDice);
		        	}
		        	diceLossPanel.add(diceLossMessage);
		        	diceLossPanel.add(lostDiceHolder);
		        dialog.add(diceLossPanel, BorderLayout.CENTER);
		        

		        // OK button at the bottom
		        JButton okButton = new JButton("OK");
		        okButton.setBackground(LIGHT_BROWN);
		        okButton.setForeground(PURPLE);
		        okButton.addActionListener(e -> dialog.dispose());
		        JPanel buttonPanel = new JPanel();
		        buttonPanel.setBackground(PURPLE);
		        buttonPanel.add(okButton);
		        dialog.add(buttonPanel, BorderLayout.SOUTH);

		        // Size + position
		        dialog.setSize(300, 250);
		        dialog.setLocationRelativeTo(frame);
		        dialog.setVisible(true); // blocks until closed
		
	}
	
	public void loseGame() {
				changeMainArea();
				 // Create the dialog (modal)
		        JDialog dialog = new JDialog(frame, "Defeated :(", true);
		        dialog.setResizable(false);
		        dialog.setLayout(new GridBagLayout());
		        dialog.setBackground(BEIGE);
		        Font myFont = coinyRegular.deriveFont(Font.PLAIN, 18);
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 1;
				gbc.weighty = 1;

		        // Message at the top
		        JTextPane message = new JTextPane();
		        message.setText("            You ran out of dice!\n   Thats how the cookie crumbles..."); 
		        message.setBackground(BEIGE);
		        message.setForeground(DARK_PURPLE);
		        message.setEditable(false);
		        message.setFont(myFont);
		        dialog.add(message, gbc);
		        gbc = new GridBagConstraints();

		       
		        JPanel buttonPanel = new JPanel();
		        buttonPanel.setBackground(BEIGE);

		        // Restart button
		        JButton restartButton = new JButton("Restart");
		        restartButton.setBackground(PURPLE);
		        restartButton.setForeground(BEIGE);
		        restartButton.addActionListener(e -> {
		            dialog.dispose();   
		            model.restartGame(); 
		        });
		        buttonPanel.add(restartButton);

		        // Exit button
		        JButton exitButton = new JButton("Exit");
		        exitButton.setBackground(PURPLE);
		        exitButton.setForeground(BEIGE);
		        exitButton.addActionListener(e -> {
		            dialog.dispose();  
		            System.exit(0); 
		        });
		        buttonPanel.add(exitButton);
		        gbc.gridx = 1;
				gbc.gridy = 1;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 1;
				gbc.weighty = 1;
		        dialog.add(buttonPanel, gbc);

		        // Size + position
		        dialog.setSize(350, 150);
		        dialog.setLocationRelativeTo(frame);
		        dialog.setVisible(true); // blocks until closed
		
	}

	public void winGame() {
		changeMainArea();
		 // Create the dialog (modal)
        JDialog dialog = new JDialog(frame, "YOU WON!!! :0", true);
        dialog.setResizable(false);
        dialog.setLayout(new GridBagLayout());
        dialog.setBackground(BEIGE);
        Font myFont = coinyRegular.deriveFont(Font.PLAIN, 18);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

        // Message at the top
        JTextPane message = new JTextPane();
        message.setText("  You Conquered The Continent!!!\n   Thank you so much for playing!"); 
        message.setBackground(BEIGE);
        message.setForeground(DARK_PURPLE);
        message.setEditable(false);
        message.setFont(myFont);
        dialog.add(message, gbc);
        gbc = new GridBagConstraints();

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(BEIGE);

        // Restart button
        JButton restartButton = new JButton("Restart");
        restartButton.setBackground(PURPLE);
        restartButton.setForeground(BEIGE);
        restartButton.addActionListener(e -> {
            dialog.dispose();   
            model.restartGame(); 
        });
        buttonPanel.add(restartButton);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(PURPLE);
        exitButton.setForeground(BEIGE);
        exitButton.addActionListener(e -> {
            dialog.dispose();  
            System.exit(0); 
        });
        buttonPanel.add(exitButton);
        gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
        dialog.add(buttonPanel, gbc);

        // Size + position
        dialog.setSize(350, 170);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true); // blocks until closed

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
