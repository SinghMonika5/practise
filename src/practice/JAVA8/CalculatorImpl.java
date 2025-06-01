package practice.JAVA8;

interface Calculator{
    void switchOn();
}

interface MusicPlayer{
    String play(String song);
}

public class CalculatorImpl {

    public static void main(String[] args) {
        Calculator calculator = ()->{
            System.out.println("Light Switched On");
        };

        MusicPlayer musicPlayer = (song)->{
            System.out.println("Playing "+song);
            return "playing";
        };

        calculator.switchOn();
        String msg = musicPlayer.play("Test");
        System.out.println(msg);
    }
}
