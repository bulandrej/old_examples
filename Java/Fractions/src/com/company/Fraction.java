package com.company;

import java.util.Scanner;

import static com.company.Colors.*;

public class Fraction {
    private int m; // числитель
    private int n; // знаменатель

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Fraction() {
        this.m = 1;
        this.n = 2;
    }

    public Fraction(int m, int n) {
        this.m = m;
        if(n!=0)
        this.n = n;
        else{ n=1;
            System.out.println(red + "Исправлена попытка присвоить знаменателю нулевое значение!" + black);
        }
    }

    @Override
    public String toString(){
        return (m+"/"+n);
    }

    // округление до трёх знаков после запятой
    public double decimalFraction(){
        return (double)Math.round(((double)this.m/(double) this.n) * 1000d) / 1000d;
    }
    // сложение
    public static Fraction addition(Fraction one, Fraction two){
        Fraction sum = new Fraction(0,1);
        sum.m = one.m * two.n  +  two.m * one.n;
        sum.n = one.n * two.n;
        return sum;
    }
    // умножение
    public static Fraction multiplication(Fraction one, Fraction two){
        Fraction result = new Fraction(0,1);
        result.m = one.m * two.m;
        result.n = one.n * two.n;
        return result;
    }
    // увеличение числителя либо знаменателя дроби по выбору пользователя
    public static Fraction increase(Fraction f){

        System.out.print("Нажмите 'Ч' для выбора увеличения числителя дроби\n" +
                " либо любую другую кнопку для увеличения знаменателя.\n" +green+
                " *работаем с дробью " + f.toString() + black);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.equalsIgnoreCase("Ч")||s.equalsIgnoreCase("X")){
            f.m++;
            return f;
        }
        else {
            f.n++;
            if(f.n!=0) return f;
            else{
                System.out.println(red + "Увеличение знаменателя заблокировано.\n" + black + blue + "Дробь останется прежней" + black);
                f.n--;
                return f;
            }
        }
    }
}
