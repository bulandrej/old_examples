package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 3.\n" +
                "Напишите программу, которая из заданного предложения, начиная с первой встретившейся \n" +
                "буквы \"а\", копирует в новую строку все символы до первой встретившейся буквы \"я\". \n" +
                "Напечатайте полученную строку.");


        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите предложение для обработки: ");
        String str = new String();
        str = sc.nextLine();

        try {
            System.out.println("\n\nСтрока, полученная после обработки: \n" + copyStrLimits(str, "а", "я"));
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("\nВ предложении не найдены соответствующие заданию символы-ограничители.\n");
        }
    }

    public static String copyStrLimits(String str, String str1, String str2){
        String s = new String();
        s = str.substring(str.indexOf(str1),str.lastIndexOf(str2));
        return s;
    }
}
