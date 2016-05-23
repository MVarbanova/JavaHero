package game.logic;

//import java.util.*;
import java.io.Serializable;

@SuppressWarnings("unqualified-field-access")
public class Hero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7398158183710161555L;
	private String name;
	private double experience;
	private Item Left;
	private Item Right;
	private Item Head;
	private int health;
	private int stamina;
	private int energy;
	private int maxEnergy;

	public Hero(final String _name) {
		this(_name, 1, new Item(), new Item(), new Item(), 100, 20, 30, 30);
	}

	public Hero(final String name, final double exp, final Item left, final Item right, final Item head,
			final int health, final int stamina, final int energy, final int maxE) {
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

	public Hero(final Hero hero) {
		this(hero.getName(), hero.getExperience(), 
				hero.getLeft(), hero.getRight(),
				hero.getHead(), hero.getHealth(), 
				hero.getStamina(), hero.getEnergy(), hero.getMaxEnergy());
	}

	public String getName() {
		return name;
	}

	public double getExperience() {
		return experience;
	}

	public Item getLeft() {
		return new Item(this.Left);
	}

	public Item getRight() {
		return new Item(this.Right);
	}

	public Item getHead() {
		return new Item(this.Head);
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

	void setName(final String newName) {
		if (newName == null) {
			this.name = "";
			return;
		}
		name = newName;
	}

	void setExperience(final double exp) {
		if (exp < 0) {
			this.experience = 0;
			return;
		}
		experience = exp;
	}

	public void setLeft(final Item leftItem) {
		if (leftItem == null) {
			this.Left = new Item();
			return;
		}
		Left = new Item(leftItem);
	}

	public void setRight(final Item rightItem) {
		if (rightItem == null) {
			this.Right = new Item();
			return;
		}
		Right = new Item(rightItem);
	}

	public void setHead(final Item headItem) {
		if (headItem == null) {
			this.Head = new Item();
			return;
		}
		Head = new Item(headItem);
	}

	public void setHealth(final int healthValue) {
		if (healthValue < 0) {
			this.health = 0;
		} else if (healthValue > 100) {
			this.health = 100;
		}
		else{
			health = healthValue;			
		}
	}

	void setStamina(final int staminaValue) {
		if (staminaValue < 0) {
			this.stamina = 0;
			return;
		}
		stamina = staminaValue;
	}

	public void setEnergy(final int energyValue) {
		if (energyValue < 0) {
			this.energy = 0;
		} else if (energyValue > getMaxEnergy()) {
			this.energy = getMaxEnergy();
		}
		else{
			energy = energyValue;			
		}
	}

	void setMaxEnergy(final int maxEnergyValue) {
		if (maxEnergyValue <= 0) {
			this.maxEnergy = 1;
		}
		else{
			maxEnergy = maxEnergyValue;
		}
		
	}

	/**
	 * Increase hero experience. If level up, increase MaxEnergy by 2.
	 * 
	 * @param turns
	 *            int counter in Battle
	 */
	public void increaseExperience(final int turns) {
		final int oldLevel = this.getLevel();
		
		setExperience(getExperience() + 0.03 * turns);
		
		if (getLevel() > oldLevel) {
			setMaxEnergy(getMaxEnergy() + 2);
		}
	}

	/**
	 * Set hero's energy to the hero's MaxEnergy
	 */
	public void refillEnergy() {
		setEnergy(getMaxEnergy());
	}

	/**
	 * Calculates hero damage according hero's items
	 * 
	 * @return hero's damage by items only
	 */
	private double dmgBody() {
		return 0.4 * getLeft().dmg() + 0.4 * getRight().dmg() + 0.2 * getHead().dmg(); // NOPMD by Mim on 13.05.16 08:24
	}

	/**
	 * Calculates total damage power of the hero.
	 * 
	 * @return fighting damage of the hero
	 */
	private double dmgAll() {
		return (1 + 0.02 * getStamina()) * this.dmgBody();
	}

	/**
	 * Attack of this hero to "other", given as parameter
	 * 
	 * @param other
	 *            refers to current opponent
	 */
	public void attack(final Hero other) {
		// other.setHealth((int) (other.getHealth() - (double) (getEnergy() /
		// getMaxEnergy()) * dmgAll()));
		other.health -= ((double) energy / maxEnergy) * this.dmgAll();
		// setEnergy((int) (getEnergy() - 0.1 * ((double) (getEnergy() /
		// getMaxEnergy()))));
		energy -= 0.1 * ((double) energy / maxEnergy);// was+=
	}

	/**
	 * Standard toString method applied to hero
	 * 
	 * @return this hero to String
	 */
	@Override
	public String toString() {
		final StringBuilder strBuffer = new StringBuilder();
		strBuffer.append("Name:").append(getName()).append("    Experience: ").append(getExperience());
		strBuffer.append("\nHealth:").append(getHealth()).append("    Energy: ");
		strBuffer.append(getEnergy()).append("\nStamina:").append(getStamina());
		strBuffer.append("     Max Energy: ").append(getMaxEnergy());
		return strBuffer.toString();
	}
}
