package lesson;

import java.util.*;
import static lesson.Gymnast.selectByAge;
import static lesson.SerialiseObj.deserialiseFile;
import static lesson.SerialiseObj.serialiseToFile;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 1.\n" +
                "Создать классы:«Спортсмен» -> «Гимнаст» и т.д. \n" +
                "Задание находится в папке с проектом\n\n");
        ArrayList<Athlete> athlets = FileIO.ReadCSV();
        //FileIO.appendCSV("Поддубный,22,гимнастика,8.47,6.17,5.25");
        //System.out.print("\n Cписок спорсменов, считанный из файла: ");
        //Table.DrawT(athlets);
        Collections.sort(athlets);
        //System.out.print("\n Отсортированный по возрасту список спорсменов: ");
        //Table.DrawT(athlets);

        // отбор по возрасту:
        ArrayList<Athlete> ageMore18 = selectByAge(athlets);
        //System.out.print("\n Отобранные по возрасту спортсмены: ");
        //Table.DrawT(ageMore18);

        serialiseToFile(ageMore18);

        ArrayList<Athlete> deserialiseList = deserialiseFile();
        System.out.print("\nДесериализованный список спортсменов: ");
        Table.DrawT(deserialiseList);
        Calendar calendar = new GregorianCalendar();
        System.out.println("\nТекущее время: " + calendar.get(Calendar.HOUR_OF_DAY) + " часов " + calendar.get(Calendar.MINUTE) + " минут.");
        System.out.println("Текущая дата: " + calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.YEAR) + ".");
        System.out.println("Выполнил Булгаков А.А., гр 42016.");
    }
}
