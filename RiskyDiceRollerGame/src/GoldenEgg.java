public class GoldenEgg extends Item {
    public GoldenEgg() { super("goldenEgg", "Always roll the max on every die, this goose lays a golden egg every time."); }

    @Override
    public void use(IntWrapper total) {
        total.value += 0;
        System.out.println("After Golden Egg: " + total.value);
    }
}
