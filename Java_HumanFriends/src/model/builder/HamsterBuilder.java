package model.builder;

import model.animal.pet.hamster.Hamster;

public class HamsterBuilder extends AnimalBuilder<HamsterBuilder>{

    @Override
    public Hamster build() {
        return new Hamster(name, birthDate);
    }

    @Override
    protected HamsterBuilder self() {
        return this;
    }
}
