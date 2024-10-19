package model.builder;

import model.animal.pet.cat.Cat;

public class CatBuilder extends AnimalBuilder<CatBuilder>{

    @Override
    public Cat build() {
        return new Cat(name, birthDate);
    }

    @Override
    protected CatBuilder self() {
        return this;
    }
}
