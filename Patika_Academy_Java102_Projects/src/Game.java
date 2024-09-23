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
            System.out.println("Cave:The caves of our village have been taken over by zombies. Help us reach our supplies in our caves.");
            System.out.println("Forest:The forests of our village have been taken over by vampires. wood in our forests.Help us reach him.");
            System.out.println("River:The rivers of our village have been taken over by bears. We lost our water source, help us.");
            System.out.println("Safe House: It is an area free from enemies. Here the village people will heal your wounds and your health will increase.");
            System.out.println("Shop: You can increase your character's health and damage by purchasing new armor and equipment.");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("0-Quit Game");
            System.out.println("1--> Cave ");
            System.out.println("2--> Forest ");
            System.out.println("3--> River ");
            System.out.println("4--> Safe House ");
            System.out.println("5--> Shop ");

            System.out.println("Please select the region you want to go to:");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------\n");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new Cave(player);
                    break;
                case 2:
                    location = new Forest(player);
                    break;
                case 3:
                    location = new River(player);
                    break;
                case 4:
                    location = new SafeHouse(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    System.out.println("Please enter a valid region.");

            }
            if (location == null) {
                System.out.println("GAME OVER ");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }
    }
}
