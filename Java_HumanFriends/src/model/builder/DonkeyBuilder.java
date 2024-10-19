package model.builder;

import model.animal.packAnimal.donkey.Donkey;

public class DonkeyBuilder extends AnimalBuilder<DonkeyBuilder>{

    @Override
    public Donkey build() {
        return new Donkey(name, birthDate);
    }

    @Override
    protected DonkeyBuilder self() {
        return this;
    }
}
