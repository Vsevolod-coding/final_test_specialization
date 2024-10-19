package model.animal.packAnimal.camel;

import model.animal.packAnimal.PackAnimal;

import java.time.LocalDate;

public class Camel extends PackAnimal {

    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return Camel.class.getSimpleName();
    }

    @Override
    public String performAction() {
        return "Верблюд идет по пескам";
    }

    @Override
    public String rest() {
        return getName() + " отдыхает после тяжелого дня";
    }
}
