public class ChocolateCoin extends Item {
    public ChocolateCoin() { super("coin", "A Chocolate Coin add a +2 to your roll."); }

    @Override
    public void use(IntWrapper total) {
        total.value = 2;

    }
}
