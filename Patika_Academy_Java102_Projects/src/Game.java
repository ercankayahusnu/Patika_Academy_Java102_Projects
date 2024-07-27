import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("########################################################################");
        System.out.println("Hello, great hero, have you come to save us? \n");
        System.out.print("If you came to save us can you tell me your name : \n");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName() + " our village is in big trouble, only you can save it from this trouble.");
        player.selectChar();
    }
}
