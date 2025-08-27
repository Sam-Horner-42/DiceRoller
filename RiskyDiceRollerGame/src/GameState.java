import static java.lang.System.exit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameState {
    /** A static Scanner instance used for reading input from the user. */
    private static Scanner scanner;

    /**
     * Represents the menu option for initializing the array of integers.
     */
    private static final int NEW_GAME = 1;

    /**
     * Represents the menu option for performing a recursive binary search.
     */
    private static final int CONTINUE = 2;

    /**
     * Represents the menu option for performing a recursive linear search.
     */
    private static final int STATS = 3;

    /**
     * Represents the menu option for sorting an array by accessing the submenu.
     */
    private static final int OPTIONS = 4;

    /**
     * Represents the menu option for exiting the program.
     */
    private static final int EXIT = 5;
    /* Provides functionality depending on the state the game is in */
    void mainMenu(){
        processMainMenu();
        newGame();
    }

    void newGame(){
        Player player = new Player(0);
        player.addStarterDice();
        tutorial();
        play(true);
    }

    void continueGame(){

    }

    void options(){

    }

    void stats(){

    }

    void play(boolean isNewGame){
        if(isNewGame){
            tutorial();
        } else {
            
        }
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

        int option = 0;
        while (option != EXIT) {
            try {
                diceSelector();
                option = scanner.nextInt();
                processMainOption(option);
            } catch (InputMismatchException | NumberFormatException e) { //accounts for anything other than an integer
                scanner.nextLine(); //consume invalid input
                System.out.println("...Invalid input. Please enter a valid number...");
            }
        }
    }

    void diceSelector(){
        System.out.println("\nSelect your option in the menu below:");
        
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMainMenu()
    {
        System.out.println("\nSelect your option in the menu below:");
        System.out.println("1: New Game");
        System.out.println("2: Continue");
        System.out.println("3: Stats");
        System.out.println("4: Options");
        System.out.println("5: Quit");
        System.out.print("> ");
    }

    /**
     * Handles the main program loop, continuously prompting the user for a menu option.
     */
    public void processMainMenu() {
        int option = 0;
        while (option != EXIT) {
            try {
                displayMainMenu();
                option = scanner.nextInt();
                processMainOption(option);
            } catch (InputMismatchException | NumberFormatException e) { //accounts for anything other than an integer
                scanner.nextLine(); //consume invalid input
                System.out.println("...Invalid input. Please enter a valid number...");
            }
        }
    }

    /**
     * Executes the action based on the user's selected main menu option.
     *
     * @param option the menu option selected by the user.
     */
    private void processMainOption(int option)
    {
        switch(option){
            case NEW_GAME:
                newGame();
                break;
            case CONTINUE:
                continueGame();
                break;
            case OPTIONS:
                options();
                break;
            case STATS:
                
                break;
            case EXIT:
                System.out.println("Exiting, Thanks For Playing!");
                exit(0);
                break;
            default:
                System.out.println("...Invalid option. Please try again...");
        }
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
