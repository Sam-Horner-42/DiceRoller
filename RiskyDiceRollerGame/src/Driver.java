public class Driver {
    public static void main(String[] args) {
        Gooey gooey = new Gooey();
        gooey.initializeMainFrame();
        Dice die = new Dice();
        for(int i=0; i<10; i++){
            int roll = die.rollDice(6);
            System.out.println("Rolled: " + roll);
        }
        
    }
}
