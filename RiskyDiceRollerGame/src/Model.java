import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JLabel;

public class Model {
    
    Player player;
    Die die;
    Level level;
    private Gooey view;

    private final int maxDice = 20;
    private final int maxItems = 5;
    /* The players current strength level determined by number of dice and strenght of items */
    private int strengthLevel; // will be used to determine difficulty of neighbouring tiles
    /* Total amount of dice the player has */
    private int diceCount;
    private int totalDamage;
    private int potentialMin;
    private int potentialMax;

    

    public LevelMouseListener listener;

    // Sets of enums to hold dice and item labels
    private enum DICE{D4, D6, D8, D10, D12, D20}
    private enum COMMON_ITEMS{MIN, MAX, PLUS2, MINUS2}
    private enum UNCOMMON_ITEMS{}
    private enum RARE_ITEMS{}
    private enum STATE{MAP, LEVEL}

    private ArrayList<Die> playerDice; // the dice the player currently has
    private ArrayList<Die> selectedDice; // the currently selected dice to be rolled
    private ArrayList<Integer> wageredDice; // the dice wagered before combat begins, int for the index in player dice

    private ArrayList<Item> playerItems; // currently held items
    private ArrayList<Item> selectedItems; // items currently selected

    public HashMap<JLabel, Level> levels = new HashMap<>(); // stores all the different levels associated with their IDs
    public ArrayList<Level> levelData = new ArrayList<>(); 

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

    public void genLevels(){
        // String name, String defaultImgPath, String hoveredImgPath, int difficulty, boolean levelComplete, int minRange, int maxRange
        Level choco1 = new Level("choco1", "chocoChip", "chocoChipHovered", 1, false, 1, 6);
        Level choco2 = new Level("choco2", "chocoChip", "chocoChipHovered", 1, false, 2, 8);
        Level choco3 = new Level("choco3", "chocoChip", "chocoChipHovered", 1, false, 1, 6);
        Level choco4 = new Level("choco4", "chocoChip", "chocoChipHovered", 2, false, 1, 6);
        
        Level macaron1 = new Level("macaron1", "macaron", "macaronHovered", 2, false, 1, 6);
        Level macaron2 = new Level("macaron2", "macaron", "macaronHovered", 2, false, 1, 6);
        Level macaron3 = new Level("macaron3", "macaron", "macaronHovered", 3, false, 1, 6);
        
        Level checker1 = new Level("checker1", "fudge", "fudgeHovered", 3, false, 1, 6);
        Level checker2 = new Level("checker2", "fudge", "fudgeHovered", 3, false, 1, 6);
        Level checker3 = new Level("checker3", "fudge", "fudgeHovered", 4, false, 1, 6);
        
        Level peanutButter1 = new Level("peanutButter1", "peanut_cookie", "peanut_cookieHovered", 4, false, 1, 6);
        Level peanutButter2 = new Level("peanutButter2", "peanut_cookie", "peanut_cookieHovered", 4, false, 1, 6);
        Level peanutButter3 = new Level("peanutButter3", "peanut_cookie", "peanut_cookieHovered", 5, false, 1, 6);
        
        Level jammyDodger1 = new Level("jammyDodger1", "red_jelly", "red_jellyHovered", 5, false, 1, 6);
        Level jammyDodger2 = new Level("jammyDodger2", "red_jelly", "red_jellyHovered", 5, false, 1, 6);
        Level jammyDodger3 = new Level("jammyDodger3", "red_jelly", "red_jellyHovered", 6, false, 1, 6);

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

    /* When the player clicks PLAY */
    public void startGame(){
        addStarterDice(); // 2 D4s, 2 D6s
    }

    /* Adds 2 6-sided attack die, and 2 4-sided defense die */
    public void addStarterDice(){
        Die starterD6 = new Die("", 6, "");
        Die starterD4 = new Die("", 4, "");
        for(int i = 0; i < 2; i++){
            playerDice.add(starterD6);
            playerDice.add(starterD4);
        } 
        Collections.sort(playerDice);
    }

    public void wager(){

    }
    /** Comabt always starts here 
     * Assigns current level based on ID passed in
     * Sets up min and max range associated with the current level
     * Resets totalDamage to 0
    */
    public void startCombat(int levelId){
        Level currentLevel = levels.get(levelId);
        int minRange = level.getMinRange();
        int maxRange = level.getMaxRange();
        totalDamage = 0;
    }

    /* Adds a single die by index to the selected dice ArrayList and removes it from playerDice 
     * Updates potential max and potential min of this roll
    */
    public void selectCombatDice(int index) {
        if(selectedDice.size() < 5) {
            selectedDice.add(playerDice.get(index));
            playerDice.remove(index);
            potentialMin = calculatePotentialMinDamage();
            potentialMax = calculatePotentialMaxDamage();
        }   
        Collections.sort(selectedDice);
    }

    /* Removes a single deselected die from the selected dice ArrayList and place it back in playerDice 
    *  Updates potential max and potential min of this roll
    */
    public void deselectCombatDice(int index){
        playerDice.add(selectedDice.get(index));
        selectedDice.remove(index);
        potentialMin = calculatePotentialMinDamage();
        potentialMax = calculatePotentialMaxDamage();
        Collections.sort(playerDice);
    }

    /* Calculates total potential damage based on all the currently selected dice */
    public int calculatePotentialMaxDamage(){
        int potentialMax = 0;
        if(selectedDice != null) {
            for(int i = 0; i < selectedDice.size(); i++) {
                Die die = selectedDice.get(i);
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
            for(int i = 0; i < selectedDice.size(); i++) {
                potentialMin++;
            }
        }
        return potentialMin;
    }

    /* Iterates through the array list of dice and returns the total calculated roll 
     * Will be called when the user selects ROLL
    */
    public void rollDice() {
        int result = 0;
        for (int i = 0; i < playerDice.size(); i++) {
            Die die = selectedDice.get(i);
            result += rollDie(die);
            }
        totalDamage = result;
        playerDice.addAll(selectedDice); // put all the selected dice back in the player dice
        selectedDice.removeAll(selectedDice); // remove all the selected dice
        Collections.sort(playerDice);
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
    public boolean combatResult(int attackTotal, int minRange, int maxRange) {
        return (attackTotal > minRange && attackTotal < maxRange);
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
