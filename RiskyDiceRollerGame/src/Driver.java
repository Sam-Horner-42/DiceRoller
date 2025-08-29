public class Driver {
    public static void main(String[] args) {

        Gooey gooey = new Gooey();

        Model model = new Model();

        Controller controller = new Controller();
        controller.setModel(model);
        controller.setGooey(gooey);

        gooey.setController(controller);
        model.genLevels();
        controller.makeMapsAndList();
        controller.populateLevelMap();
        gooey.initializeMainFrame();
        gooey.updateDiceZone();

        model.addStarterDice();
        System.out.println("Dice @ Start " + model.getPlayerDice());
        model.selectCombatDice(2);
        model.selectCombatDice(1);
        System.out.println("Player Dice After Selected: " + model.getPlayerDice());
        System.out.println("Selected Dice After Selected: " + model.getSelectedDice());
        
        System.out.println("Potential Min Range for Selected: " + model.getPotentialMin());
        System.out.println("Potential Max Range for Selected: " + model.getPotentialMax());

        model.rollDice();
        System.out.println("Total Roll Damage After Roll: " + model.getTotalDamage());
        System.out.println("Player Dice After Roll: " + model.getPlayerDice());
        
 
    }
}
