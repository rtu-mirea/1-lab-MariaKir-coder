package com.company;
public class App {
    public static void main(String args[]) {
// DataType variableName = initialization;
        Student student = new Student();

        student.age = 19;
        student.course = 2;
        student.name = "Kireeva Maria"; //char 'a'
        student.isAlive = true;

        System.out.println(student);
    }
}

class Student{
    public String name;
    public int age;
    public int course;
    public boolean isAlive;

    public String toString(){
        return this.name + ", " +this.age + " y.o.";
    }
}