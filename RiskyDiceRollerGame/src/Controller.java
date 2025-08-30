import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Controller implements ActionListener {
	
	//TODO add a map to link Jlabels with levels
	private Model model;
	private Gooey gooey;
	Sound sound = new Sound();
	private HashMap<JLabel, Level> levels;
	private ArrayList<Level> levelData;

	private ArrayList<Die> playerDice; // the dice the player currently has
	private ArrayList<Die> selectedDice; // the currently selected dice to be rolled

	
	// Getters and Setters
	public Model getModel() {
		return model;
	}

	public Gooey getGooey() {
		return gooey;
	}


	public HashMap<JLabel, Level> getLevels() {
		return levels;
	}

	public void setLevels(HashMap<JLabel, Level> levels) {
		this.levels = levels;
	}

	public ArrayList<Level> getLevelData() {
		return levelData;
	}

	public void setLevelData(ArrayList<Level> levelData) {
		this.levelData = levelData;
	}


	public void setPlayerDice(ArrayList<Die> playerDice) {
		this.playerDice = playerDice;
	}

	public ArrayList<Die> getSelectedDice() {
		return selectedDice;
	}

	public void setSelectedDice(ArrayList<Die> selectedDice) {
		this.selectedDice = selectedDice;
	}
	
	
	

	public void setModel(Model model){
		this.model = model;
	}

	public void setGooey(Gooey gooey){
		this.gooey = gooey;
	}

	public ArrayList<Die> getPlayerDice(){
		return model.getPlayerDice();
	}
	
	// will call model's add dice method
	public void chooseDice(Die die) {
		if(!gooey.mapOnScreen){
			if (!die.getIsSelected()) 
				model.selectDice(die);
			else 
				model.deselectDice(die);

			// Always update the displayed (single!) view here:
			gooey.updateDiceZone();
			gooey.updateSelectedDice();
		}
			
	}
	
	public void chooseItem(Item item) {
		if(!gooey.mapOnScreen){
			if (!item.getIsSelected()) 
				model.selectItem(item);
			else 
				model.deselectItem(item);

			// Always update the displayed (single!) view here:
			gooey.updateItemZone();
			gooey.updateSelectedItem();
		}
			
	}

	public void updatePossibleRange(){
		//TODO add functionality to display possible range based on selected dice
	}

	public void goBack(){
		model.deselectAll();
		gooey.changeMainArea();
		gooey.updateDiceZone();
		gooey.updateSelectedDice();
		gooey.updateItemZone();
		gooey.updateSelectedItem();
		gooey.updateRanges(0, 0);
		
	}

	public void playSE(int i){
		sound.setFile(i);
		sound.play();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command){
			case "Roll":
				playSE(0);
				model.startCombat();
				break;
			case "Back":
				goBack();
				break;
			default:
				System.out.println("This is not a button.");
		}
	}

}
