package model.animal.packAnimal.horse;

import model.animal.packAnimal.PackAnimal;

import java.time.LocalDate;

public class Horse extends PackAnimal {

    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return Horse.class.getSimpleName();
    }

    @Override
    public String performAction() {
        return "Конь скачет по полю";
    }

    @Override
    public String rest() {
        return getName() + " отдыхает после тяжелого дня";
    }
}
