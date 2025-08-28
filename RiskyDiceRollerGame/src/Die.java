import java.util.*;

public class Die implements Comparable<Die>{
    
    private boolean rolled; // determines if this specific dice instance has already been rolled
    private String dieType; // Attack 'A' or defense 'D' (potential for more types)
    private int numSides; // specifies total number of sides on a single dice
    private boolean isSpecialDice; // determines whether a dice is special or not
    private String name;

    public boolean isRolled() {
        return rolled;
    }

    public void setRolled(boolean rolled) {
        this.rolled = rolled;
    }

    public String getDieType() {
        return dieType;
    }

    public void setDieType(String dieType) {
        this.dieType = dieType;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public boolean isSpecialDice() {
        return isSpecialDice;
    }

    public void setSpecialDice(boolean isSpecialDice) {
        this.isSpecialDice = isSpecialDice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Constructs a single dice for use
     */
    public Die(String name, int numSides, String dieType, boolean isSpecialDice, boolean rolled){
        this.name = generateDieName(numSides, dieType, isSpecialDice, rolled); // dynamically generates name based on params
        this.numSides = numSides;
        this.isSpecialDice = isSpecialDice;
        this.rolled = rolled;
        this.dieType = dieType;
    }
    
    /* Sort the dice by their number of sides, from smallest to largest */
    @Override
    public int compareTo(Die other){
        return Integer.compare(this.numSides, other.numSides);
    }

    /* 
    Dynamically generates a die name based on its parameters 
    Will need to add further logic for special dice
    */
    public String generateDieName(int numSides, String dieType, boolean isSpecialDice, boolean rolled){
        String dieName = "";
        if(isSpecialDice){
            //TODO create naming logic for specialty dice
        }else {
            dieName += "Standard ";
        }
        dieName += numSides + "-Sided " + dieType + " Die ";
        return dieName;
    }

    /*
    rolls a die using numSides and random, the result is the side of the dice that was rolled
    */ 
    public int rollDie(Die die) {
        Random random = new Random();
        int roll = random.nextInt(die.numSides)+1; // +1 prevents 0 result   
        System.out.println(die.name + " rolled: " + roll); 
        return roll;
    }


    @Override
    public String toString(){
        String string = "";
        string += "Name: " + name;
        string += "\nNumber of Sides: " + numSides;
        string += "\nDie Type: " + dieType;
        string += "\nRolled: " + rolled;
        string += "\nSpecial: " + isSpecialDice;
        string += "\n";
        return string;
    }
}
