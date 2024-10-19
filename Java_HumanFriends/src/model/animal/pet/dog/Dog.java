package model.animal.pet.dog;

import model.animal.pet.Pet;

import java.time.LocalDate;

public class Dog extends Pet {

    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return Dog.class.getSimpleName();
    }

    @Override
    public String performAction() {
        return "Собака приносит мяч";
    }

    @Override
    public String showAffection() {
        return getName() + " проявляет привязанность";
    }
}
