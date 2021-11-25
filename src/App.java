import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class App {

    public static ArrayList<Monster> monsters = new ArrayList<Monster>();
    public static ArrayList<Player> players = new ArrayList<Player>();

    public static void main(String[] args) {

        int op = 0;

        while (op != 5) {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Create a Player\n2 - Create a Monster\n3 - List Monsters and Players\n4 - Fight\n5 - End"));
            if (op == 1) {
                createNewPlayer();
            }
            if (op == 2) {
                selectMonster();
            }
            if (op == 3) {
                listMonsterAndPlayer();
            }
            if (op == 4) {
                startFight();
            }
            if (op == 5) {
                JOptionPane.showMessageDialog(null, "Thanks for play my fist game ! sz");
            }
        }

    }

    public static void createNewPlayer() {
        Player p = new Player();
        p.createNewPlayer();
        players.add(p);
        JOptionPane.showMessageDialog(null,
                "Name - " + p.getPlayerName() + "\nRace - " + p.getPlayerRace() + "\nItem - "
                        + p.getItem().getItemName() + "(" + p.getItem().getItemDamage() + ")" + "\nHP="
                        + p.getPlayerHP() + "\nStatus = " + p.isAlive());
    }

    public static void listMonsterAndPlayer() {
        // List Monster
        String listM = "";
        for (int i = 0; i < monsters.size(); i++) {

            listM = listM + (i + 1) + " = Monster Race: " + monsters.get(i).getRace() + "\nWeapon: "
                    + monsters.get(i).getItem() + "\nHP: " + monsters.get(i).getHP() + "\n-------\n";
        }
        JOptionPane.showMessageDialog(null, listM);
        // List Player
        String listP = "";
        for (int i = 0; i < players.size(); i++) {

            listP = listP + (i + 1) + " = Player Name: " + players.get(i).getPlayerName() + "\nPlayer Race: "
                    + players.get(i).getPlayerRace() + "\nWeapon: " + players.get(i).getItem().getItemName() + "\nHP: "
                    + players.get(i).getPlayerHP() + "\n-------\n";
        }
        JOptionPane.showMessageDialog(null, listP);
    }

    public static void selectMonster() {

        Random rand = new Random();

        int randm = rand.nextInt(3);

        if (randm == 0) {
            Monster m = new Monster();
            m.setRace("Skeleton");
            m.setItem("Bow");
            m.setHP(50.0);
            m.setMonsterDamage(15.0);
            monsters.add(m);
            JOptionPane.showMessageDialog(null, "Monster Created\n" + m.getRace());
        }
        if (randm == 1) {
            Monster m = new Monster();
            m.setRace("Undead Sorcerer");
            m.setItem("Mage Catalist");
            m.setHP(60.0);
            m.setMonsterDamage(20.0);
            monsters.add(m);
            JOptionPane.showMessageDialog(null, "Monster Created\n" + m.getRace());
        }
        if (randm == 2) {
            Monster m = new Monster();
            m.setRace("Human Warrior");
            m.setItem("Great Sword");
            m.setHP(100.0);
            m.setMonsterDamage(35.0);
            monsters.add(m);
            JOptionPane.showMessageDialog(null, "Monster Created\n" + m.getRace());
        }

    }

    public static void startFight() {
        Integer pNumber = null;
        Integer mNumber = null;
        Random randomic = new Random();

        // Choose

        while (pNumber == null) {
            pNumber = Integer.parseInt(JOptionPane.showInputDialog("Choose Your Player:"));
            if (players.get(pNumber - 1).isAlive() == false) {
                pNumber = Integer.parseInt(JOptionPane.showInputDialog("This Players is dead, please choose other:\n"));
                pNumber = null;
            }

        }
        while (mNumber == null) {
            mNumber = Integer.parseInt(JOptionPane.showInputDialog("Choose Your Monster"));
            if (monsters.get(mNumber - 1).isAlive() == false) {
                mNumber = Integer.parseInt(JOptionPane.showInputDialog("This Monster is dead, please choose other:\n"));
                mNumber = null;
            }

        }
        // fight
        while (players.get(pNumber - 1).isAlive() == true && monsters.get(mNumber - 1).isAlive() == true) {
            // 0 - Player Turn
            if (randomic.nextInt(3) == 0 && players.get(pNumber - 1).isAlive() == true) {
                Random critical = new Random();
                Double weapomDamage = players.get(pNumber - 1).getItem().getItemDamage() * critical.nextDouble(1.5);
                JOptionPane.showMessageDialog(null,
                        "Player ATACK with " + players.get(pNumber - 1).getItem().getItemName());
                monsters.get(mNumber - 1).setHP(monsters.get(mNumber - 1).getHP() - weapomDamage);
                JOptionPane.showMessageDialog(null,
                        "Monster HP Before Atack " + Math.floor(monsters.get(mNumber - 1).getHP()) + "\nTotal Damage = "
                                + Math.floor(weapomDamage));
                // valid Monster Status
                if (monsters.get(mNumber - 1).getHP() <= 0)
                    monsters.get(mNumber - 1).setAlive(false);

            }
            // 1 - Monster Turn
            if (randomic.nextInt(3) == 1 && players.get(pNumber - 1).isAlive() == true) {
                Random critical = new Random();
                Double weapomDamage = monsters.get(mNumber - 1).getMonsterDamage() * critical.nextDouble(1.5);
                JOptionPane.showMessageDialog(null, "Monster ATACK with " + monsters.get(mNumber - 1).getItem());
                players.get(pNumber - 1).setPlayerHP(players.get(pNumber - 1).getPlayerHP() - weapomDamage);
                JOptionPane.showMessageDialog(null,
                        "Player HP Before Atack " + Math.floor(players.get(pNumber - 1).getPlayerHP())
                                + "\nTotal Damage " + Math.floor(weapomDamage));
                // Valid Player Status
                if (players.get(pNumber - 1).getPlayerHP() <= 0) {
                    players.get(pNumber - 1).setAlive(false);

                } else {
                    JOptionPane.showMessageDialog(null,
                            "#Double Evade#\nPlayer - " + players.get(pNumber - 1).getPlayerName() + "\nHP "
                                    + Math.floor(players.get(0).getPlayerHP()) + "\n\nMonster - "
                                    + monsters.get(0).getRace() + "\nHP "
                                    + Math.floor(monsters.get(mNumber - 1).getHP()));
                }

            }

            // Results
            if (players.get(pNumber - 1).isAlive() == false) {
                JOptionPane.showMessageDialog(null, "You Died !!!!!!!");

            }
            if (monsters.get(mNumber - 1).isAlive() == false) {
                JOptionPane.showMessageDialog(null, "You Defeated the monster !!!!!");

            }

        }
        pNumber = null;
        mNumber = null;

    }

}
