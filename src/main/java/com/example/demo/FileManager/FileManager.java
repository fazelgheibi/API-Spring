package com.example.demo.FileManager;

import com.example.demo.Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FileManager {
    private String name;
    private File file;

    //-------------------------------------------Constructor------------------------------------------------------------

    public FileManager(String name) {
        this.name = name;
        this.file = new File(name + ".txt");
    }

    //-----------------------------------------Write on File------------------------------------------------------------

    public void Write(HashSet<Product> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            for (Product product : list) {
                objectOutputStream.writeObject(product);
            }
            objectOutputStream.close();
            dataOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------Read from File-----------------------------------------------------------

    public HashSet<Product> Read() {
        HashSet<Product> list = new HashSet<>();
        if (this.file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.file);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
                boolean isExist = true;
                while (isExist) {
                    Product obj = (Product) objectInputStream.readObject();
                    if (obj == null) {
                        isExist = false;
                    } else {
                        list.add(obj);
                    }
                }
                fileInputStream.close();
                dataInputStream.close();
                objectInputStream.close();
            } catch (Exception e) {
            }
        }
        return list;
    }

    //------------------------------------------------------------------------------------------------------------------

}//END Of CLASS
