public class Driver {
    public static void main(String[] args) {

        startGame();
 
    }

    public static void startGame(){
        Gooey gooey = new Gooey();

        Model model = new Model();

        Controller controller = new Controller();
        controller.setModel(model);
        controller.setGooey(gooey);

        gooey.setController(controller);
        gooey.setModel(model);
        model.setView(gooey);
        
        model.genLevels();

        controller.makeMapsAndList();
        controller.populateLevelMap();

        controller.addStarterDice();

        gooey.initializeMainFrame();

        gooey.updateDiceZone();
    }
}
