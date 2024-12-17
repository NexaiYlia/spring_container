package org.nexai.spring_container.example.container;

public interface IContext {
    <T> T getBean(String name);

    <T> T getBean(String name, Class<T> clazz);

}
