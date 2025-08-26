import java.util.*;

public class Die {
    private final char DEFENSE_DIE = 'D';
    private final char ATTACK_DIE = 'A'; 

    private boolean rolled; // determines if this specific dice instance has already been rolled
    private char dieType; // Attack 'A' or defense 'D'
    private int numSides; // specifies total number of sides on a single dice
    private boolean isSpecialDice; // determines whether a dice is special or not

    /*
     * Constructs a single dice for use
     */
    public Die(int numSides, char dieType, boolean isSpecialDice, boolean rolled){
        numSides = this.numSides;
        isSpecialDice = this.isSpecialDice;
        rolled = this.rolled;
        dieType = this.dieType;
    }
    
    /*
    rolls a die using numSides and random, the result is the side of the dice that was rolled
    */ 
    public int rollDie(Die die) {
        Random random = new Random();
        int roll = random.nextInt(die.numSides)+1; // +1 prevents 0 result    
        return roll;

    }

    /*
    checks if the player rolled between the ranges accounting for the defense buffer
    */
    public boolean combatResult(int defenseTotal, int attackTotal, int minRange, int maxRange) {
        return (attackTotal > (minRange - defenseTotal) || attackTotal < (maxRange + defenseTotal));
    }
    
    public int reward(int difficultyLevel){
        return 0;
    }


}
