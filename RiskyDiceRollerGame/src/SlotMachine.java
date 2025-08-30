public class SlotMachine extends Item {
    public SlotMachine() { super("slotMachine", "A Slot Machine, always rolls 777"); }

    @Override
    public void use(IntWrapper total) {
        total.value = 777;

    }
}