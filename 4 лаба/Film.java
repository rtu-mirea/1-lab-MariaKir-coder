Файл ClassTextFile.java
        package com.company;

import java.io.*;
import java.util.Scanner;

public class ClassTextFile {
    String path;

    public ClassTextFile(String path) {
        this.path = path;
        File f = new File(path);
        if (f.exists())
            System.out.println("Файл " + f.getName() + " существует");
    }

    public PC get() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(new File(path)));
        String creator = sc.nextLine();
        String name = sc.nextLine();
        int cost = sc.nextInt();

        sc.close();
        return new PC(creator, name, cost);
    }

}

    Файл ClassSerialization.java
        package com.company;

        import java.io.*;
        import java.util.ArrayList;

public class ClassSerialization {
    String path;
    ArrayList<PC> PCs;

    public ClassSerialization(String path) {
        this.path = path;
    }

    public void setPCs(ArrayList<PC> PCs) {
        this.PCs = PCs;
    }

    public void writeObj(PC pc) throws IOException{
        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(path));
        OOS.writeObject(pc);

        OOS.close();
    }

    public PC readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path));
        PC res = (PC)OIS.readObject();

        OIS.close();
        return res;
    }

    public void writeArr() throws IOException{
        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(path));
        OOS.writeObject(PCs);

        OOS.close();
    }

    public void readArr() throws IOException, ClassNotFoundException {
        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path));
        PCs = (ArrayList<PC>)OIS.readObject();

        OIS.close();
    }

    public ArrayList<PC> getPCs() {
        return PCs;
    }

}

    Файл PC.java
        package com.company;

        import java.io.Serializable;

public class PC implements Serializable {

    String creator, name;
    int cost;

    PC(String creator, String name, int cost) throws IllegalArgumentException {
        this.creator = creator;
        this.name = name;
        if (cost < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.cost = cost;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) throws IllegalArgumentException {
        if (cost < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{Создатель: " + creator + " Название: " + name + " Цена: " + cost + "}";
    }

}