package org.nexai.spring_container.example.container;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomContext implements IContext{

    private Map<String, Data> beans;

    public CustomContext(String configPath) {
        init(configPath);
    }

    private void init(String configPath) {
        beans = new HashMap<>();
        Path path = Path.of(configPath);

        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(element -> {
                String[] split = element.split("=");
                if (split.length > 1) {
                    String classPath = split[1];
                    Data data = buildData(classPath);
                    beans.put(split[0], data);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getBean(String name) {
        Data data = beans.get(name);
        return (T) data.instance;
    }

    public <T> T getBean(String name, Class<T> clazz) {
        Data data = beans.get(name);
        return clazz.cast(data.instance);
    }


    static class Data {
        Object instance;
        Class aClass;

        public Data(Object instance, Class aClass) {
            this.instance = instance;
            this.aClass = aClass;
        }
    }

    private Data buildData(String classPath) {
        try {
            Class<?> aClass = Class.forName(classPath);
            Object instance = aClass.getDeclaredConstructor().newInstance();
            return new Data(instance, aClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
