package com.company;
import java.util.Scanner;
import com.company.Swimmer;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 3.\n" +
                "    Написать программу для решения следующей задачи.\n" +
                "    В первый день пловец проплыл 3 км. В каждый следующий день он проплывал на 10% больше, чем в предыдущий.\n" +
                "    а) В какой по счету день пловец начнет проплывать более 5 км?\n" +
                "    б) К какому дню он суммарно проплывет более 30 км?");
        System.out.print("\n\n");

        Scanner x = new Scanner(System.in); // объект для сканера

        double distance = 3000;

        Swimmer sw = new Swimmer();
        System.out.println("\nПункт а):");
        System.out.print("\nПловец начнет проплывать более 5 км на "+ sw.swimDay(5000)+ " по счёту день.\n\n");
        System.out.println("\nПункт б):");
        System.out.print("\nПловец суммарно проплывет более 30 км к " + sw.swimSum(30000)+ " дню.\n\n");
    }
}

