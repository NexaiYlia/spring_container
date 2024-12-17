package org.nexai.spring_container.example;

import org.nexai.spring_container.example.dto.api.IPet;

public class Zoo {
    IPet pet;

    public Zoo(IPet pet) {
        this.pet = pet;
    }

    public void doSmth() {
        pet.makeSound();
    }
}
