public class SlotMachine extends Item {
    public SlotMachine() { super("slotMachine", "A Slot Machine, always rolls Three 7s"); }

    @Override
    public void use(IntWrapper total) {
        total.value = 7+7+7;
        System.out.println("After Slot Machine: " + total.value);

    }
}