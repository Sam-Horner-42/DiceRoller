import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Controller implements ActionListener {
	
	//TODO add a map to link Jlabels with levels
	private Model model;
	private Gooey gooey;
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
	
	public void makeMapsAndList(){
		levels = model.getLevels();
		levelData = model.getLevelData();

		playerDice = model.getPlayerDice();
		selectedDice = model.getSelectedDice();
	}
	

	public void populateLevelMap(){
		// chocolate chip islands
		levels.put(gooey.chocoChip1, levelData.get(0));
		levels.put(gooey.chocoChip2, levelData.get(1));
		levels.put(gooey.chocoChip3, levelData.get(2));
		levels.put(gooey.chocoChip4, levelData.get(3));

		
		levels.put(gooey.macaron1, levelData.get(4));
		levels.put(gooey.macaron2, levelData.get(5));
		levels.put(gooey.macaron3, levelData.get(6));

		levels.put(gooey.fudge1, levelData.get(7));
		levels.put(gooey.fudge2, levelData.get(8));
		levels.put(gooey.fudge3, levelData.get(9));

		levels.put(gooey.peanut_cookie1, levelData.get(10));
		levels.put(gooey.peanut_cookie2, levelData.get(11));
		levels.put(gooey.peanut_cookie3, levelData.get(12));

		levels.put(gooey.red_jelly1, levelData.get(13));
		levels.put(gooey.red_jelly2, levelData.get(14));
		levels.put(gooey.red_jelly3, levelData.get(15));
	}

	
	/* Adds 2 6-sided attack die, and 2 4-sided defense die */
    public void addStarterDice(){
        Die starterD6 = new Die("", 6, "", false);
        Die starterD4 = new Die("", 4, "", false);
        for(int i = 0; i < 6; i++) { 
            playerDice.add(starterD6);
            playerDice.add(starterD4);
        } 
        Collections.sort(playerDice);

		gooey.updateDiceZone();
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
	public void chooseDice(Die dice) {
		if(!dice.getIsSelected()) {
		model.selectDice(dice);
		}
		else {
		model.deselectDice(dice);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch(command){
			case "Roll":
				model.rollDice();
				break;
			case "Back":
				gooey.changeMainArea();
				break;
			default:
				System.out.println("Fuck you.");
		}
	}

}
