package game.logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class SaveClass {

	/**
	 * Makes or overwrites existing save for hero given as parameter. Save file
	 * is "hero's name".toshko
	 * 
	 * @param him
	 *            hero to be saved
	 */
	public static void saveHero(final Hero him) {
		final String path = "./save/" + him.getName() + ".toshko";
		
		try (final FileOutputStream fos = new FileOutputStream(path);
				final ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeUTF(him.getName());
			oos.writeDouble(him.getExperience());
			oos.writeObject(him.getLeft());
			oos.writeObject(him.getRight());
			oos.writeObject(him.getHead());
			oos.writeInt(him.getHealth());
			oos.writeInt(him.getStamina());
			oos.writeInt(him.getEnergy());
			oos.writeInt(him.getMaxEnergy());
		}
		catch (final IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Revives hero from save file by name
	 * 
	 * @param him
	 *            hero we want to bring to life
	 */
	public static void reviveHero(final Hero him) {
		try (final FileInputStream fis = new FileInputStream("./save/" + him.getName() + ".toshko");
				final ObjectInputStream ois = new ObjectInputStream(fis);) {
			him.setName(ois.readUTF());
			him.setExperience(ois.readDouble());
			him.setLeft((Item) ois.readObject());
			him.setRight((Item) ois.readObject());
			him.setHead((Item) ois.readObject());
			him.setHealth(ois.readInt());
			him.setStamina(ois.readInt());
			him.setEnergy(ois.readInt());
			him.setMaxEnergy(ois.readInt());
		}
		catch (final InvalidClassException e) {
			e.getMessage();
		}
		catch (final Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private SaveClass() {
		/* Private constructor will prevent the initialization of the class */
	}
}
