package model.animal.pet;

import model.animal.Animal;

import java.time.LocalDate;

public abstract class Pet extends Animal {

    public Pet(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public abstract String showAffection();

    @Override
    public String getType() {
        return Pet.class.getSimpleName();
    }
}
