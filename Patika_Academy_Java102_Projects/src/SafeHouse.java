public class SafeHouse extends NormalLocation {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in a safe house, your life is renewed \n");
        this.getPlayer().setHealth(this.getPlayer().getOrjHealth());
        return true;
    }
}
