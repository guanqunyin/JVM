package com.yin.jvm.c03_classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFirstClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = "D:\\IdeaProjects\\PatchDueDate\\out\\production\\JoinMainPaper\\com\\sqlview\\test\\testCopyFile.class";

        File file = new File(path);
        byte[] b = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i = 0;
            b = fileInputStream.readAllBytes();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(b, 0, b.length);
    }

}
