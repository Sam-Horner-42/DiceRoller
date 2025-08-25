import java.util.*;

public class Dice {
    
    /*
    rolls a die using numSides and random, the result is the side of the dice that was rolled
    */ 
    public int rollDice(int numSides) {
        Random random = new Random();
        int roll = random.nextInt(numSides)+1; // +1 prevents 0 result    
        return roll;
    }

    //checks if the player rolled between the ranges accounting for the defense buffer
    public boolean combatResult(int defenseTotal, int attackTotal, int minRange, int maxRange) {
        return (attackTotal > (minRange - defenseTotal) || attackTotal < (maxRange + defenseTotal));
    }


}
