package model.builder;

import model.animal.packAnimal.horse.Horse;

public class HorseBuilder extends AnimalBuilder<HorseBuilder>{

    @Override
    public Horse build() {
        return new Horse(name, birthDate);
    }

    @Override
    protected HorseBuilder self() {
        return this;
    }
}
