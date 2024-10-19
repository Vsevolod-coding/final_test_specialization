package model.animal.packAnimal;

import model.animal.Animal;

import java.time.LocalDate;

public abstract class PackAnimal extends Animal {

    public PackAnimal(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public abstract String rest();

    @Override
    public String getType() {
        return PackAnimal.class.getSimpleName();
    }
}
