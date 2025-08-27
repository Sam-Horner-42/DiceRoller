public class GameState {
    
    /* Provides functionality depending on the state the game is in */
    void mainMenu(){
        System.out.println("The game has started");
    }

    void newGame(){
        Player player = new Player(3);
        play();
    }

    void play(){

    }

    void gameOver(){

    }
}
