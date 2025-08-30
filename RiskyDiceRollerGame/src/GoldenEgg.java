public class GoldenEgg extends Item {
    public GoldenEgg() { super("goldenEgg", "A golden egg, doubles your score"); }

    @Override
    public void use(IntWrapper total) {
        total.value *= 2;
        System.out.println("After Golden Egg: " + total.value);
    }
}
