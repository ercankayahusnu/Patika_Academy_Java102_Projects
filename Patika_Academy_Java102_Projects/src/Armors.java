public class Armors {

    private int id;
    private String name;
    private int block;
    private int price;

    public Armors(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armors[] armors() {
        Armors[] armorsList = new Armors[3];
        armorsList[0] = new Armors(1, "Light Armor Set  ", 1, 15);
        armorsList[1] = new Armors(2, "Medium Armor Set ", 3, 25);
        armorsList[2] = new Armors(3, "Heavy Armor Set  ", 5, 35);

        return armorsList;
    }

    public static Armors getArmorObjByID(int id) {
        for (Armors a : Armors.armors()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
