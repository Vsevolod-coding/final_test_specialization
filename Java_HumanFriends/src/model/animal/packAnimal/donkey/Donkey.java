package model.animal.packAnimal.donkey;

import model.animal.packAnimal.PackAnimal;

import java.time.LocalDate;

public class Donkey extends PackAnimal {

    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return Donkey.class.getSimpleName();
    }

    @Override
    public String performAction() {
        return "Осел несет тяжелый груз";
    }

    @Override
    public String rest() {
        return getName() + " отдыхает после тяжелого дня";
    }
}
