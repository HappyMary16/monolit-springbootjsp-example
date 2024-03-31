package org.example.model;

import java.util.Objects;

public class Cat {

    private String name;
    private CatBehaviour behaviour;

    public Cat() {
    }

    public Cat(String name, CatBehaviour behaviour) {
        this.name = name;
        this.behaviour = behaviour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBehaviour(CatBehaviour behaviour) {
        this.behaviour = behaviour;
    }


    public String getName() {
        return name;
    }

    public CatBehaviour getBehaviour() {
        return behaviour;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", behaviour=" + behaviour +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Cat cat = (Cat) object;
        return Objects.equals(name, cat.name)
                && behaviour == cat.behaviour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, behaviour);
    }
}
