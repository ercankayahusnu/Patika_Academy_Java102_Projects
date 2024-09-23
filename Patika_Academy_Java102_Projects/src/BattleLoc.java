import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Current Location --> " + this.getLocationName());
        System.out.println("Be careful ! " + getPlayer().getName() + " Here " + obsNumber + " unit " + this.getObstacle().getName() + " is alive ");
        System.out.println("<W>ar or <R>un");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("W") && combat(obsNumber)) {
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("YOU DIED ");
            return false;
        }
        return true;
    }

    public boolean combat(int obstacleNumber) {
        for (int i = 1; i <= obstacleNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjHealth());
            playerStats();
            enemyStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<H>it or <E>scape");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("H")) {
                    System.out.println(" You Shot !");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + " Hit You !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }

                } else {

                    return false;
                }

            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("//////////////////////////////////////////////////////////////////////////////////");
                System.out.println("You defeated the enemy ...");
                System.out.println(this.getObstacle().getAwardMoney() + " you made money ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAwardMoney());
                System.out.println("Current Money : " + this.getPlayer().getMoney());
                System.out.println(this.getLocationName() + " Cleared  ");
                System.out.println("//////////////////////////////////////////////////////////////////////////////////");
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your Health : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Health :" + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("-----------------------------------------------");
        System.out.println("##### Player Information #####");
        System.out.println("-----------------------------------------------");
        System.out.println("Health  -> " + this.getPlayer().getHealth());
        System.out.println("Damage   -> " + this.getPlayer().getDamage());
        System.out.println("Weapon   -> " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor  -> " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Defense Bonus -> " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money    -> " + this.getPlayer().getMoney());
    }

    public void enemyStats(int i) {
        System.out.println("-----------------------------------------------");
        System.out.println("##### " + i + "." + this.getObstacle().getName() + " Information #####");
        System.out.println("-----------------------------------------------");
        System.out.println("Health -> " + this.getObstacle().getHealth());
        System.out.println("Damage -> " + this.getObstacle().getDamage());
        System.out.println("Prize  -> " + this.getObstacle().getAwardMoney());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }


    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}
