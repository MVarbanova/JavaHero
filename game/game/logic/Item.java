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

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Item(String n, int p, int w) {
        setIname(n);
        setPower(p);
        setWeight(w);
    }

    public Item(Item i) {
        this(i.getIname(),i.getPower(),i.getWeight());
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public void setPower(int power) {
        if (power < 0) {
            this.power = 0;
            return;
        }
        this.power = power;
    }

    public void setWeight(int weight) {
        if (weight < 0) {
            this.weight = 0;
            return;
        }
        this.weight = weight;
    }

    /**
     * Calculates damage power of this item
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
     * Standart toString method applyed to Item
     * @return this item to String
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getIname()).append(" Power:  ").append(getPower());
        sb.append("  Weight:  ").append(getWeight());
        return sb.toString();        
    }
        
}

