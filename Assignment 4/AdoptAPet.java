import java.util.*;

class Pet {
    String name;
    String species;
    int timestamp;

    public Pet(String n, String s, int t) {
        name = n;
        species = s;
        timestamp = t;
    }
}

public class AdoptAPet {
    private Queue<Pet> catQueue;
    private Queue<Pet> dogQueue;
    private int timestamp;

    public void addPet(String name, String species) {
        Pet pet = new Pet(name, species, timestamp);
        if (species.equals("cat"))
            catQueue.offer(pet);
        else if (species.equals("dog"))
            dogQueue.offer(pet);
    }

    public void adoptPet(String preferSpecies) {
        if ((preferSpecies.equals("cat") && !catQueue.isEmpty())) {
            Pet adopted = catQueue.poll();
            System.out.println("Adopted: " + adopted.name + " (Cat)");
        } else if (preferSpecies.equals("dog") && !dogQueue.isEmpty()) {
            Pet adopted = dogQueue.poll();
            System.out.println("Adopted: " + adopted.name + "(Dog)");
        } else if (!catQueue.isEmpty()) {
            System.out.println("Adopted: " + catQueue.poll().name + " (Cat)");
        } else if (!dogQueue.isEmpty()) {
            System.out.println("Adopted: " + dogQueue.poll().name + " (Dog)");
        } else {
            System.out.println("No pets Available");
        }
    }
}
