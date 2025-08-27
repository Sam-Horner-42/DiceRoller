import static java.lang.System.exit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameState {
    Player player;

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

    private int minRange; // class level variables for every round of combat
    private int maxRange;

    public GameState() {
        scanner = new Scanner(System.in);
    }

    
    /* Provides functionality depending on the state the game is in */
    void mainMenu(){
        processMainMenu();
        newGame();
    }

    void newGame(){
        player = new Player(0);
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

    /* Displays tutorial instructions */
    public void tutorial(){
        System.out.println("\nThe goal of the game is to conquer all of the territories.");
        System.out.println("To conquer a territory you must roll within the correct range.");
        System.out.println("Attack dice add to your total.");
        System.out.println("Defensive dice increase your safe range.");
        System.out.println("You currently have 4 dice.");
        System.out.println("You can roll up to 5 in a single turn.");
        System.out.println("Select one of your 6-Sided Attack Dice\n");
        minRange = 1;
        maxRange = 6;
        combatHandler();
        
    }

    /* Ran at the beginning of every round of combat, sets up combat based on min and max range, and resets min and max when finished */
    public void combatHandler(){
        int option = 0;
        while (option != EXIT) {
            try {
                diceSelector(minRange, maxRange);
                option = scanner.nextInt();
                processDiceOption(option);
            } catch (InputMismatchException | NumberFormatException e) { //accounts for anything other than an integer
                scanner.nextLine(); //consume invalid input
                System.out.println("...Invalid input. Please enter a valid number...");
            }
        }
        // reset min and max ranges
        minRange = 0;
        maxRange = 0;
    }

    /* Displays all current player dice and provides a method to select a single die */
    void diceSelector(int minRange, int maxRange){
        player.displayPlayerDice();
        displayRange(minRange, maxRange);
        System.out.print("\nSelect the dice you wish to roll by Index: ");
    }

    /**
     * Executes the action based on the user's selected main menu option.
     *
     * @param option the menu option selected by the user.
     */
    private void processDiceOption(int option)
    {
        player.selectDice(option);
        player.displaySelectedDice();
        processRoll();
    }
    
    /* Prompts the user to roll the dice or not */
    private void promptRoll()
    {
        System.out.println("Would you like to roll these dice? (y/n)");
    }

    /* provides user with prompt above and handles input */
    public void processRoll() {
        String option = "";
        while (!option.equalsIgnoreCase("exit")) {
            try {
                promptRoll();
                scanner = new Scanner(System.in);
                option = scanner.nextLine();
                yesOrNo(option);
            } catch (InputMismatchException | NumberFormatException e) { //accounts for anything other than an integer
                scanner.nextLine(); //consume invalid input
                System.out.print("Please say yes or no to continue. Or type exit to quit.");
            }
        }
    }

    /* Prompts for yes or no */
    private void yesOrNo(String option)
    {
       switch(option.toLowerCase()) {
            case "yes", "y", "ye", "yuh", "yeah", "ok":
                player.rollDice();
                if(combatResult(player.getTotalDamage(), player.getTotalDefense(), minRange, maxRange)){
                    System.out.println("Success!");
                } else {
                    System.out.println("Failure :(");
                }
                // reset ranges
                minRange = 0;
                maxRange = 0;    
                break;
            case "no", "nope", "n", "nuh-uh", "nah", "exit":
                return; // allow the user to select more dice
            default:
                System.out.println("...Invalid option. Please try again...");
        }
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

    void displayRange(int min, int max){
        System.out.println("Roll Between: " + min + " and " + max);
    }

    /*
    checks if the player rolled between the ranges accounting for the defense buffer
    */
    public boolean combatResult(int attackTotal, int defenseTotal, int minRange, int maxRange) {
        return (attackTotal > (minRange - defenseTotal) || attackTotal < (maxRange + defenseTotal));
    }  

    
}
