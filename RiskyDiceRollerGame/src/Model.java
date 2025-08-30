import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JLabel;

public class Model {
    
    Player player;
    Die die;
    Level level;
    private Gooey gooey;

    private final int maxDice = 20;
    private final int maxItems = 5;
    /* The players current strength level determined by number of dice and strenght of items */
    private int strengthLevel; // will be used to determine difficulty of neighbouring tiles
    /* Total amount of dice the player has */
    private int diceCount;
    private int totalDamage;
    
    private int potentialMin;
    private int potentialMax;

    private Level currentLevel;
    
    public LevelMouseListener listener;

    // Sets of enums to hold dice and item labels
    private enum DICE{D4, D6, D8, D10, D12, D20}
    private enum COMMON_ITEMS{MIN, MAX, PLUS2, MINUS2}
    private enum UNCOMMON_ITEMS{}
    private enum RARE_ITEMS{}
    private enum STATE{MAP, LEVEL}

    private ArrayList<Die> playerDice; // the dice the player currently has
    private ArrayList<Die> selectedDice; // the currently selected dice to be rolled
    //private ArrayList<Integer> wageredDice; // the dice wagered before combat begins, int for the index in player dice

    private ArrayList<Item> playerItems; // currently held items
    private ArrayList<Item> selectedItems; // items currently selected

    private HashMap<JLabel, Level> levels; // stores all the different levels associated with their IDs
    private ArrayList<Level> levelData; 

    /* Constructs the lists that store currently held and selected dice/items */
    public Model(){
        this.playerDice = new ArrayList<>(); // all the dice currently in inventory
        this.selectedDice = new ArrayList<>(); // all the dice the player has selected to roll
        this.playerItems = new ArrayList<>();
        this.selectedItems = new ArrayList<>();


    }


