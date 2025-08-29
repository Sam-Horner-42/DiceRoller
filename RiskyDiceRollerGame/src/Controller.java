import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Controller implements ActionListener {
	
	//TODO add a map to link Jlabels with levels
	private Model model;
	private Gooey gooey;
	HashMap<JLabel, Level> levels;
	ArrayList<Level> levelData;
	
	public void makeMapsAndList(){
		levels = model.getLevels();
		levelData = model.getLevelData();
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


	public void setModel(Model model){
		this.model = model;
	}

	public void setGooey(Gooey gooey){
		this.gooey = gooey;
	}

	public ArrayList<Die> getPlayerDice(){
		return model.getPlayerDice();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
