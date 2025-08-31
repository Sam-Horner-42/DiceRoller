import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JLabel;

public class Model {
    
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

    private int rerolls = countSelectedWhisks();

    private Level currentLevel;
    
    public LevelMouseListener listener;

    Controller controller = new Controller();

    // Sets of enums to hold dice and item labels
    Die d4 = new Die("", 4, "", false);
    Die d6 = new Die("", 6, "", false);
    Die d8 = new Die("", 8, "", false);
    Die d20 = new Die("", 20, "", false);

    Item goldenEgg = new GoldenEgg(); 
    Item slotMachine = new SlotMachine();
    Item milk = new Milk(); 
    Item whisk = new Whisk();
    Item chocolateCoin = new ChocolateCoin(); 
    Item timer = new Timer();

    private Die[] rewardDice = {d4, d6, d8, d20};
    private ArrayList<Item> itemRewards = new ArrayList<>();
    private ArrayList<Die> dieRewards = new ArrayList<>();

    private ArrayList<Die> playerDice; // the dice the player currently has
    private ArrayList<Die> selectedDice; // the currently selected dice to be rolled
    //private ArrayList<Integer> wageredDice; // the dice wagered before combat begins, int for the index in player dice
    
    private ArrayList<Die> lostDice = new ArrayList<>();

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
        return playerDice.size();
    }
    
    public int getItemCount() {
        return playerItems.size();
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

    private Item newItemByIndex(int index) {
        return switch (index) {
            case 0 -> new GoldenEgg();
            case 1 -> new SlotMachine();
            case 2 -> new Milk();
            case 3 -> new Whisk();
            case 4 -> new ChocolateCoin();
            case 5 -> new Timer();
            default -> throw new IllegalArgumentException("Invalid item index: " + index);
        };
    }
    public void genLevels() {
        // String name, String defaultImgPath, String hoveredImgPath, int difficulty, boolean levelComplete, int minRange, int maxRange
        Level choco1 = new Level("Cookie Kingdom", "chocoChip", "chocoChipHovered","chocoChipLocked", 1, false, 1, 6, false);
        Level choco2 = new Level("Chocolate Chipago", "chocoChip", "chocoChipHovered", "chocoChipLocked", 1, false, 2, 8, true);
        Level choco3 = new Level("Orlandough", "chocoChip", "chocoChipHovered","chocoChipLocked", 1, false, 3, 9, true);
        Level choco4 = new Level("Bisconsin", "chocoChip", "chocoChipHovered", "chocoChipLocked", 2, false, 5, 12, true);
        
        Level macaron1 = new Level("Morrocaroon", "macaron", "macaronHovered", "macaronLocked", 2, false, 5, 10, true);
        Level macaron2 = new Level("Paristachio", "macaron", "macaronHovered", "macaronLocked", 2, false, 7, 10, true);
        Level macaron3 = new Level("Tokyogurt", "macaron", "macaronHovered", "macaronLocked", 3, false, 8, 10, true);
        
        Level checker1 = new Level("Orhio", "fudge", "fudgeHovered", "fudgeLocked",3, false, 9, 9, true);
        Level checker2 = new Level("Ottawafer", "fudge", "fudgeHovered", "fudgeLocked", 3, false, 7, 8, true);
        Level checker3 = new Level("Fudgisawa", "fudge", "fudgeHovered", "fudgeLocked", 4, false, 5, 6, true);
        
        Level peanutButter1 = new Level("Peanuttsburgh", "peanut_cookie", "peanut_cookieHovered", "peanut_cookieLocked", 4, false, 10, 12, true);
        Level peanutButter2 = new Level("PerthButter", "peanut_cookie", "peanut_cookieHovered", "peanut_cookieLocked", 4, false, 10, 11, true);
        Level peanutButter3 = new Level("Peanutsborough", "peanut_cookie", "peanut_cookieHovered", "peanut_cookieLocked", 5, false, 15, 17, true);
        
        Level jammyDodger1 = new Level("New Jampshire", "red_jelly", "red_jellyHovered", "red_jellyLocked", 5, false, 20, 25, true);
        Level jammyDodger2 = new Level("Boston Cream", "red_jelly", "red_jellyHovered", "red_jellyLocked", 5, false, 20, 22, true);
        Level jammyDodger3 = new Level("Toronto", "red_jelly", "red_jellyHovered", "red_jellyLocked", 6, false, 20, 20, true);

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

		levels.put(gooey.fudge1, levelData.get(9));
		levels.put(gooey.fudge2, levelData.get(8));
		levels.put(gooey.fudge3, levelData.get(7));

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
        playerItems = new ArrayList<>();
        selectedItems = new ArrayList<>();
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
		Item chocolateCoin = new ChocolateCoin(); 

		playerItems.add(chocolateCoin);


		gooey.updateDiceZone();
	}

    
    
    /* For debugging purposes only */
    public void addAllItems(){
        Item goldenEgg = new GoldenEgg(); 
		Item slotMachine = new SlotMachine();
        Item milk = new Milk(); 
		Item whisk = new Whisk();
        Item chocolateCoin = new ChocolateCoin(); 
		Item timer = new Timer();
        playerItems.add(goldenEgg);
		playerItems.add(slotMachine);
        playerItems.add(milk);
		playerItems.add(whisk);
        playerItems.add(chocolateCoin);
		playerItems.add(timer);

    }
	public void wager() {

	}

	/**
	 * Comabt always starts here Assigns current level based on ID passed in Sets up
	 * min and max range associated with the current level Resets totalDamage to 0
	 */
    public void startCombat(){
        if(selectedDice.isEmpty() && selectedItems.isEmpty()) return;
        controller.playSE(0);
        rerolls = countSelectedWhisks();
        totalDamage = 0; // for safety
        totalDamage = rollDice();
        
        boolean winLose = combatResult(totalDamage);
        handleResults(winLose);
        totalDamage = 0; // reset total damage
        
    }

    private int countSelectedWhisks() {
        int count = 0;
        if(selectedItems != null)
            for (Item it : selectedItems) if (it instanceof Whisk) count++;
        return count;
    }

    private boolean consumeOneSelectedWhisk() {
        for (int i = 0; i < selectedItems.size(); i++) {
            Item it = selectedItems.get(i);
            if (it instanceof Whisk) {
                // one-time use: remove it and DO NOT return it to inventory
                selectedItems.remove(i);
                it.setIsSelected(false);
                return true;
            }
        }
        return false;
    }
    /* Used to remove wagered dice/items */
    public void handleResults(boolean result) {
        selectedItems.clear();
        if(result){
            currentLevel.setIsComplete(true);
            if(levelData.indexOf(currentLevel) < 15){
                int nextLevelIndex = levelData.indexOf(currentLevel) + 1;
                levelData.get(nextLevelIndex).setIsLocked(false);

                deselectAll(); // deselect all currently selected dice and items
                Collections.sort(playerDice);

                reward(); 
            } else {
                gooey.winGame();
                return;
            }
            
        } else if (rerolls > 0) {
            consumeOneSelectedWhisk();
            startCombat();
        } else {
            if(playerDice.isEmpty()){
                //TODO lose screen
                gooey.loseGame();
                return;
            } else {
                controller.playSE(2);
                selectedDice.clear();
            }

        }
    	displayResults(result);
        gooey.updateDiceZone();
        gooey.updateSelectedDice();
        gooey.updateLabels();
        gooey.updateItemZone();
        gooey.updateSelectedItem();
    }

    /*
     * Used to update the Gooey with the relevant window
     */
    public void displayResults(boolean result){
        if (result) {
        	//TODO FINISH
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            
            controller.playSE(1); //Win sound
        	gooey.winDialog(totalDamage, dieRewards, itemRewards);
        	dieRewards.clear();
        	itemRewards.clear();
        } else {
        	gooey.loseDialog(totalDamage, lostDice);
        	lostDice.clear();

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

		if (selectedItems.size() < 3 && !item.getIsSelected()) {
			item.setIsSelected(true); // this dice is now selected
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
		if (item.getIsSelected()) {
			item.setIsSelected(false);
			playerItems.add(item);
			selectedItems.remove(item);

			potentialMin = calculatePotentialMinDamage();
			potentialMax = calculatePotentialMaxDamage();
			gooey.updateRanges(potentialMin, potentialMax);

        }
    }

    /* Deselects all the dice from the selected dice list */
    public void deselectAll() {
        if (selectedDice.isEmpty() && selectedItems.isEmpty()) return; // if there are no items and no dice

        if(!selectedDice.isEmpty()){
            // reset flags first
            for (Die d : selectedDice) d.setIsSelected(false);

            // move all, then clear once
            playerDice.addAll(selectedDice);
            selectedDice.clear();

            Collections.sort(playerDice);
        }

        if(!selectedItems.isEmpty()){
            // reset flags first
            for (Item i : selectedItems) i.setIsSelected(false);

            // move all, then clear once
            playerItems.addAll(selectedItems);
            selectedItems.clear();

        }

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
        if(selectedItems != null) {
            IntWrapper total = new IntWrapper(potentialMax);
            // Apply all items to total
            for (Item item : selectedItems) {
                if(!(item instanceof SlotMachine) && !(item instanceof GoldenEgg)){
                    item.use(total);
                    potentialMax = total.value;
                }  
            }
        }
        return potentialMax;
    }

    /* Calculate the potential minimum value of all the currently selected dice
     * Can be used with above method to display total potential range of the currently selected die
     */
    public int calculatePotentialMinDamage(){
        int potentialMin = 0;
        boolean goldenEgg = false;
        if(selectedItems != null){
            for (Item it : selectedItems) {
                if (it instanceof GoldenEgg) goldenEgg = true; 
            }      
        }       
        if(selectedDice != null) {
            for (Die die: selectedDice) {    
                if(goldenEgg){
                    potentialMin += die.getNumSides(); 
                } else {
                    potentialMin = selectedDice.size();
                } 
            }
        }
        if(selectedItems != null) {
            IntWrapper total = new IntWrapper(potentialMin);
            // Apply all items to total
            for (Item item : selectedItems) {
                if(!(item instanceof SlotMachine)){
                    item.use(total);
                    potentialMin = total.value;
                }
            }
        }
        return potentialMin;
    }

    /* Iterates through the array list of dice and returns the total calculated roll 
     * Will be called when the user selects ROLL
    */
    public int rollDice() {
    	
    	if (!lostDice.isEmpty()) {
			lostDice.clear();
		}
		int preItemTotal = 0;
        boolean goldenEgg = false;
        if(selectedItems != null){
            for (Item it : selectedItems) {
                if (it instanceof GoldenEgg) goldenEgg = true; 
                
            }
                

        } 
        if(selectedDice != null) {
            for (Die die: selectedDice) { 
            	    lostDice.add(die);
                if(goldenEgg){
                    preItemTotal += die.getNumSides();
                } else preItemTotal += rollDie(die);
            }
        }     
            
        IntWrapper total = new IntWrapper(preItemTotal);

        if(selectedItems != null){
            // Apply all items to total
            for (Item item : selectedItems) {
                if (item instanceof SlotMachine) {
                    IntWrapper slotRange = new IntWrapper(0);
                    item.use(slotRange);                
                    int delta = slotRange.value;        
                    System.out.println("Slot Range: " + delta);
                    currentLevel.setMaxRange(currentLevel.getMaxRange() + delta);
                    currentLevel.setMinRange(currentLevel.getMinRange() - delta);
                    System.out.println("New Max: " + currentLevel.getMaxRange());
                    System.out.println("New Min: " + currentLevel.getMinRange());
                } else {
                    item.use(total);
                }        
                
            }
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
        
        //Add 2 Common Items
        Random random = new Random();
        int randomAmount = random.nextInt(2) + 1;
        int giveItem = random.nextInt(3);

        // add 2 dice - d4/d6/d8
       
        if (playerDice.size() < 8) {
            if(playerDice.size() == 7 && randomAmount == 2) randomAmount--;
			for (int i = 0; i < randomAmount; i++) {
				int randomDice = random.nextInt(4);
				Die newDice = new Die(rewardDice[randomDice].getName(), rewardDice[randomDice].getNumSides(),
						rewardDice[randomDice].getFileName(), rewardDice[randomDice].getIsSelected());
				playerDice.add(newDice);
				dieRewards.add(newDice);
			} 
		}
		if (playerItems.size() < 6) {
			if (giveItem <= 1) {
				int randomItem = random.nextInt(6);
                
				if (playerItems.size() < 6) {
                    Item rewardItem = newItemByIndex(randomItem);
                    playerItems.add(rewardItem);
                    itemRewards.add(rewardItem);
				}
			} 
		}
		Collections.sort(playerDice);

		gooey.updateDiceZone();
    }

    public void restartGame(){
        playerDice.clear();
        selectedDice.clear();
        playerItems.clear();
        selectedItems.clear();

        genLevels();

        makeMapsAndList();
        populateLevelMap();
        
        addStarterDice();
        addStarterItems();
        //model.addAllItems();

        gooey.updateItemZone();
        gooey.updateSelectedItem();
        gooey.updateSelectedDice();
        gooey.updateDiceZone();
        gooey.updateLabels();
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
