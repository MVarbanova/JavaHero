package game.logic;

import java.io.*;

public class SaveClass {

    /**
     * Makes or overwrites existing save for hero given as parameter. Save file
     * is "hero's name".toshko
     * @param him hero to be saved
     */
    public static void saveHero(Hero him) {
    	String s = "./save/" + him.getName() + ".toshko";
        try (FileOutputStream fos = new FileOutputStream(s);
        	ObjectOutputStream oos = new ObjectOutputStream(fos);)
        {   
            oos.writeUTF(him.getName());
            oos.writeDouble(him.getExperience());
            oos.writeObject(him.getLeft());
            oos.writeObject(him.getRight());
            oos.writeObject(him.getHead());
            oos.writeInt(him.getHealth());
            oos.writeInt(him.getStamina());
            oos.writeInt(him.getEnergy());
            oos.writeInt(him.getMaxEnergy());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Revives hero from save file by name
     * @param him hero we want to bring to life
     */
    public static void reviveHero(Hero him) {
        try (FileInputStream fis = new FileInputStream("./save/" + him.getName() + ".toshko");
        	 ObjectInputStream ois = new ObjectInputStream(fis);)
        {           
            him.setName(ois.readUTF());
            him.setExperience(ois.readDouble());
            him.setLeft((Item) ois.readObject());
            him.setRight((Item) ois.readObject());
            him.setHead((Item) ois.readObject());
            him.setHealth(ois.readInt());
            him.setStamina(ois.readInt());
            him.setEnergy(ois.readInt());
            him.setMaxEnergy(ois.readInt());
            ois.close();
        } catch (InvalidClassException e) {
        	e.getMessage();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
