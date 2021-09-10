package com.urise.webapp;

import com.urise.webapp.model.Resume;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Resume r = new Resume("TEST");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);

        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");

        Method method = r.getClass().getDeclaredMethod("toString");
        System.out.println(method.invoke(r).toString());
    }
}