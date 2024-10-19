package model.builder;

import model.animal.packAnimal.camel.Camel;

public class CamelBuilder extends AnimalBuilder<CamelBuilder>{

    @Override
    public Camel build() {
        return new Camel(name, birthDate);
    }

    @Override
    protected CamelBuilder self() {
        return this;
    }
}
