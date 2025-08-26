public class Driver {
    public static void main(String[] args) {
        Gooey gooey = new Gooey();
        gooey.initializeMainFrame();
        Die die = new Die(6, false, false);
        for(int i=0; i<10; i++){
            int roll = die.rollDie(die);
            System.out.println("Rolled: " + roll);
        }
        
    }
}
