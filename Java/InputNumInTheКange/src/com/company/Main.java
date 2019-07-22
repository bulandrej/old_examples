package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 1.\n" +
                "    Написать цикл для ввода числа в заданном диапазоне. Диапазон допустимых значений задан программно.\n" +
                "    Если число введенное пользователем не попадает в заданный диапазон, выводится сообщение об ошибке\n" +
                "    и у пользователя повторно запрашивается число. Цикл продолжается до тех пор, пока пользователь не\n" +
                "    введет правильное значение.");
        System.out.print("\n\n");

        Scanner x = new Scanner(System.in); // объект для сканера
/*        Scanner num1 = new Scanner(System.in);
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
        }*/

        System.out.print("\nЗаданы границы диапазона от -10.2344 до 56.643534\n");
        double n1  = -10.2344;
        double n2  = 56.643534;
        double num;
        //System.out.println(num);

        int count = 0;
        do{
            if (count>0)
            System.out.print("\nСнова введите число для проверки: ");
            else
                System.out.print("\nВведите число для проверки: ");
            num = x.nextDouble();
            count++;
            if (num >= n2|| num <= n1)
                System.out.println("Число не вписывается в диапазон!");
            else
                System.out.println("Число в диапазоне!");

        }while(num >= n2|| num <= n1);
    }
}
