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

	
	private Model model;
	
	/**
	 * Constructor to initialize the LabelMouseListener.
	 * 
	 * @param view The game view.
	 * @param controller The game controller.
	 * @param label The JLabel associated with the card.
	 */
	LevelMouseListener(Gooey view, Controller controller, Model model, JLabel label){
		this.view = view;
		this.controller = controller;
		this.model = model;
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
		if(!model.getLevels().get(label).isLocked && !model.getLevels().get(label).getIsComplete() ) {

		label.setIcon(view.loadImage(model.getLevels().get(label).getHoveredImgPath()));
		}

	}

	/**
	 * Handles when the mouse leaves the card, restoring its previous display mode.
	 * 
	 * @param e The mouse event triggered when leaving the card.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		//TODO what happens when your mouse exits a level
		if(!model.getLevels().get(label).isLocked && !model.getLevels().get(label).getIsComplete() ) {
		label.setIcon(view.loadImage(model.getLevels().get(label).getDefaultImgPath()));
		}
	}

	/**
	 * Handles card selection when clicked, updating the UI and notifying the controller.
	 * 
	 * @param e The mouse event triggered when the card is clicked.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if((model.getLevels().get(label).getIsLocked()) == false && model.getLevels().get(label).getIsComplete() == false){
			//TODO what happens when you click on a level
			view.fillLevelInfo(model.getLevels().get(label));
			String message = "Roll Between " + model.getLevels().get(label).getMinRange() + " And " + model.getLevels().get(label).getMaxRange() 
					+ " To Conquer this Kingdom! \nIf your final roll is outside the target range, you will lose the dice you attempted the roll with!";
			view.useMessageBoard(message);
			view.changeMainArea();
		}
			
	}
	
	
	
}



