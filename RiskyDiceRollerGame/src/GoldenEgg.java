public class GoldenEgg extends Item {
    public GoldenEgg() { super("goldenEgg", "A golden egg, always roll the max on every die"); }

    @Override
    public void use(IntWrapper total) {
        total.value += 0;
        System.out.println("After Golden Egg: " + total.value);
    }
}
