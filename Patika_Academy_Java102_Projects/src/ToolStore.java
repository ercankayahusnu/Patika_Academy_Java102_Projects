public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("welcome To The Store \n");
        System.out.println("1-Weaponry");
        System.out.println("2-Armors");
        System.out.println("3-Leave Store");
        System.out.println("Select : ");
        int selectCase = Location.input.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("You entered an invalid value. Please enter again.");
            selectCase = input.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Leaving the store");
                return true;

        }
        return true;
    }

    public void printWeapon() {
        System.out.println("-----Weaponry-------\n");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() +
                    "||Price-->" + w.getPrice() + ",||Damage-->" + w.getDamage());
        }
    }

    public void buyWeapon() {
        System.out.println("Choose weapon: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("You entered an invalid value. Please enter again.");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Not enough money");
            } else {
                System.out.println(selectedWeapon.getName() + " you bought the gun ");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Remaining Balance:" + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void printArmor() {
        System.out.println("List armors");
    }
}
