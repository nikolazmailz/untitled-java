package ru.java_effective_programming.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args){
        /**
         * example 1
         * */
        Elvis elvis = Elvis.INSTANCE;
        elvis.check();

        /**
         * example 2
         * */
        ElvisStaticFactory elvisStaticFactory = ElvisStaticFactory.getInstance();
        elvisStaticFactory.check();

        ElvisStaticFactory elvisStaticFactory2 = ElvisStaticFactory.getInstance();
        elvisStaticFactory2.check();

        Class<? extends ElvisStaticFactory> esfClass = elvisStaticFactory2.getClass();
        Constructor<? extends ElvisStaticFactory> esfConstructor = null;

        try {
            esfConstructor = esfClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        ElvisStaticFactory elvisStaticFactoryNew = null;
        try {
            esfConstructor.setAccessible(true);
            elvisStaticFactoryNew = esfConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        elvisStaticFactoryNew.check();

        /**
         * example 3
         * */
        ElvisStaticFactoryError elvisStaticFactoryError = ElvisStaticFactoryError.getInstance();
        elvisStaticFactoryError.check();
        Class<? extends  ElvisStaticFactoryError> esfeClass = elvisStaticFactoryError.getClass();

        Constructor<? extends ElvisStaticFactoryError> esfeCons = null;

        try {
            esfeCons = esfeClass.getDeclaredConstructor();
            esfeCons.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            esfeCons.newInstance();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
