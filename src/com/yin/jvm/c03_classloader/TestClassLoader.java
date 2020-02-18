package com.yin.jvm.c03_classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyFirstClassLoader myFirstClassLoader = new MyFirstClassLoader();
        Class<?> testCopyFile = myFirstClassLoader.findClass("testCopyFile");
        System.out.println(testCopyFile);
        Object o = testCopyFile.newInstance();
        Method[] methods = testCopyFile.getMethods();
        System.out.println(Arrays.toString(methods));
        for (Method method: methods) {
            System.out.println(method.getName());
            if (method.getName().equals("main"))
                method.invoke(null, (Object)new String[]{"test"});
        }
         Method main = testCopyFile.getMethod("main", String[].class);
        main.invoke(null, (Object)new String[]{"test"});
        System.out.println(o.getClass().getClassLoader());
    }
}
