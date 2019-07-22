package lesson;

import java.math.BigDecimal;
import java.util.Scanner;

/*Задание 2

Начальный вклад в банке равен 1000 руб.
Через каждый месяц размер вклада увеличивается на P процентов от имеющейся суммы.

По данному P определить:
через сколько месяцев размер вклада превысит 1100 руб.,
и вывести
- найденное количество месяцев K
- и итоговый размер вклада S.                                                 */

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float interest = 0;
        boolean b = false;
        while (b!=true) {
            try {
                System.out.print("Введите процент для расчётов: ");
                interest = sc.nextFloat();
                System.out.println();
                b = true;
            } catch (Exception e) {
                System.out.println("Будьте внимательны при вводе!");
                sc.nextLine();
            }
        }

        BigDecimal depo = new BigDecimal(1000.0);
        BigDecimal limit = new BigDecimal(1100.0);
        BigDecimal addition;
       int i = 0;
        while (!(depo.compareTo(limit)== 0)&&!(depo.compareTo(limit)==1)) {
            addition = new BigDecimal((depo.floatValue()/100)*interest);
            depo = depo.add(addition);
            i++;
        }

        System.out.println("За "+ i + " месяцев размер вклада превысит "+BigDecimal.valueOf(limit.floatValue())+ " руб");

        System.out.print("Результирующий размер вклада составит ");
        System.out.println(depo.setScale(2, depo.ROUND_FLOOR)+ " руб");

        System.gc();
    }
}
