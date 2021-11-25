
import javax.swing.JOptionPane;

public class Item {

    private String itemName;
    private Double itemDamage;

    public void createNewItem() {
        int op = Integer.parseInt(JOptionPane.showInputDialog("Choose your Weapom: \n1 - Bow\n2 - Axe\n3 - Sword"));
while (op < 1 || op >3) {
    op = Integer.parseInt(JOptionPane.showInputDialog("Choose a valid Weapom: \n1 - Bow\n2 - Axe\n3 - Sword"));
}
        if (op == 1) {
            setItemName("Bow");
            setItemDamage(15.0);
        }
        if (op == 2) {
            setItemName("Axe");
            setItemDamage(25.0);
        }
        if (op == 3) {
            setItemName("Sword");
            setItemDamage(20.0);
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemDamage() {
        return itemDamage;
    }

    public void setItemDamage(Double itemDamage) {
        this.itemDamage = itemDamage;
    }

}
