package com.company;

import static com.company.Colors.*;
import static com.company.Fraction.addition;
import static com.company.Fraction.multiplication;

public class Tables {

    public void DrawT1(Fraction[] f){
        System.out.println("\n--------------------------------------------------------");
        System.out.println(turquoisebg+"| № п/п  |       Дробь       |    Десятичная дробь    |"+whitebg);
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < f.length; i++) {
            System.out.printf("|%-9s|%-19s|%-24s|", ""+(i+1), f[i].toString(), f[i].decimalFraction());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
    }

    public void DrawT2(Fraction[] frs, int num){
        try {
            Fraction test = frs[num];
            //int q = 1/0; // провокация исключения
            Fraction negative = new Fraction(-1, 1);
            System.out.println("\n--------------------------------------------------------------");
            System.out.print(yellowbg + "|     Дробь     |     ");
            System.out.printf("%-9s", frs[num].toString() + "+n");
            System.out.print("|     ");
            System.out.printf("%-9s", frs[num].toString() + "-n");
            System.out.print("|     ");
            System.out.printf("%-9s", frs[num].toString() + "*n");
            System.out.println("|" + whitebg);
            System.out.println("--------------------------------------------------------------");
            for (int i = 0; i < frs.length; i++) {
                if (i != (num - 1)) {
                    System.out.printf("|%-15s|%-14s|%-14s|%-14s|", frs[i].toString(), addition(frs[num], frs[i]).toString(), addition(frs[num], multiplication(frs[i], negative)).toString(), multiplication(frs[num], frs[i]).toString());
                    System.out.println();
                }
            }
            System.out.println("--------------------------------------------------------------");
        } catch (Exception e) {
            throw e;
        }
    }
}
