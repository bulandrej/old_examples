package lesson;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int x;
        boolean b = false;
        while (b!=true){
            try {
                System.out.print("введите число: ");
                Scanner sc = new Scanner(System.in);
                x = sc.nextInt();

                if((int)x/100==0) {
                    System.out.println("первое число не может быть равно нулю!");
                    b = false;
                    continue;
                }
                if (Integer.toString(x).length() == 3) {
                    char c1 = Integer.toString(x).charAt(0);

                        char c2 = Integer.toString(x).charAt(1);
                        char c3 = Integer.toString(x).charAt(2);
                        //System.out.println();
                        System.out.println(numberToString(c1, c2, c3));
                        b = true;
                }
                else {
                    System.out.println("Количество введённых цифр д.б. равно трём!");
                }
            }
            catch (Exception e){
                System.out.println("Проверьте правильность ввода!");
                b = false;
            }
        }
   }

private static String numberToString(char c1, char c2, char c3){

        String res="";

        switch(c1){
        case'1':res="сто";break;
        case'2':res="двести";break;
        case'3':res="триста";break;
        case'4':res="четыреста";break;
        case'5':res="пятьсот";break;
        case'6':res="шестьсот";break;
        case'7':res="семьсот";break;
        case'8':res="восемьсот";break;
        case'9':res="девятьсот";break;
        }
        boolean shapeNum = false;
        switch(c2){
            case'1':shapeNum = true;break;
            case'2':res+=" двадцать";break;
            case'3':res+=" тридцать";break;
            case'4':res+=" сорок";break;
            case'5':res+=" пятьдесят";break;
            case'6':res+=" шестьдесят";break;
            case'7':res+=" семьдесят";break;
            case'8':res+=" восемьдесят";break;
            case'9':res+=" девяносто";break;
        }

        switch(c3){
        case'0':if(shapeNum){res+= " десять";break;}
                else{res+="";break;}
        case'1':if(shapeNum){res+=" одиннадцать";break;}
                else {res+=" один";break;}
        case'2':if(shapeNum){res+=" двенадцать";break;}
                else {res+=" два";break;}
        case'3':if(shapeNum){res+=" тринадцать";break;}
                else {res+=" три";break;}
        case'4':if(shapeNum){res+=" четырнадцать";break;}
                else {res+=" четыре";break;}
        case'5':if(shapeNum){res+=" пятнадцать";break;}
                else {res+=" пять";break;}
        case'6':if(shapeNum){res+=" шестнадцать";break;}
                else {res+=" шесть";break;}
        case'7':if(shapeNum){res+=" семнадцать";break;}
                else {res+=" семь";break;}
        case'8':if(shapeNum){res+=" восемнадцать";break;}
                else {res+=" восемь";break;}
        case'9':if(shapeNum){res+=" девятнадцать";break;}
                else {res+=" девять";break;}
        }
        return res;
    }
}




