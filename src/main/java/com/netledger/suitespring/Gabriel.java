package com.netledger.suitespring;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by dbrook on 06/07/2015.
 */

// Found member of the band https://en.wikipedia.org/wiki/Genesis_%28band%29
// https://en.wikipedia.org/wiki/Abiogenesis
// https://en.wikipedia.org/wiki/Spontaneous_generation

public class Gabriel {
    public static <T> T beanToObject(BeanObj bean) {
        return new Gabriel().letThereBeLife(bean);
    }

    private <T> T letThereBeLife(BeanObj bean) {
        T obj = null;
        Class c;
        String className = bean.getClassName();

        try {
            c = Class.forName(className);
        } catch(ClassNotFoundException e) {
            System.err.println("Couldn't find '" + className + "' - " + e.getMessage());
            return obj;
        }

        try {
            obj = (T) c.newInstance();
            Map<String, String> values = bean.getValues();
            for(String fieldName : values.keySet()) {
                Field field = c.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(obj, autovivifyValue(field, values.get(fieldName)));
            }
        } catch(IllegalAccessException e) {
            System.err.println("Couldn't get at class '" + className + "' - " + e.getMessage());
        } catch(InstantiationException e) {
            System.err.println("Couldn't construct a '" + className + "' - " + e.getMessage());
        } catch(NoSuchFieldException e) {
            System.err.println("Couldn't find a field in '" + className + "' - " + e.getMessage() + " - found fields: " + Arrays.toString(c.getDeclaredFields()));
        } catch(NoSuchMethodException | InvocationTargetException e) {
            System.err.println("Couldn't instantiate a field with a (String) constructor - " + e.getMessage());
        }

        return obj;
    }

    // XXX Arguably the set() should happen here but this works for now.
    private Object autovivifyValue(Field f, String value) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c = f.getType();

        if(c.isPrimitive()) {

            if(c == Boolean.TYPE)
                return new Boolean(value);
            else if(c == Character.TYPE)
                return value.charAt(0);
            else if(c == Byte.TYPE)
                return new Byte(value);
            else if(c == Short.TYPE)
                return new Short(value);
            else if (c == Integer.TYPE)
                return new Integer(value);
            else if (c == Long.TYPE)
                return new Long(value);
            else if (c == Float.TYPE)
                return new Float(value);
            else if(c == Double.TYPE)
                return new Double(value);
            else
                // TODO Figure out what this should be.
                return Void.class;
        } else {
            // TODO Constructor arguments!
            return c.getConstructor(String.class).newInstance(value);
        }
    }
}
