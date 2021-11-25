
public class Monster {

    private String monsterRace;
    private String item;
    private Double monsterDamage;
    private Double heathPoints;
    private boolean alive = true;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Double getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(Double monsterDamage) {
        this.monsterDamage = monsterDamage;
    }

    public Double getHP() {
        return heathPoints;
    }

    public void setHP(Double heathPoints) {
        this.heathPoints = heathPoints;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getRace() {
        return monsterRace;
    }

    public void setRace(String race) {
        this.monsterRace = race;
    }
    

    // Races dataBase

}
