package game.logic;

//import java.util.*;
import java.io.Serializable;

public class Hero implements Serializable {

    private String name;
    private double experience;
    private Item Left;
    private Item Right;
    private Item Head;
    private int health;
    private int stamina;
    private int energy;
    private int maxEnergy;

    public Hero(String n) {
        this(n, 1, new Item(), new Item(), new Item(), 100, 20, 30, 30);
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Hero(String name, double exp, Item left, Item right, Item head, int health,
            int stamina, int energy, int maxE) {
        setName(name);
        setExperience(exp);
        setLeft(left);
        setRight(right);
        setHead(head);
        setHealth(health);
        setStamina(stamina);
        setEnergy(energy);
        setMaxEnergy(maxE);

    }

    public Hero(Hero h) {
        this(h.getName(), h.getExperience(), h.getLeft(), h.getRight(), h.getHead(),
                h.getHealth(), h.getStamina(), h.getEnergy(), h.getMaxEnergy());
    }

    public String getName() {
        return name;
    }

    public double getExperience() {
        return experience;
    }

    public Item getLeft() {
        Item i = new Item(this.Left);
        return i;
    }

    public Item getRight() {
        Item i = new Item(this.Right);
        return i;
    }

    public Item getHead() {
        Item i = new Item(this.Head);
        return i;
    }

    public int getHealth() {
        return health;
    }

    public int getStamina() {
        return stamina;
    }

    public int getLevel() {
        return (int) Math.floor(experience);
    }

    public int getEnergy() {
        return energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setName(String n) {
        if (n == null) {
            this.name = "";
            return;
        }
        name = n;
    }

    public void setExperience(double s) {
        if (s < 0) {
            this.experience = 0;
            return;
        }
        experience = s;
    }

    public void setLeft(Item l) {
        if (l == null) {
            this.Left = new Item();
            return;
        }
        Left = new Item(l);
    }

    public void setRight(Item r) {
        if (r == null) {
            this.Right = new Item();
            return;
        }
        Right = new Item(r);
    }

    public void setHead(Item h) {
        if (h == null) {
            this.Head = new Item();
            return;
        }
        Head = new Item(h);
    }

    public void setHealth(int h) {
        if (h < 0) {
            this.health = 0;
            return;
        } else if (h > 100) {
            this.health = 100;
            return;
        }
        health = h;
    }

    public void setStamina(int s) {
        if (s < 0) {
            this.stamina = 0;
            return;
        }
        stamina = s;
    }

    public void setEnergy(int s) {
        if (s < 0) {
            this.energy = 0;
            return;
        } else if (s > getMaxEnergy()) {
            this.energy = getMaxEnergy();
        }
        energy = s;
    }

    public void setMaxEnergy(int s) {
        if (s <= 0) {
            this.maxEnergy = 1;
            return;
        }
        maxEnergy = s;
    }

    /**
     * Increase hero experience. If level up, increase MaxEnergy by 2.
     * @param turns int counter in Battle
     */
    public void increaseExperience(int turns) {
        int oldLevel = this.getLevel();
        setExperience(getExperience() + 0.03 * turns);
        if (getLevel() > oldLevel) {
            setMaxEnergy(getMaxEnergy() + 2);
        }
    }

    /**
     * Set hero energy to the hero MaxEnergy
     */
    public void refillEnergy() {
        setEnergy(getMaxEnergy());
    }

    /**
     * Calculates hero damage according hero's items
     * @return hero's damage by items only
     */
    private double dmgBody() {
        return 0.4 * getLeft().dmg() + 0.4 * getRight().dmg() + 0.2 * getHead().dmg();
    }

    /**
     * Calculates total damage power of the hero.
     * @return fighting damage of the hero
     */
    private double dmgAll() {
        return (1 + 0.02 * getStamina()) * this.dmgBody();
    }
    
    /**
     * Attack of this hero to "other", given as paramether
     * @param other refers to current opponent
     */
    public void attack(Hero other) {
        //     other.setHealth((int) (other.getHealth() - (double) (getEnergy() / getMaxEnergy()) * dmgAll()));
        other.health -= ((double) energy / maxEnergy) * this.dmgAll();
        //     setEnergy((int) (getEnergy() - 0.1 * ((double) (getEnergy() / getMaxEnergy()))));
        energy -= 0.1 * ((double) energy / maxEnergy);//was+=
    }
    
    /**
     * Standart toString method applyed to hero
     * @return this hero to String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name:").append(getName()).append("    Experience: ").append(getExperience());
        sb.append("\nHealth:").append(getHealth()).append("    Energy: ");
        sb.append(getEnergy()).append("\nStamina:").append(getStamina());
        sb.append("     Max Energy: ").append(getMaxEnergy());
        return sb.toString();
    }
}
