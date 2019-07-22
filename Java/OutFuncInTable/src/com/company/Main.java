package com.company;
import java.util.Scanner;
import com.company.Function;


public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 2.\n" +
                "        Написать программу, которая выводит таблицу значений функции\n" +
                "        на заданном интервале.\n" +
                "        Границы интервала и шаг задаются пользователем.\n" +
                "        f(x) = x*x, если x < 0,  и\n" +
                "        f(x) = x, если x >= 0");
        System.out.print("\n\n");

       Scanner step = new Scanner(System.in); // шаг приращения значения

         Scanner num1 = new Scanner(System.in);
        Scanner num2 = new Scanner(System.in);

        System.out.print("Введите нижнюю границу диапазона чисел: ");
        double n1  = num1.nextDouble();

        System.out.print("Введите верхнюю границу диапазона чисел: ");
        double n2  = num2.nextDouble();

        if (n1>n2){
            double tmp = n2;
            n2 = n1;
            n1 = tmp;
            System.out.println("Исправлена ошибка при вводе диапазона чисел.");
        }

        if (n1==n2){
            System.out.println("Диапазон чисел задан неверно!");
            return;
        }

        System.out.print("Введите шаг приращения аргумента функции: ");
        double st = step.nextDouble();
        //double n1 = -11.2343;
        //double n2 = 11.4545;
        double x = n1;
        int count = 0;

        System.out.print("\n\n");
        System.out.println("Таблица вычисленных значений функции: ");

        Function F = new Function();
        do{
            if(count == 0)
                F.showStrip();

            F.showValueFunc(x);

            x += st; // приращение аргумента
            if(x >= n2)
                F.showStrip();
            count++;
        }while(x <n2);
    }
}

