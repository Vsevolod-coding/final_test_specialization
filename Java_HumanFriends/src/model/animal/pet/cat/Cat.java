package model.animal.pet.cat;

import model.animal.pet.Pet;

import java.time.LocalDate;

public class Cat extends Pet {

    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return Cat.class.getSimpleName();
    }

    @Override
    public String performAction() {
        return "Кот лезет на дерево";
    }

    @Override
    public String showAffection() {
        return getName() + " проявляет привязанность";
    }
}
