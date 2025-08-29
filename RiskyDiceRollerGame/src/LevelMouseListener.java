import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class LevelMouseListener extends MouseAdapter {

	private Gooey view;

	/**
	 * The JLabel representing the card
	 */
	private JLabel label;

	/**
	 * Reference to the Controller for game actions
	 */
	private Controller controller;

	private Level level;
	
	/**
	 * Constructor to initialize the LabelMouseListener.
	 * 
	 * @param view The game view.
	 * @param controller The game controller.
	 * @param label The JLabel associated with the card.
	 */
	LevelMouseListener(Gooey view, Controller controller, JLabel label){
		this.view = view;
		this.controller = controller;
		this.label = label;
	}

	/**
	 * Handles mouse hover over a card, displaying the full card image.
	 * 
	 * @param e The mouse event triggered when hovering over the card.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		//TODO what happens when you hover over a level
		System.out.println(controller.getLevels().get(label).getName()); 
		label.setIcon(view.loadImage(controller.getLevels().get(label).getHoveredImgPath()));

	}

	/**
	 * Handles when the mouse leaves the card, restoring its previous display mode.
	 * 
	 * @param e The mouse event triggered when leaving the card.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		//TODO what happens when your mouse exits a level
		label.setIcon(view.loadImage(controller.getLevels().get(label).getDefaultImgPath()));
	}

	/**
	 * Handles card selection when clicked, updating the UI and notifying the controller.
	 * 
	 * @param e The mouse event triggered when the card is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if((controller.getLevels().get(label).getIsLocked()) == false || controller.getLevels().get(label).getIsComplete()){
			//TODO what happens when you click on a level
			view.fillLevelInfo(controller.getLevels().get(label));
			String message = "Roll Between " + controller.getLevels().get(label).getMinRange() + " And " + controller.getLevels().get(label).getMaxRange() 
					+ " To Conquer this Kingdom!";
			view.useMessageBoard(message);
			view.changeMainArea();
		}
			
	}
	
	
	
}



