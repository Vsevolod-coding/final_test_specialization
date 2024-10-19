package model.animal.pet.hamster;

import model.animal.pet.Pet;

import java.time.LocalDate;

public class Hamster extends Pet {

    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return Hamster.class.getSimpleName();
    }

    @Override
    public String performAction() {
        return "Хомяк бежит в колесе";
    }

    @Override
    public String showAffection() {
        return getName() + " проявляет привязанность";
    }
}
