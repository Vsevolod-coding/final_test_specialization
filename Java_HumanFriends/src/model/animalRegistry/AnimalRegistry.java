package model.animalRegistry;

import model.animal.Animal;
import model.animal.packAnimal.PackAnimal;
import model.animal.pet.Pet;

import java.io.Serializable;
import java.util.*;

public class AnimalRegistry implements Serializable {
    private Map<Class<? extends Animal>, List<Animal>> animalMap;

    public AnimalRegistry() {
        animalMap = new HashMap<>();

        // Инициализация списка для каждого типа животных
        animalMap.put(Pet.class, new ArrayList<>());
        animalMap.put(PackAnimal.class, new ArrayList<>());
    }

    public void addAnimal(Animal animal) {
        if (animal instanceof Pet) {
            animalMap.get(Pet.class).add(animal);
        } else if (animal instanceof PackAnimal) {
            animalMap.get(PackAnimal.class).add(animal);
        }
    }

    public String showAnimalCommands(String name) {
        for (List<Animal> animals : animalMap.values()) {
            for (Animal animal : animals) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    return "Команды животного " + "(" + name + "):\n" + String.join("\n", animal.getCommands());
                }
            }
        }
        return "Животное с именем " + name + " не найдено.";
    }

    public void teachAnimalCommand(String name, String command) {
        for (List<Animal> animals : animalMap.values()) {
            for (Animal animal : animals) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    animal.addCommand(command);
                }
            }
        }
    }

    public String showAnimalByBirthDate() {
        List<Animal> allAnimals = new ArrayList<>();
        animalMap.values().forEach(allAnimals::addAll);
        allAnimals.sort(Comparator.comparing(Animal::getBirthDate));
        StringBuilder result = new StringBuilder();
        for (Animal animal : allAnimals) {
            result.append(animal.toString()).append("\n");
        }
        return result.isEmpty() ? "Животные не найдены." : result.toString();
    }

    public String showTotalAnimalCount() {
        int total = animalMap.values().stream().mapToInt(List::size).sum();
        return "Общее количество животных: " + total;
    }

    public String showAllAnimals() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Class<? extends Animal>, List<Animal>> entry : animalMap.entrySet()) {
            Class<? extends Animal> type = entry.getKey();
            List<Animal> animals = entry.getValue();

            result.append("Тип: ").append(type.getSimpleName()).append("\n");

            for (Animal animal : animals) {
                result.append(animal.toString()).append("\n");
            }
        }
        return result.isEmpty() ? "Животные не найдены." : result.toString();
    }

    public boolean isAnimalWithNameExists(String name) {
        for (List<Animal> animals : animalMap.values()) {
            for (Animal animal : animals) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}
