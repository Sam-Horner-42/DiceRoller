public class Whisk extends Item {
    public Whisk() { super("whisk", "Mix it UP! If you lose, automatically roll again, one time use."); }

    @Override
    public void use(IntWrapper total) {
        total.value = 0;
        System.out.println("After Whisk: " + total.value);
    }
}
