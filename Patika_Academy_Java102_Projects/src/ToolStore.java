public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("welcome To The Store \n");
        boolean showMenu = true;
        while (showMenu) {
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
                    buyArmos();
                    break;
                case 3:
                    System.out.println("Leaving the store");
                    showMenu = false;
                    break;

            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("-----Weaponry-------\n");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() +
                    "||\tPrice-->" + w.getPrice() + "\t || Damage-->" + w.getDamage());
        }
        System.out.println("0-Back to Shop Menu\n");
    }

    public void buyWeapon() {
        System.out.println("Choose weapon: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("You entered an invalid value. Please enter again.");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
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
    }

    public void printArmor() {
        System.out.println("-----Armors-------\n");
        for (Armors a : Armors.armors()) {
            System.out.println(a.getId() + "-" + a.getName() +
                    "||\tPrice-->" + a.getPrice() + ",||\tBlock-->" + a.getBlock());
        }
        System.out.println("0-Back to Shop Menu\n");
    }

    public void buyArmos() {
        System.out.println("Choose armor: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armors.armors().length) {
            System.out.println("You entered an invalid value. Please enter again.");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armors selectedArmor = Armors.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough money");
                } else {
                    System.out.println(selectedArmor.getName() + " you bought the armor ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Remaining Balance:" + this.getPlayer().getMoney());
                }
            }

        }
    }
}
