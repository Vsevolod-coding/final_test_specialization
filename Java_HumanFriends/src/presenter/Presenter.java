package presenter;

import model.service.Service;
import view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    View view;
    Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void createCamel(String name, LocalDate birthDate) {
        service.createCamel(name, birthDate);
    }

    public void createHorse(String name, LocalDate birthDate) {
        service.createHorse(name, birthDate);
    }

    public void createDonkey(String name, LocalDate birthDate) {
        service.createDonkey(name, birthDate);
    }

    public void createDog(String name, LocalDate birthDate) {
        service.createDog(name, birthDate);
    }

    public void createCat(String name, LocalDate birthDate) {
        service.createCat(name, birthDate);
    }

    public void createHamster(String name, LocalDate birthDate) {
        service.createHamster(name, birthDate);
    }

    public String showAnimalCommands(String name) {
        return service.showAnimalCommands(name);
    }

    public void teachAnimal(String name, String command) {
        service.teachAnimal(name, command);
    }

    public String showAnimalByBirthDate() {
        return service.showAnimalByBirthDate();
    }

    public String showTotalAnimalCount() {
        return service.showTotalAnimalCount();
    }

    public String showAllAnimals() {
        return service.showAllAnimals();
    }

    public void saveAnimalsData() {
        service.saveAnimalsData();
    }

    public Object readAnimalsData() {
        return service.readAnimalsData();
    }

    public String getPath() {
        return service.getPath();
    }

    public List<String> getAnimalTypes() {
        return service.getAnimalTypes();
    }

    public boolean isAnimalWithNameExists(String name) {
        return service.isAnimalWithNameExists(name);
    }
}

