public class Milk extends Item {
    public Milk() { super("milk", "Doubles your score, every cookie is better with milk"); }

    @Override
    public void use(IntWrapper total) {
        total.value *= 2;
        System.out.println("After Milk: " + total.value);
    }
}
