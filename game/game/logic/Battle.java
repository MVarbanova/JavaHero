package game.logic;

public class Battle {

    private Hero first, second;

    /**Initialization of the two fighting heroes
     * @param h1 current game player
     * @param h2 chosen opponent from the list
     */
    @SuppressWarnings("unqualified-field-access")
	public Battle(Hero h1, Hero h2) {
        first = new Hero(h1);
        second = new Hero(h2);
    }

    /**
     * The act of fighting in the battle. Increase Experience if current player
     * wins.
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
