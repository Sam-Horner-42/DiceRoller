public class Milk extends Item {
    public Milk() { super("milk", "Milk, adds a +4, every cookie is better with milk"); }

    @Override
    public void use(IntWrapper total) {
        total.value += 4;
        System.out.println("After Milk: " + total.value);
    }
}
