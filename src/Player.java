import javax.swing.JOptionPane;

public class Player {

    private String playerName;
    private String playerRace;
    private Item item = new Item();
    private Double playerHP;
    private boolean alive = true;

    public void createNewPlayer() {
        setPlayerName(JOptionPane.showInputDialog("Player Name: "));
        int op = Integer.parseInt(JOptionPane.showInputDialog("Select your race: \n(1 Human - 2 Orc - 3 Elf)"));

        while (op < 1 || op > 3) {
            op = Integer.parseInt(JOptionPane.showInputDialog("Select a valid race: \n(1 Human - 2 Orc - 3 Elf)"));
        }

        if (op == 1) {
            setPlayerRace("Human");
            setPlayerHP(100.0);
        }
        if (op == 2) {
            setPlayerRace("Orc");
            setPlayerHP(150.0);
        }
        if (op == 3) {
            setPlayerRace("Elf");
            setPlayerHP(90.0);
        }

        setItem(item);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        item.createNewItem();
        this.item = item;
    }

    public Double getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(Double playerHP) {
        this.playerHP = playerHP;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {

        this.alive = alive;
    }

}
