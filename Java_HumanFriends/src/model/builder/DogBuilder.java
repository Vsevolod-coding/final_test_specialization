package model.builder;

import model.animal.pet.dog.Dog;

public class DogBuilder extends AnimalBuilder<DogBuilder>{

    @Override
    public Dog build() {
        return new Dog(name, birthDate);
    }

    @Override
    protected DogBuilder self() {
        return this;
    }
}
