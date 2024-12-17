package org.nexai.spring_container.example.dto;

import org.nexai.spring_container.example.dto.api.IPet;

public class Dog implements IPet {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}
