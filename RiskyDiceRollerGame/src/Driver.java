public class Driver {
    public static void main(String[] args) {
        Gooey gooey = new Gooey();
        gooey.initializeMainFrame();

        Model model = new Model();
        model.addStarterDice();
        model.selectDice(2);
        model.selectDice(2);
        System.out.println(model.getTotalDamage());
 
    }
}
