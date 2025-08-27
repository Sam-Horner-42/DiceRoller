public class Driver {
    public static void main(String[] args) {
        Gooey gooey = new Gooey();
        gooey.initializeMainFrame();
        
        
        /*
        Die die = new Die(6, 'A',false, false);
        for(int i=0; i<10; i++){
            int roll = die.rollDie(die);
            System.out.println("Rolled: " + roll);
        }
        */
        Map tileMap = new Map();
        tileMap.buildTile(0); 


        
        
        
    }
}
