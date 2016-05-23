package game.logic;

/**
 * 
 * @author Mim
 *
 */
public class Battle {

	/**
	 * 
	 */
	private transient final Hero first;
	/**
	 * 
	 */
	private transient final Hero second;

	/**
	 * Initialization of the two fighting heroes
	 * 
	 * @param hero1
	 *            current game player
	 * @param hero2
	 *            chosen opponent from the list
	 */
	@SuppressWarnings("unqualified-field-access")
	public Battle(final Hero hero1, final Hero hero2) {
		first = new Hero(hero1);
		second = new Hero(hero2);
	}

	/**
	 * The act of fighting in the battle. Increases Experience if current player wins.
	 *
	 * @return the current game player after the fight.
	 */
	@SuppressWarnings("unqualified-field-access")
	public Hero fight() {
		int turnsCount = 0;
		while (first.getHealth() > 0 && second.getHealth() > 0) {
			turnsCount++;
			first.attack(second);
			if (second.getHealth() <= 0) {
				break;
			}
			second.attack(first);
		}

		if (first.getHealth() > 0) {
			first.increaseExperience(turnsCount);
		} else {
			second.increaseExperience(turnsCount);
		}
		first.refillEnergy();
		second.refillEnergy();
		return first;

	}
}
