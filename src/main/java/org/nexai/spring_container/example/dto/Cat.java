package org.nexai.spring_container.example.dto;

import org.nexai.spring_container.example.dto.api.IPet;

public class Cat implements IPet {
    @Override
    public void makeSound() {
        System.out.println("meo");
    }
}
