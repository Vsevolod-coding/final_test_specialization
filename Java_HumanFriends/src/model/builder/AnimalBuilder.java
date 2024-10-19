package model.builder;

import model.animal.Animal;

import java.time.LocalDate;

public abstract class AnimalBuilder<E extends AnimalBuilder<E>> {
    protected String name;
    protected LocalDate birthDate;

    public E withName(String name) {
        this.name = name;
        return self();
    }

    public E withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return self();
    }

    public abstract Animal build();

    protected abstract E self();
}
