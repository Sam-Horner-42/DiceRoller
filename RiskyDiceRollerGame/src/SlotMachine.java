import java.util.Random;
public class SlotMachine extends Item {
    public SlotMachine() 
    { super("slotMachine", "A Slot Machine, rolls three numbers 1-7"); }

    @Override
    public void use(IntWrapper total) {
        total.value += slotsBaby();
        System.out.println("After Slot Machine: " + total.value);
        //TODO make the slot machine increase acceptable range by 1,1,1 to 7,7,7

    }

    public int slotsBaby(){
        int result = 0;
        int panel1;
        int panel2;
        int panel3;
        Random random = new Random();
        panel1 = random.nextInt(7) + 1;
        panel2 = random.nextInt(7) + 1;
        panel3 = random.nextInt(7) + 1;
        result = panel1 + panel2 + panel3;
        return result;
    }
}