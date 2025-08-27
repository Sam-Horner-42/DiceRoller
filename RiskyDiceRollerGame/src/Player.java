
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    public final int maxDice = 20;
    private int strengthLevel; // will be used to determine difficulty of neighbouring tiles
    private int diceCount;
    private int totalDamage;
    private int totalDefense;

    private ArrayList<Die> playerDice; // the dice the player currently has
    private ArrayList<Die> selectedDice = new ArrayList<>(); // the currently selected dice to be rolled
     
    public Player(int diceCount){
        this.diceCount = diceCount; // total number of dice is amount of dice in the player inventory
        this.playerDice = new ArrayList<>(); // all the dice currently in inventory
        this.selectedDice = new ArrayList<>(); // all the dice the player has selected to roll
    }

    public int getStrengthLevel(){
        return this.strengthLevel;
    }
    public void setStrengthLevel(int strengthLevel){
        this.strengthLevel = strengthLevel;
    }

    public void addStarterDice(){
        Die starterAttackDie = new Die("", 6, "Attack", false, false);
        Die starterDefenseDie = new Die("", 4, "Defense", false, false);
        for(int i = 0; i<2; i++){
            playerDice.add(starterAttackDie);
            playerDice.add(starterDefenseDie);
        } 
    }

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

    /* Adds to the selected dice ArrayList */
    public void selectDice(int index){
        selectedDice.add(playerDice.get(index));
    }

    /* Remove the deselected dice from the selected dice ArrayList */
    public void deselectDice(int index){
        selectedDice.remove(index);
    }

    /* Roll all the selected dice */
    public void rollDice(ArrayList<Die> selectedDice){
        for(Die i: selectedDice){
            i.rollDie(i);
        }
    }
}
