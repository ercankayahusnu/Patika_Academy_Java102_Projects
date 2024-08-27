import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("########################################################################\n");
        System.out.println("Hello, great hero, have you come to save us? \n");
        System.out.print("If you came to save us can you tell me your name : \n");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName() + " our village is in big trouble, only you can save it from this trouble.\n");
        player.selectChar();

        Location location = null;
        System.out.println("*********************** LOCATIONS ***********************\n");
        while (true) {
            player.printInfo();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Safe House: It is an area free from enemies. Here the village people will heal your wounds and your health will increase.");
            System.out.println("Shop: You can increase your character's health and damage by purchasing new armor and equipment.");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("0-Quit Game");
            System.out.println("1--> Safe House ");
            System.out.println("2--> Shop \n");
            System.out.println("Please select the region you want to go to:");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------\n");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);

            }
            if (location == null) {
                System.out.println("GAME OVER ");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }
        }
    }
}
