package lesson;

import java.util.ArrayList;

import static lesson.Colors.turquoisebg;
import static lesson.Colors.whitebg;

public class Table {

    public static void DrawT(ArrayList<Athlete> at){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println(turquoisebg+"|   Фамилия   | Возраст |   вид спорта  | лучший результ. |"+whitebg);

        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < at.size(); i++) {
            System.out.printf("|%-13s|%-9d|%-15s|%-17f|", " "+at.get(i).getName(), at.get(i).getAge(), at.get(i).getSport(), at.get(i).ThisResult() );
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------");
    }

}
