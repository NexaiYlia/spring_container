package org.nexai.spring_container.example;

import org.nexai.spring_container.example.container.CustomContext;
import org.nexai.spring_container.example.container.IContext;
import org.nexai.spring_container.example.dto.api.IPet;


public class Main {

    public static final String FILE_BEANS_PATH = "src/main/resources/beans.txt";

    public static void main(String[] args) {

        IContext context = new CustomContext(FILE_BEANS_PATH);
        IPet pet = context.getBean("pet.class");
        Zoo zoo = new Zoo(pet);
        zoo.doSmth();
    }
}
