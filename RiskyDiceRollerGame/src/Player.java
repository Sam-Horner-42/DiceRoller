
import java.util.ArrayList;

public class Player {
    public final int maxDice = 20;
    private int strengthLevel; // will be used to determine difficulty of neighbouring tiles
    private int diceCount;
    private ArrayList<Die> playerDice = new ArrayList<>(); // the dice the player currently has

    
    public Player(int diceCount){
        this.diceCount = diceCount;
    }

    public int getStrengthLevel(){
        return this.strengthLevel;
    }
    public void setStrengthLevel(int strengthLevel){
        this.strengthLevel = strengthLevel;
    }

    public void addStarterDice(){
        Die starterAttackDie = new Die(6, 'A', false, false);
        Die starterDefenseDie = new Die(6, 'D', false, false);
        for(int i = 0; i<2; i++){
            playerDice.add(starterAttackDie);
            playerDice.add(starterDefenseDie);
        }
        diceCount += 4;
            
    }
}
