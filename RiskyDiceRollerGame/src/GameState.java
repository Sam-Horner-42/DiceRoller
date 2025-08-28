
public class GameState {
    Player player;

    public GameState() {
        
    }

    /* Provides functionality depending on the state the game is in */
    void mainMenu(){
        
    }

    void newGame(){
        
    }

    void continueGame(){

    }

    void options(){

    }

    void stats(){

    }

    void play(boolean isNewGame){
        
    }

    void gameOver(){

    }


    /* Ran at the beginning of every round of combat, sets up combat based on min and max range, and resets min and max when finished */
    public void combatHandler(){
        
    }

    /*
    checks if the player rolled between the ranges accounting for the defense buffer
    */
    public boolean combatResult(int attackTotal, int defenseTotal, int minRange, int maxRange) {
        return (attackTotal > (minRange - defenseTotal) || attackTotal < (maxRange + defenseTotal));
    }  

    
}
