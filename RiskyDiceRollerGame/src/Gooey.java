
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Gooey extends JPanel implements Runnable {

	JFrame frame = new JFrame();
	ImageIcon bgIcon = new ImageIcon(getClass().getResource("/assets/mapBackground.png"));
	ImagePanel map = new ImagePanel(bgIcon, new GridBagLayout());
	JPanel rightSection = new JPanel(new BorderLayout());
	JPanel diceZone = new JPanel(new GridLayout());
	JPanel bSection = new JPanel();
	JLabel bottomText = new JLabel("example text");
	Controller controller = new Controller();

	// chocolate chip islands
	JLabel chocoChip1 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip2 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip3 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip4 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip5 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip6 = new JLabel(loadImage("chocoChip"));
	JLabel chocoChip7 = new JLabel(loadImage("chocoChip"));

	// macaron islands
	JLabel macaron1 = new JLabel(loadImage("macaron"));
	JLabel macaron2 = new JLabel(loadImage("macaron"));
	JLabel macaron3 = new JLabel(loadImage("macaron"));
	JLabel macaron4 = new JLabel(loadImage("macaron"));
	JLabel macaron5 = new JLabel(loadImage("macaron"));
	JLabel macaron6 = new JLabel(loadImage("macaron"));
	JLabel macaron7 = new JLabel(loadImage("macaron"));
	JLabel macaron8 = new JLabel(loadImage("macaron"));
	JLabel macaron9 = new JLabel(loadImage("macaron"));
	JLabel macaron10 = new JLabel(loadImage("macaron"));

	// fudge islands
	JLabel fudge1 = new JLabel(loadImage("fudge"));
	JLabel fudge2 = new JLabel(loadImage("fudge"));
	JLabel fudge3 = new JLabel(loadImage("fudge"));
	JLabel fudge4 = new JLabel(loadImage("fudge"));
	JLabel fudge5 = new JLabel(loadImage("fudge"));
	JLabel fudge6 = new JLabel(loadImage("fudge"));
	JLabel fudge7 = new JLabel(loadImage("fudge"));
	JLabel fudge8 = new JLabel(loadImage("fudge"));
	JLabel fudge9 = new JLabel(loadImage("fudge"));
	JLabel fudge10 = new JLabel(loadImage("fudge"));
	JLabel fudge11 = new JLabel(loadImage("fudge"));
	JLabel fudge12 = new JLabel(loadImage("fudge"));
	// peanut-cookie islands
	JLabel peanut_cookie1 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie2 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie3 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie4 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie5 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie6 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie7 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie8 = new JLabel(loadImage("peanut_cookie"));
	JLabel peanut_cookie9 = new JLabel(loadImage("peanut_cookie"));

	// red-eyes filled islands
	JLabel red_jelly1 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly2 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly3 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly4 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly5 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly6 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly7 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly8 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly9 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly10 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly11 = new JLabel(loadImage("red_jelly"));
	JLabel red_jelly12 = new JLabel(loadImage("red_jelly"));

	KeyHandler keyHandler = new KeyHandler(); // handles user key presses
	Thread gameThread; // runs the game
	final int tileSize = 48;

	/* 16:9 aspect ratio */
	final int maxScreenCol = 32;
	final int maxScreenRow = 18;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	private boolean running = false;

	public Gooey() {
		this.setDoubleBuffered(true); // useful for threads
		this.addKeyListener(keyHandler); // gamePanel will be able to recognize key input.
		this.setFocusable(true);
	}

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
		nw11.add(peanut_cookie7);
		peanut_cookie7.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie7));
		northWestSection.add(nw11, inner);

		// North West Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel nw21 = new JPanel();
		nw21.setPreferredSize(small_panel);
		nw21.setOpaque(false);
		nw21.add(peanut_cookie8);
		peanut_cookie8.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie8));
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
		nw22.add(peanut_cookie6);
		peanut_cookie6.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie6));
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
		n00.add(peanut_cookie9);
		peanut_cookie9.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie9));
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
		n11.add(red_jelly8);
		red_jelly8.addMouseListener(new LabelMouseListener(this, controller,red_jelly8));
		northSection.add(n11, inner);

		// North Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel n21 = new JPanel();
		n21.setPreferredSize(small_panel);
		n21.setOpaque(false);
		n21.add(red_jelly9);
		red_jelly9.addMouseListener(new LabelMouseListener(this, controller,red_jelly9));
		northSection.add(n21, inner);

		// North Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel n02 = new JPanel();
		n02.setPreferredSize(small_panel);
		n02.setOpaque(false);
		n02.add(red_jelly4);
		red_jelly4.addMouseListener(new LabelMouseListener(this, controller,red_jelly4));
		northSection.add(n02, inner);

		// North Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel n12 = new JPanel();
		n12.setPreferredSize(small_panel);
		n12.setOpaque(false);
		n12.add(red_jelly5);
		red_jelly5.addMouseListener(new LabelMouseListener(this, controller,red_jelly5));
		northSection.add(n12, inner);

		// North Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel n22 = new JPanel();
		n22.setPreferredSize(small_panel);
		n22.setOpaque(false);
		n22.add(red_jelly6);
		red_jelly6.addMouseListener(new LabelMouseListener(this, controller,red_jelly6));
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
		nE10.add(red_jelly12);
		red_jelly12.addMouseListener(new LabelMouseListener(this, controller,red_jelly12));
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
		nE01.add(red_jelly10);
		red_jelly10.addMouseListener(new LabelMouseListener(this, controller,red_jelly10));
		northEastSection.add(nE01, inner);

		// North East Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel nE11 = new JPanel();
		nE11.setPreferredSize(small_panel);
		nE11.setOpaque(false);
		nE11.add(red_jelly11);
		red_jelly11.addMouseListener(new LabelMouseListener(this, controller,red_jelly11));
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
		nE02.add(red_jelly7);
		red_jelly7.addMouseListener(new LabelMouseListener(this, controller,red_jelly7));
		northEastSection.add(nE02, inner);

		// North East Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel nE12 = new JPanel();
		nE12.setPreferredSize(small_panel);
		nE12.setOpaque(false);
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
		W10.add(peanut_cookie3);
		peanut_cookie3.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie3));
		westSection.add(W10, inner);

		// West Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel W20 = new JPanel();
		W20.setPreferredSize(small_panel);
		W20.setOpaque(false);
		W20.add(peanut_cookie4);
		peanut_cookie4.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie4));
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
		peanut_cookie1.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie1));
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
		W22.add(macaron6);
		macaron6.addMouseListener(new LabelMouseListener(this, controller,macaron6));
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
		C00.add(peanut_cookie5);
		peanut_cookie5.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie5));
		centerSection.add(C00, inner);

		// Center Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel C10 = new JPanel();
		C10.setPreferredSize(small_panel);
		C10.setOpaque(false);
		C10.add(red_jelly2);
		red_jelly2.addMouseListener(new LabelMouseListener(this, controller,red_jelly2));
		centerSection.add(C10, inner);

		// Center Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel C20 = new JPanel();
		C20.setPreferredSize(small_panel);
		C20.setOpaque(false);
		C20.add(macaron10);
		macaron10.addMouseListener(new LabelMouseListener(this, controller,macaron10));
		centerSection.add(C20, inner);

		// Center Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel C01 = new JPanel();
		C01.setPreferredSize(small_panel);
		C01.setOpaque(false);
		C01.add(peanut_cookie2);
		peanut_cookie2.addMouseListener(new LabelMouseListener(this, controller,peanut_cookie2));
		centerSection.add(C01, inner);

		// Center Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel C11 = new JPanel();
		C11.setPreferredSize(small_panel);
		C11.setOpaque(false);
		C11.add(macaron9);
		macaron9.addMouseListener(new LabelMouseListener(this, controller,macaron9));
		centerSection.add(C11, inner);

		// Center Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel C21 = new JPanel();
		C21.setPreferredSize(small_panel);
		C21.setOpaque(false);
		C21.add(fudge10);
		fudge10.addMouseListener(new LabelMouseListener(this, controller,fudge10));
		centerSection.add(C21, inner);

		// Center Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel C02 = new JPanel();
		C02.setPreferredSize(small_panel);
		C02.setOpaque(false);
		C02.add(macaron7);
		macaron7.addMouseListener(new LabelMouseListener(this, controller,macaron7));
		centerSection.add(C02, inner);

		// Center Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel C12 = new JPanel();
		C12.setPreferredSize(small_panel);
		C12.setOpaque(false);
		C12.add(macaron8);
		macaron8.addMouseListener(new LabelMouseListener(this, controller,macaron8));
		centerSection.add(C12, inner);

		// Center Bottom Right
		inner.gridx = 2;
		inner.gridy = 2;
		JPanel C22 = new JPanel();
		C22.setPreferredSize(small_panel);
		C22.setOpaque(false);
		C22.add(fudge8);
		fudge8.addMouseListener(new LabelMouseListener(this, controller,fudge8));
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
		E00.add(red_jelly3);
		red_jelly3.addMouseListener(new LabelMouseListener(this, controller,red_jelly3));
		eastSection.add(E00, inner);

		// East Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel E10 = new JPanel();
		E10.setPreferredSize(small_panel);
		E10.setOpaque(false);
		E10.add(fudge12);
		fudge12.addMouseListener(new LabelMouseListener(this, controller,fudge12));
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
		E01.add(red_jelly1);
		red_jelly1.addMouseListener(new LabelMouseListener(this, controller,red_jelly1));
		eastSection.add(E01, inner);

		// East Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel E11 = new JPanel();
		E11.setPreferredSize(small_panel);
		E11.setOpaque(false);
		E11.add(fudge11);
		fudge11.addMouseListener(new LabelMouseListener(this, controller,fudge11));
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
		E02.add(fudge9);
		fudge9.addMouseListener(new LabelMouseListener(this, controller,fudge9));
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
		SW10.add(chocoChip6);
		chocoChip6.addMouseListener(new LabelMouseListener(this, controller,chocoChip6));
		southWestSection.add(SW10, inner);

		// South West Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel SW20 = new JPanel();
		SW20.setPreferredSize(small_panel);
		SW20.setOpaque(false);
		SW20.add(chocoChip7);
		chocoChip7.addMouseListener(new LabelMouseListener(this, controller,chocoChip7));
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
		SW11.add(chocoChip3);
		chocoChip3.addMouseListener(new LabelMouseListener(this, controller,chocoChip3));
		southWestSection.add(SW11, inner);

		// South West Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel SW21 = new JPanel();
		SW21.setPreferredSize(small_panel);
		SW21.setOpaque(false);
		SW21.add(chocoChip4);
		chocoChip4.addMouseListener(new LabelMouseListener(this, controller,chocoChip4));
		southWestSection.add(SW21, inner);

		// South West Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel SW02 = new JPanel();
		SW02.setPreferredSize(small_panel);
		SW02.setOpaque(false);
		SW02.add(chocoChip1);
		chocoChip1.addMouseListener(new LabelMouseListener(this, controller,chocoChip1));
		southWestSection.add(SW02, inner);

		// South West Bottom Center
		inner.gridx = 1;
		inner.gridy = 2;
		JPanel SW12 = new JPanel();
		SW12.setPreferredSize(small_panel);
		SW12.setOpaque(false);
		SW12.add(chocoChip2);
		chocoChip2.addMouseListener(new LabelMouseListener(this, controller,chocoChip2));
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
		S00.add(macaron3);		
		macaron3.addMouseListener(new LabelMouseListener(this, controller,macaron3));
		southSection.add(S00, inner);

		// South Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel S10 = new JPanel();
		S10.setPreferredSize(small_panel);
		S10.setOpaque(false);
		S10.add(macaron4);		
		macaron4.addMouseListener(new LabelMouseListener(this, controller,macaron4));
		southSection.add(S10, inner);

		// South Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel S20 = new JPanel();
		S20.setPreferredSize(small_panel);
		S20.setOpaque(false);
		S20.add(macaron5);		
		macaron5.addMouseListener(new LabelMouseListener(this, controller,macaron5));
		southSection.add(S20, inner);

		// South Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel S01 = new JPanel();
		S01.setPreferredSize(small_panel);
		S01.setOpaque(false);
		S01.add(chocoChip5);
		chocoChip5.addMouseListener(new LabelMouseListener(this, controller,chocoChip5));
		southSection.add(S01, inner);

		// South Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel S11 = new JPanel();
		S11.setPreferredSize(small_panel);
		S11.setOpaque(false);
		S11.add(macaron2);		
		macaron2.addMouseListener(new LabelMouseListener(this, controller,macaron2));
		southSection.add(S11, inner);

		// South Center Right
		inner.gridx = 2;
		inner.gridy = 1;
		JPanel S21 = new JPanel();
		S21.setPreferredSize(small_panel);
		S21.setOpaque(false);
		S21.add(fudge2);		
		fudge2.addMouseListener(new LabelMouseListener(this, controller,fudge2));
		southSection.add(S21, inner);

		// South Bottom Left
		inner.gridx = 0;
		inner.gridy = 2;
		JPanel S02 = new JPanel();
		S02.setPreferredSize(small_panel);
		S02.setOpaque(false);
		S02.add(macaron1);		
		macaron1.addMouseListener(new LabelMouseListener(this, controller,macaron1));
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
		SE00.add(fudge5);
		fudge5.addMouseListener(new LabelMouseListener(this, controller,fudge5));
		southEastSection.add(SE00, inner);

		// South East Top Center
		inner.gridx = 1;
		inner.gridy = 0;
		JPanel SE10 = new JPanel();
		SE10.setPreferredSize(small_panel);
		SE10.setOpaque(false);
		SE10.add(fudge6);
		fudge6.addMouseListener(new LabelMouseListener(this, controller,fudge6));
		southEastSection.add(SE10, inner);

		// South East Top Right
		inner.gridx = 2;
		inner.gridy = 0;
		JPanel SE20 = new JPanel();
		SE20.setPreferredSize(small_panel);
		SE20.setOpaque(false);
		SE20.add(fudge7);
		fudge7.addMouseListener(new LabelMouseListener(this, controller,fudge7));
		southEastSection.add(SE20, inner);

		// South East Center Left
		inner.gridx = 0;
		inner.gridy = 1;
		JPanel SE01 = new JPanel();
		SE01.setPreferredSize(small_panel);
		SE01.setOpaque(false);
		SE01.add(fudge3);
		fudge3.addMouseListener(new LabelMouseListener(this, controller,fudge3));
		southEastSection.add(SE01, inner);

		// South East Center
		inner.gridx = 1;
		inner.gridy = 1;
		JPanel SE11 = new JPanel();
		SE11.setPreferredSize(small_panel);
		SE11.setOpaque(false);
		SE11.add(fudge4);
		fudge4.addMouseListener(new LabelMouseListener(this, controller,fudge4));
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
		fudge1.addMouseListener(new LabelMouseListener(this, controller,fudge1));
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

		frame.add(map, BorderLayout.CENTER);
	}

	/*
	 * Creates right panel
	 */
	public void initDiceZone() {
		// overarching panel containing our 3 components
		rightSection.setBackground(Color.blue);
		rightSection.setPreferredSize(new Dimension(300, 0));

		// diceZone is where the dice will be displayed in the right panel, we can add
		// things to it as it is not a local variable
		diceZone.setBackground(Color.green);
		diceZone.setPreferredSize(new Dimension(200, 100));

		// tsection, short for top section, just has the word dice on it
		JPanel tSection = new JPanel(new BorderLayout());
		JLabel dice = new JLabel("Dice");
		Font myFont = new Font("Arial", Font.PLAIN, 20);
		dice.setFont(myFont);
		tSection.add(dice, BorderLayout.CENTER);
		dice.setHorizontalAlignment(SwingConstants.CENTER);
		dice.setVerticalAlignment(SwingConstants.CENTER);
		tSection.setBackground(Color.blue);
		tSection.setPreferredSize(new Dimension(200, 150));

		// bsection, bottom section, since we need to add info to this, it can't be
		// local
		bSection.setBackground(Color.blue);
		bSection.setPreferredSize(new Dimension(200, 100));
		bottomText.setFont(myFont);
		bSection.add(bottomText, BorderLayout.CENTER);
		bottomText.setHorizontalAlignment(SwingConstants.CENTER);
		bottomText.setVerticalAlignment(SwingConstants.CENTER);
		// scrollpane just makes it so that we can scroll down to see all our dice, we
		// placed dicezone in it
		JScrollPane diceScroll = new JScrollPane(diceZone, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// we add everythin to the overarching right panel, then add it to the frame
		rightSection.add(tSection, BorderLayout.NORTH);
		rightSection.add(diceScroll, BorderLayout.CENTER);
		rightSection.add(bSection, BorderLayout.SOUTH);
		frame.add(rightSection, BorderLayout.EAST);
	}

	public void updateDiceZone() {

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
		createMainFrame();
		initMap();
		initDiceZone();
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	
	// test pls

}
