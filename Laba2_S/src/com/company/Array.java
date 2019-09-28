package com.company;

import java.util.Scanner;

public class Array {
    private int n;
    private long x[]; //ссылочкая переменная

    //функция выделить память
    Array(int n) throws Exception {
        if (n <= 0) throw new Exception(new String("Количество эл-тов <=0"));
        this.n = n; //this представляет в методе объект
        this.x = new long[this.n]; //выделение динамической памяти
    }

    void randInput(int min, int max) {
        for (int i = 0; i < n; i++) {
            x[i] = (long) (Math.random() * ++max) + min;
        }
    }

    void consoleInput() {
        System.out.println("Заполните массив " + n + " числами.");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            x[i] = in.nextLong();
        }
    }

    void consoleOutputRight() {
        System.out.println("Заполненный массив чисел (вывод слева-направо):");
        for (int i = 0; i < n; i++) {
            System.out.println(x[i]);
        }
    }

    void consoleOutputLeft() {
        System.out.println("Заполненный массив чисел (вывод справа-налево):");
        for (int i = n - 1; i > -1; i--) {
            System.out.println(x[i]);
        }
    }

    //Четность реализована относ-но пользователя (индексы в массиве 1,2..)
    void increaseValues(int a) {
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0)
                x[i] += a;
        }
    }

    private int numEvElem() {
        int even = 0, noEven = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] % 2 == 0 && x[i] != 0)
                even++;
        }
        return even;
    }

    private int numNoEvElem() {
        int noEven = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] % 2 != 0 && x[i] != 0)
                noEven++;
        }
        return noEven;
    }

    public long[] even() {
        int ev = numEvElem();
        int j = 0;
        long[] array2 = new long[ev];
        for (int i = 0; i < n; i++) {
            if (x[i] % 2 == 0 && x[i] != 0) {
                array2[j] = x[i];
                j++;
            }
        }
        for (int i = 1; i < ev; i++) {
            for (int k = i; (k >= 1) && (array2[k] < array2[k - 1]); k--)
            //ПОКА (arr[k] меньше arr[k-1]) И (в массиве еще есть элементы (k >= 0))
            {
                long a = array2[k];
                array2[k] = array2[k - 1];
                array2[k - 1] = a;
            }

        }
        return array2;
    }

    public long[] noEven() {
        int noEv = numNoEvElem();
        int j = 0;
        long[] array1 = new long[noEv];
        for (int i = 0; i < n; i++) {
            if (x[i] % 2 != 0 && x[i] != 0) {
                array1[j] = x[i];
                j++;
            }
        }
        return array1;

    }

}
