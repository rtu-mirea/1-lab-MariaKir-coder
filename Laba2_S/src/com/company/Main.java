package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n, num=0;//номер массива, номер пункта меню
        Scanner in = new Scanner(System.in);


        while (num!=2){
            System.out.println("Операции над объектами");
            System.out.println("1. Одномерный массив");
            System.out.println("2. Exit");
            System.out.print("Выберете объект:");
            num = in.nextInt();
            switch (num) {
                case 1:
                    testArray();
                case 2:
                    return;

            }
        }
        testArray();
    }
    public static void testArray(){
        int n, flag; //размер массива; определяет ввод
        Scanner in= new Scanner(System.in);
        try {
            System.out.print("Введите кол-во эл-тов массива: ");
            n = in.nextInt();
            Array array = new Array(n);

            System.out.print("Заполнить массив с клавиатуры (1) или рандомно (2): ");
            flag = in.nextInt();
            if(flag==2)
                array.randInput(10, 100);
            else array.consoleInput();
            array.consoleOutputRight();

            System.out.print("Вывести массив справа-налево (да(1), нет(2)): ");
            flag = in.nextInt();
            if (flag==1)
                array.consoleOutputLeft();

            System.out.print("На ск-ко увел-ть эл-ты массива, располож. на чет. местах : ");
            flag=in.nextInt();
            array.increaseValues(flag);
            System.out.print("Массив с увеличенными значениями на " +flag+". ");
            array.consoleOutputRight();

            System.out.println("Четные элементы отсортированные по возрастанию:");
            for (long item : array.even()){
                System.out.println(item);
            }

            System.out.println("Нечетные элементы");
            for (long item : array.noEven()){
                System.out.println(item);
            }


                }catch (Exception e){
                    System.out.println(e.toString());
                }
            }

    }


