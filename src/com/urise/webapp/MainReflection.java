package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainReflection {

    public static void main(String[] args) throws  NoSuchMethodException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
//        System.out.println(field.getName());
//        System.out.println(field.get(r));
//        field.set(r, "new_uuid");

        // TODO : invoke r.toString via reflection
        Method[] findToString = r.getClass().getMethods();
        for (Method m : findToString) {
            System.out.println(m.toString());
        }
        r.getClass().getMethod("toString");
    }
}
