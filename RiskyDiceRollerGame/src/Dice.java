import java.util.*;

public class Dice {
    private boolean rolled;
    private int numSides;
    private int result;

    /*
        rolls a die using numSides and random, the result is the side of the dice that was rolled
     */ 
    public int rollDice(int numSides) {
        Random random = new Random();
        int roll = random.nextInt(numSides)+1; // +1 prevents 0 result    
        return roll;
    }



}
