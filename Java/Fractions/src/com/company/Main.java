package com.company;

import static com.company.Colors.*;
import static com.company.Fraction.increase;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Задание 1.\n" +
                "Создать класс «Дробь», описывающий множество объектов – дробей вида... и т.д. - \n" +
                "файл с описанием задания находится внутри папки с проектом.\n"
        );

        //Fraction fractTest = new Fraction(1,0);
        Fraction fr1 = new Fraction();
        Fraction fr2 = new Fraction(1,6);
        Fraction fr3 = new Fraction(3,4);
        Fraction fr4 = new Fraction(2,7);

        Fraction[] frs = {fr1, fr2, fr3, fr4};
        System.out.println();
        Tables T1 = new Tables();
        System.out.print("\nТаблица 1.");
        T1.DrawT1(frs);
        System.out.println("\n");
        System.out.print("Таблица 2.");
        try {
            T1.DrawT2(frs, 2);
            //T1.DrawT2(frs, 6); // провокация исключения
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(red + "Произошёл выход за пределы масива.\n" + blue + "Проверьте индекс, передаваемый в метод отображения таблицы!"+ black);
        }catch (Exception e) {
            System.out.println(red + "Возникло исключение: "+ black + e.getMessage());
        }
        System.out.println();
        System.out.println(purple + "Полученная дробь: " + black +increase(fr1).toString());

        //Fraction fr5 = new Fraction(2,-1);
        //System.out.println(purple + "Полученная дробь: " + black +increase(fr5).toString());
    }
}
