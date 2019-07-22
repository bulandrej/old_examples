package com.company;

public class Function {
/*    private double showValueFunc(double x){

        if (x<0) return (x * x);
        else {
            return x;
        }
    }*/

     void showValueFunc(double x){
         double tmp;
        if (x<0) tmp = (x * x);
        else {tmp = x;}
        System.out.print("| ");
        System.out.format("%10.3f", tmp);
        System.out.println(" |");
    }

    void showStrip(){
        System.out.println("|------------|");
    }
}
