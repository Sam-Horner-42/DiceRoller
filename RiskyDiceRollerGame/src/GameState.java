public class GameState {
    
    /* Provides functionality depending on the state the game is in */
    void mainMenu(){
        System.out.println("The game has started");
        newGame();
    }

    void newGame(){
        Player player = new Player(0);
        player.addStarterDice();
        play();
    }

    void play(){
        Logic logic = new Logic();
    }

    void gameOver(){

    }
}
