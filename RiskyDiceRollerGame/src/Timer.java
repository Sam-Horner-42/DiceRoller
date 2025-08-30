public class Timer extends Item {
    public Timer() { super("timer", "Times running out, your max roll is halved"); }

    @Override
    public void use(IntWrapper total) {
        if(total.value != 0 && total.value != 1)
            total.value /= 2;
        System.out.println("After Timer: " + total.value);
    }
}
