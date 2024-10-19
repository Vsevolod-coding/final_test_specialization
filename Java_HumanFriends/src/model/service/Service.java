package model.service;

import model.animal.packAnimal.camel.Camel;
import model.animal.packAnimal.donkey.Donkey;
import model.animal.packAnimal.horse.Horse;
import model.animal.pet.cat.Cat;
import model.animal.pet.dog.Dog;
import model.animal.pet.hamster.Hamster;
import model.animalRegistry.AnimalRegistry;
import model.animalTypes.AnimalTypesReader;
import model.builder.*;
import model.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;


public class Service {
    FileHandler fileHandler;
    AnimalRegistry animalRegistry;
    AnimalTypesReader animalTypesReader;

    public Service() {
        fileHandler = new FileHandler();
        animalRegistry = new AnimalRegistry();
        animalTypesReader = new AnimalTypesReader();
    }

    public void createCamel(String name, LocalDate birthDate) {
        Camel camel = new CamelBuilder()
                .withName(name)
                .withBirthDate(birthDate)
                .build();
        animalRegistry.addAnimal(camel);
    }

    public void createHorse(String name, LocalDate birthDate) {
        Horse horse = new HorseBuilder()
                .withName(name)
                .withBirthDate(birthDate)
                .build();
        animalRegistry.addAnimal(horse);
    }

    public void createDonkey(String name, LocalDate birthDate) {
        Donkey donkey = new DonkeyBuilder()
                .withName(name)
                .withBirthDate(birthDate)
                .build();
        animalRegistry.addAnimal(donkey);
    }

    public void createDog(String name, LocalDate birthDate) {
        Dog dog = new DogBuilder()
                .withName(name)
                .withBirthDate(birthDate)
                .build();
        animalRegistry.addAnimal(dog);
    }

    public void createCat(String name, LocalDate birthDate) {
        Cat cat = new CatBuilder()
                .withName(name)
                .withBirthDate(birthDate)
                .build();
        animalRegistry.addAnimal(cat);
    }

    public void createHamster(String name, LocalDate birthDate) {
        Hamster hamster = new HamsterBuilder()
                .withName(name)
                .withBirthDate(birthDate)
                .build();
        animalRegistry.addAnimal(hamster);
    }

    public String showAnimalCommands(String name) {
        return animalRegistry.showAnimalCommands(name);
    }

    public void teachAnimal(String name, String command) {
        animalRegistry.teachAnimalCommand(name, command);
    }

    public String showAnimalByBirthDate() {
        return animalRegistry.showAnimalByBirthDate();
    }

    public String showTotalAnimalCount() {
        return animalRegistry.showTotalAnimalCount();
    }

    public String showAllAnimals() {
        return animalRegistry.showAllAnimals();
    }

    public void saveAnimalsData() {
        fileHandler.save(animalRegistry);
    }

    public Object readAnimalsData() {
        return animalRegistry = (AnimalRegistry) fileHandler.read();
    }

    public String getPath() {
        return fileHandler.getPath();
    }

    public List<String> getAnimalTypes() {
        return animalTypesReader.getAnimalTypes();
    }

    public boolean isAnimalWithNameExists(String name) {
        if (animalRegistry == null) {
            return false;
        }
        return animalRegistry.isAnimalWithNameExists(name);
    }
}