	// Getters and Setters
    public int getMaxDice() {
        return maxDice;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }

    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = totalDamage;
    }

    public int getPotentialMin() {
        return potentialMin;
    }

    public void setPotentialMin(int potentialMin) {
        this.potentialMin = potentialMin;
    }

    public int getPotentialMax() {
        return potentialMax;
    }

    public void setPotentialMax(int potentialMax) {
        this.potentialMax = potentialMax;
    }

    public LevelMouseListener getListener() {
        return listener;
    }

    public void setListener(LevelMouseListener listener) {
        this.listener = listener;
    }

    public ArrayList<Die> getPlayerDice() {
        return playerDice;
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

    public ArrayList<Item> getPlayerItems() {
        return playerItems;
    }

    public void setPlayerItems(ArrayList<Item> playerItems) {
        this.playerItems = playerItems;
    }

    public ArrayList<Item> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(ArrayList<Item> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public HashMap<JLabel, Level> getLevels() {
        return levels;
    }

    public void setLevels(HashMap<JLabel, Level> levels) {
        this.levels = levels;
    }

    public ArrayList<Level> getLevelData(){
        return levelData;
    }

    public void setLevelData(ArrayList<Level> levelData){
        this.levelData = levelData;
    }
    
    public void setView(Gooey gooey){
        this.gooey = gooey;
    }

    public void setCurrentLevel(Level currentLevel){
        this.currentLevel = currentLevel;
    }

    public Level getCurrentLevel(){
        return currentLevel;
    }

    public void genLevels(){
        // String name, String defaultImgPath, String hoveredImgPath, int difficulty, boolean levelComplete, int minRange, int maxRange
        Level choco1 = new Level("Cookie Kingdom", "chocoChip", "chocoChipHovered","chocoChipLocked", 1, false, 1, 6, false);
        Level choco2 = new Level("Death By Chocolate", "chocoChip", "chocoChipHovered", "chocoChipLocked", 1, false, 2, 8, true);
        Level choco3 = new Level("choco3", "chocoChip", "chocoChipHovered","chocoChipLocked", 1, false, 1, 6, true);
        Level choco4 = new Level("choco4", "chocoChip", "chocoChipHovered", "chocoChipLocked", 2, false, 1, 6, true);
        
        Level macaron1 = new Level("macaron1", "macaron", "macaronHovered", "macaronLocked", 2, false, 1, 6, true);
        Level macaron2 = new Level("macaron2", "macaron", "macaronHovered", "macaronLocked", 2, false, 1, 6, true);
        Level macaron3 = new Level("macaron3", "macaron", "macaronHovered", "macaronLocked", 3, false, 1, 6, true);
        
        Level checker1 = new Level("checker1", "fudge", "fudgeHovered", "fudgeLocked",3, false, 1, 6, true);
        Level checker2 = new Level("checker2", "fudge", "fudgeHovered", "fudgeLocked", 3, false, 1, 6, true);
        Level checker3 = new Level("checker3", "fudge", "fudgeHovered", "fudgeLocked", 4, false, 1, 6, true);
        
        Level peanutButter1 = new Level("peanutButter1", "peanut_cookie", "peanut_cookieHovered", "peanut_cookieLocked", 4, false, 1, 6, true);
        Level peanutButter2 = new Level("peanutButter2", "peanut_cookie", "peanut_cookieHovered", "peanut_cookieLocked", 4, false, 1, 6, true);
        Level peanutButter3 = new Level("peanutButter3", "peanut_cookie", "peanut_cookieHovered", "peanut_cookieLocked", 5, false, 1, 6, true);
        
        Level jammyDodger1 = new Level("jammyDodger1", "red_jelly", "red_jellyHovered", "red_jellyLocked", 5, false, 1, 6, true);
        Level jammyDodger2 = new Level("jammyDodger2", "red_jelly", "red_jellyHovered", "red_jellyLocked", 5, false, 1, 6, true);
        Level jammyDodger3 = new Level("jammyDodger3", "red_jelly", "red_jellyHovered", "red_jellyLocked", 6, false, 1, 6, true);

        levelData = new ArrayList<>();
        levelData.add(choco1);
        levelData.add(choco2);
        levelData.add(choco3);
        levelData.add(choco4);

        levelData.add(macaron1);
        levelData.add(macaron2);
        levelData.add(macaron3);
        
        levelData.add(checker1);
        levelData.add(checker2);
        levelData.add(checker3);

        levelData.add(peanutButter1);
        levelData.add(peanutButter2);
        levelData.add(peanutButter3);
        
        levelData.add(jammyDodger1);
        levelData.add(jammyDodger2);
        levelData.add(jammyDodger3);
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

	public void makeMapsAndList(){
		levels = new HashMap<>();

		playerDice = new ArrayList<>();
		selectedDice = new ArrayList<>();
	}
	/* Adds 2 6-sided attack die, and 2 4-sided defense die */
    public void addStarterDice(){
        
        for(int i = 0; i < 2; i++) { 
            playerDice.add(new Die("", 6, "", false));
            playerDice.add(new Die("", 4, "", false));
        } 
        Collections.sort(playerDice);

		gooey.updateDiceZone();
    }

	public void addStarterItems() {
		Item goldenEgg = new GoldenEgg(); 
		Item slotMachine = new SlotMachine();
		playerItems.add(goldenEgg);
		playerItems.add(slotMachine);


		gooey.updateDiceZone();
	}

	public void wager() {

	}

	/**
	 * Comabt always starts here Assigns current level based on ID passed in Sets up
	 * min and max range associated with the current level Resets totalDamage to 0
	 */
    public void startCombat(){
        totalDamage = rollDice();
        
        boolean winLose = combatResult(totalDamage);
        totalDamage = 0; // reset total damage
        handleResults(winLose);
        displayResults(winLose);
        
    }

    /* Used to remove wagered dice/items */
    public void handleResults(boolean result) {
        if(result){
            int nextLevelIndex = levelData.indexOf(currentLevel) + 1;
            levelData.get(nextLevelIndex).setIsLocked(false);

            deselectAll(); // deselect all currently selected dice
            Collections.sort(playerDice);

            reward();
        } else {
            selectedDice.clear();
        }
        gooey.updateDiceZone();
        gooey.updateSelectedDice();
        gooey.updateLabels();
    }

    /*
     * Used to update the Gooey with the relevant window
     */
    public void displayResults(boolean result){
        if (result) {
        	//TODO
            System.out.println("YOU WIN!");
        } else {
            System.out.println("YOU LOSE!");
        }
    }
    /* Adds a single die by index to the selected dice ArrayList and removes it from playerDice 
     * Updates potential max and potential min of this roll
    */
    public void selectDice(Die die) {
        
        if(selectedDice.size() < 5 && !die.getIsSelected()) {
            die.setIsSelected(true); // this dice is now selected
            selectedDice.add(die);
            playerDice.remove(die);

            potentialMin = calculatePotentialMinDamage();
            potentialMax = calculatePotentialMaxDamage();
			gooey.updateRanges(potentialMin, potentialMax);
			Collections.sort(selectedDice);
			Collections.sort(playerDice);

		}

	}

	public void selectItem(Item item) {

		if (selectedItems.size() < 3 && !item.isSelected()) {
			item.setSelected(true); // this dice is now selected
			selectedItems.add(item);
			playerItems.remove(item);

			potentialMin = calculatePotentialMinDamage();
			potentialMax = calculatePotentialMaxDamage();
			gooey.updateRanges(potentialMin, potentialMax);
		}

	}

	/*
	 * Removes a single deselected die from the selected dice ArrayList and place it
	 * back in playerDice Updates potential max and potential min of this roll
	 */
	public void deselectDice(Die die) {
		if (die.getIsSelected()) {
			die.setIsSelected(false);
			playerDice.add(die);
			selectedDice.remove(die);

			potentialMin = calculatePotentialMinDamage();
			potentialMax = calculatePotentialMaxDamage();
			gooey.updateRanges(potentialMin, potentialMax);

			Collections.sort(playerDice);
            Collections.sort(selectedDice);
        }
    }
	
	public void deselectItem(Item item) {
		if (item.isSelected()) {
			item.setSelected(false);
			playerItems.add(item);
			selectedItems.remove(item);

			potentialMin = calculatePotentialMinDamage();
			potentialMax = calculatePotentialMaxDamage();
			gooey.updateRanges(potentialMin, potentialMax);

        }
    }

    /* Deselects all the dice from the selected dice list */
    public void deselectAll() {
        if (selectedDice.isEmpty()) return;

        // reset flags first
        for (Die d : selectedDice) d.setIsSelected(false);

        // move all, then clear once
        playerDice.addAll(selectedDice);
        selectedDice.clear();

        Collections.sort(playerDice);

        // keep model state in sync
        potentialMin = 0;
        potentialMax = 0;
    }

    /* Calculates total potential damage based on all the currently selected dice */
    public int calculatePotentialMaxDamage(){
        int potentialMax = 0;
        if(selectedDice != null) {
            for(Die die: selectedDice) {
                potentialMax += die.getNumSides();
            }
        }
        return potentialMax;
    }

    /* Calculate the potential minimum value of all the currently selected dice
     * Can be used with above method to display total potential range of the currently selected die
     */
    public int calculatePotentialMinDamage(){
        int potentialMin = 0;
        if(selectedDice != null) {
            potentialMin = selectedDice.size();
        }
        return potentialMin;
    }

    /* Iterates through the array list of dice and returns the total calculated roll 
     * Will be called when the user selects ROLL
    */
    public int rollDice() {
        int preItemTotal = 0;
        for (Die die: selectedDice) {
        	preItemTotal += rollDie(die);
            }

        IntWrapper total = new IntWrapper(preItemTotal);

        // Apply all items to total
        for (Item item : selectedItems) {
            item.use(total);
        }

        totalDamage = total.value;
        return totalDamage;

    }
    
    /*
    rolls a die using numSides and random, the result is the side of the dice that was rolled
    */ 
    public int rollDie(Die die) {
        Random random = new Random();
        int roll = random.nextInt(die.getNumSides())+1; // +1 prevents 0 result 
        System.out.println("Roll: " + roll); // displaying what we rolled
        //System.out.println(die.getName() + " rolled: " + roll); 
        return roll;
    }

    /*
    checks if the player rolled between the ranges accounting for the defense buffer
    */
    public boolean combatResult(int attackTotal) {
        return (attackTotal >= currentLevel.getMinRange() && attackTotal <= currentLevel.getMaxRange());
    }  

    
    public void reward(){

    }

    
    /* Displays all the player dice with index 
     * Uses a for loop so we get every index, not just first occurence
    */
    public void displayPlayerDice(){
        if(playerDice != null){
            this.diceCount = playerDice.size();
            Collections.sort(playerDice);
            for (int i = 0; i < playerDice.size(); i++) {
                Die die = playerDice.get(i);
                System.out.println("Index: " + i);
                System.out.println(die);
            }
            System.out.println("Total Player Dice: " + diceCount);
        }
          
    }

    /* Displays all the currently selected dice by index
     * Uses a for loop so we get every index, not just first occurence
     */
    public void displaySelectedDice(){
        if(selectedDice != null) {
            Collections.sort(selectedDice);
            for (int i = 0; i < selectedDice.size(); i++) {
                Die die = selectedDice.get(i);
                System.out.println("Index: " + i);
                System.out.println(die);
            }
        }
          
    }

    
    
}
