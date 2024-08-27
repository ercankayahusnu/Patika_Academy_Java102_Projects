public class Inventory {
    private Weapon weapon;
    private Armors armor;

    public Inventory() {
        this.weapon = new Weapon(-1, "Punch", 0, 0);
        this.armor = new Armors(-1, "No Armor", 0, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }
}
