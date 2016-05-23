package game.logic;

import java.io.Serializable;

@SuppressWarnings("unqualified-field-access")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8526473204325006283L;
	private String iname;
	private int power;
	private int weight;

	public Item() {
		this("80416", 1, 1);
	}


	public Item(final String name, final int power, final int weight) {
		setIname(name);
		setPower(power);
		setWeight(weight);
	}

	public Item(final Item item) {
		this(item.getIname(), item.getPower(), item.getWeight());
	}

	public final void setIname(final String iname) {
		this.iname = iname;
	}

	public void setPower(final int power) {
		if (power < 0) {
			this.power = 0;
			return;
		}
		this.power = power;
	}

	public void setWeight(final int weight) {
		if (weight < 0) {
			this.weight = 0;
			return;
		}
		this.weight = weight;
	}

	/**
	 * Calculates damage power of this item
	 * 
	 * @return power of this item
	 */
	public double dmg() {
		return (1 + 0.01 * getWeight()) * getPower();
	}

	public String getIname() {
		return iname;
	}

	public int getPower() {
		return power;
	}

	public int getWeight() {
		return weight;
	}

	/**
	 * Standard toString method applied to Item
	 * 
	 * @return this item to String
	 */
	@Override
	public String toString() {
		final StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(getIname()).append(" Power:  ").append(getPower());
		strBuilder.append("  Weight:  ").append(getWeight());
		return strBuilder.toString();
	}

}
