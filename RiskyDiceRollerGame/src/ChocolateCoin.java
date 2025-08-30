public class ChocolateCoin extends Item {
    public ChocolateCoin() { super("coin", "A Chocolate Coin, add a +5 to your roll."); }

    @Override
    public void use(IntWrapper total) {
        total.value += 5;
        System.out.println("After Chocolate Coin: " + total.value);
    }
}
