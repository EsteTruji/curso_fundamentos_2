public abstract class Bug {
    private String name;
    private int health;

    public Bug() {
    }

    public Bug(String name, int health) {
        this.setName(name);  this.setHealth(health);
    }


    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
}
