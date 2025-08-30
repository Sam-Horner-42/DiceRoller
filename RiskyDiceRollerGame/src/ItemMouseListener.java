import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ItemMouseListener extends MouseAdapter {

	private Gooey view;

	/**
	 * The JLabel representing the card
	 */
	private JLabel label;

	/**
	 * Reference to the Controller for game actions
	 */
	private Controller controller;

	private Item item;
	
	/**
	 * Constructor to initialize the LabelMouseListener.
	 * 
	 * @param view The game view.
	 * @param controller The game controller.
	 * @param label The JLabel associated with the card.
	 */
	public ItemMouseListener(Gooey view, Controller controller, JLabel label, Item item){
		this.view = view;
		this.controller = controller;
		this.label = label;
		this.item = item;
	}

	/**
	 * Handles mouse hover over a card, displaying the full card image.
	 * 
	 * @param e The mouse event triggered when hovering over the card.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setEnabled(true);
		if(!view.popup.isVisible()) {
			Point location = label.getLocationOnScreen();
			view.popup.setLocation(location.x, location.y - label.getHeight());
			view.usePopup(item.getDescription());
			view.popup.setVisible(true);
		}
	}

	/**
	 * Handles when the mouse leaves the card, restoring its previous display mode.
	 * 
	 * @param e The mouse event triggered when leaving the card.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label.setEnabled(true);
		view.popup.setVisible(false);
	}

	/**
	 * Handles card selection when clicked, updating the UI and notifying the controller.
	 * 
	 * @param e The mouse event triggered when the card is clicked.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		//TODO what happens when you click on a dice
		controller.chooseItem(item);
	}
}




