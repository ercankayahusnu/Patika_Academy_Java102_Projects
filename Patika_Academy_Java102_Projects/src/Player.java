import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orjHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;


    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("*********************** CHARACTERS ***********************\n");
        for (GameChar gameChar : charList) {
            System.out.println(gameChar.getId() + "--" + gameChar.getName() +
                    "\n Damage -> " + gameChar.getDamage() +
                    "\n Health -> " + gameChar.getHealth() +
                    "\n Money -> " + gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------------\n");
        System.out.println("Please choose a character");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        /*
        System.out.println("Selected Character : " + this.getCharName()
                + " -> Damage : " + this.getDamage()
                + "  Health : " + this.getHealth()
                + "  Money : " + this.getMoney());
        System.out.println("\n");

         */
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println(
                "Weapon  -> " + this.getInventory().getWeapon().getName() + "\n" +
                        "Armor  -> " + this.getInventory().getArmor().getName() + "\n" +
                        "Block  -> " + this.getInventory().getArmor().getBlock() + "\n" +
                        "Damage -> " + this.getDamage() + "\n" +
                        "Health -> " + this.getHealth() + "\n" +
                        "Money  -> " + this.getMoney());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
