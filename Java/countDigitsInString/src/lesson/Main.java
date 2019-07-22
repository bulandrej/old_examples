package lesson;

/* Напишите программу, которая
 печатает все цифры, входящие в заданную строку
 и подсчитывает количество вхождений каждой цифры.  */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите строку для обработки: ");
        String str = sc.nextLine();

        String strOut = new String(str);
        for (int i = 0; i <strOut.length() ; ) {
            if(!Character.isDigit(strOut.charAt(i))) {
                strOut = strOut.replace(String.valueOf(strOut.charAt(i)), "");
            }
            else
                i++;
        }

        if(strOut.length()!=0) {
            System.out.print("\nЦифры, найденные в строке: " + strOut + "\n\n");
            CountDigitInString cds = new CountDigitInString();
            cds.showCountDigit(strOut);
        }
        else
            System.out.print("\nВ заданной строке не найдено ни одной цифры!\n\n");
    }
}
