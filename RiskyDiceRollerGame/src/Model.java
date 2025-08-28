import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Model {
    
    Player player;
    Die die;
    Level level;
    private Gooey view;

    public final int maxDice = 20;
    private int strengthLevel; // will be used to determine difficulty of neighbouring tiles
    private int diceCount;
    private int totalDamage;
    private int totalDefense;
    public LabelMouseListener listeners;

    // Sets of enums to hold dice and item labels
    private enum DICE {D4, D6, D8, D10, D12, D20}
    private enum COMMON_ITEMS{MIN, MAX, PLUS2, MINUS2}
    private enum UNCOMMON_ITEMS{}
    private enum RARE_ITEMS{}

    private ArrayList<Die> playerDice; // the dice the player currently has
    private ArrayList<Die> selectedDice; // the currently selected dice to be rolled
    private HashMap<String, Level> levels; // stores all the different levels associated with their IDs
    
    /*  */
    public Model(int diceCount){
        this.diceCount = diceCount; // total number of dice is amount of dice in the player inventory
        this.playerDice = new ArrayList<>(); // all the dice currently in inventory
        this.selectedDice = new ArrayList<>(); // all the dice the player has selected to roll
    }

    public int getStrengthLevel() {
        return this.strengthLevel;
    }

    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    public int getTotalDamage(){
        return this.totalDamage;
    }
    public void setTotalDamage(int damage){
        totalDamage = damage;
    }
    public int getTotalDefense(){
        return this.totalDefense;
    }
    public void setTotalDefense(int defense){
        totalDefense = defense;
    }

    public void startCombat(int levelId){
        //TODO get level by ID, move to that level
        Level currentLevel = levels.get(levelId);
        int minRange = level.getMinRange();
        totalDamage = 0;
    }
    /* Ran at the beginning of every round of combat, sets up combat based on min and max range, and resets min and max when finished */
    public void combatHandler(){
        selectDice(maxDice);
    }

    /* Adds to the selected dice ArrayList and removes it from playerDice */
    public void selectDice(int index) {
        if(selectedDice.size() < 5) {
            selectedDice.add(playerDice.get(index));
            playerDice.remove(index);
        }   
    }

    /* Remove the deselected dice from the selected dice ArrayList and place it back in playerDice */
    public void deselectDice(int index){
        playerDice.add(selectedDice.get(index));
        selectedDice.remove(index);
    }

    /* Roll all the selected dice */
    public int rollDice() {
        int result = 0;
        for(Die i: selectedDice){
            result = rollDie(i);
        }
        return result;
    }
    
    /*
    rolls a die using numSides and random, the result is the side of the dice that was rolled
    */ 
    public int rollDie(Die die) {
        Random random = new Random();
        int roll = random.nextInt(die.getNumSides())+1; // +1 prevents 0 result   
        System.out.println(die.getName() + " rolled: " + roll); 
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

    /* Adds 2 6-sided attack die, and 2 4-sided defense die */
    public void addStarterDice(){
        Die starterD6 = new Die("", 6, "");
        Die starterD4 = new Die("", 4, "");
        for(int i = 0; i < 2; i++){
            playerDice.add(starterD6);
            playerDice.add(starterD4);
        } 
    }

    /* Displays all the player dice with index */
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

    /* Displays all the currently selected dice by index */
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

    
    /* Provides functionality depending on the state the game is in */
    void mainMenu(){
        
    }

    void play(){
        
    }

    void gameOver(){

    }

    void win(){

    }

    

    

    
}
