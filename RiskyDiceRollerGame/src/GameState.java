public class GameState {
    
    /* Provides functionality depending on the state the game is in */
    void mainMenu(){
        System.out.println("The game has started");
        System.out.println("--  COOKIE CONQUEST!    --/n");
        newGame();
    }

    void newGame(){
        Player player = new Player(0);
        player.addStarterDice();
        tutorial();
        play();
    }

    void play(){
        
    }

    void gameOver(){

    }

    public void tutorial(){
        System.out.println("The goal of the game is to conquer all of the territories.");
        System.out.println("To conquer a territory you must roll within the correct range.");
        System.out.println("Attack die add to your total.");
        System.out.println("Defensive die increase your safe range.");
        System.out.println("You currently have 4 die.");
        System.out.println("You can roll up to 5 in a single turn.");
        System.out.println("Select the 6 sided attack die");
        
    }

    /*
    checks if the player rolled between the ranges accounting for the defense buffer
    */
    public boolean combatResult(int defenseTotal, int attackTotal, int minRange, int maxRange) {
        return (attackTotal > (minRange - defenseTotal) || attackTotal < (maxRange + defenseTotal));
    }  

    public void combatHandler(){

    }
}
