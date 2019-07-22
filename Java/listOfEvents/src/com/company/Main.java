package com.company;

import sun.util.locale.LocaleUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.util.*;

import static java.util.Calendar.DAY_OF_MONTH;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 3. \n" +
                "\tСоздать класс «Мероприятие» с полями: \n" +
                "\t- дата события и \n" +
                "\t- название мероприятия. \n" +
                "\t\n" +
                "\tРеализовать в нем интерфейс Comparable. \n" +
                "\t\n" +
                "\tСформировать коллекцию TreeSet из объектов этого класса. \n" +
                "\t*Каждый день может быть только одно мероприятие.\n" +
                "\t\n" +
                "\tПрограмма должна выводить следующую информацию:\n" +
                "\t\n" +
                "\uF0A7\tСписок мероприятий за последние 7 дней\n" +
                "\uF0A7\tмероприятие на завтрашний день\n" +
                "\uF0A7\tсписок мероприятий на ближайшие 5 дней, не включая сегодняшний и завтрашний дни\n\n");


        TreeSet<Evnt> evnts = new TreeSet<Evnt>();

        Collections.addAll(evnts,
                new Evnt(new GregorianCalendar(2012, 02, 27), "Театрализованный праздник"),
                new Evnt(new GregorianCalendar(2017, 12, 10), "Танцевально-развлекательная программа"),
                new Evnt(new GregorianCalendar(2010, 02, 9), "Час полезной информации"),
                new Evnt(new GregorianCalendar(2012, 05, 13), "Общее собрание"),
                new Evnt(new GregorianCalendar(2014, 02, 16), "Презентация нового курса"),
                new Evnt(new GregorianCalendar(2012, 07, 17), "Народный праздник"),
                new Evnt(new GregorianCalendar(2015, 02, 20), "Велопробег по историческим местам"),
                new Evnt(new GregorianCalendar(2016, 9, 25), "Информационно-познавательный час"),
                new Evnt(new GregorianCalendar(2016, 06, 26), "Игровая программа"),
                new Evnt(new GregorianCalendar(2016, 07, 3), "Викторина"),
                new Evnt(new GregorianCalendar(2016, 11, 30), "Сюжетно-игровая программа"),
                new Evnt(new GregorianCalendar(2016, 07, 6), "Купальские забавы"),
                new Evnt(new GregorianCalendar(2019, 04, 6), "Тематическая дискотека"),
                new Evnt(new GregorianCalendar(2018, 8, 20), "Краеведческое путешествие"),
                new Evnt(new GregorianCalendar(2019, 02, 7), "Выставка ИЗО"),
                new Evnt(new GregorianCalendar(2019, 01, 1), "Выставка ИЗО2"),
                new Evnt(new GregorianCalendar(2019, 02, 7), "Выставка ИЗО5"),
                new Evnt(new GregorianCalendar(2019, 02, 6), "Выставка ИЗО1"),
                new Evnt(new GregorianCalendar(2019, 01, 30), "Выставка ИЗО8"),
                new Evnt(new GregorianCalendar(2019, 02, 8), "Выставка ИЗО7"),
                new Evnt(new GregorianCalendar(2019, 02, 3), "Выставка ИЗО6"),
                new Evnt(new GregorianCalendar(2019, 02, 9), "Выставка ИЗО9"),
                new Evnt(new GregorianCalendar(2019, 01, 29), "Выставка ИЗО10"),
                new Evnt(new GregorianCalendar(2019, 02, 2), "Выставка ИЗО11"),
                new Evnt(new GregorianCalendar(2019, 02, 13), "Выставка ИЗО12"),
                new Evnt(new GregorianCalendar(2019, 02, 14), "Событие 1"),
                new Evnt(new GregorianCalendar(2019, 02, 15), "Событие 2"),
                new Evnt(new GregorianCalendar(2019, 02, 16), "Событие 3"),
                new Evnt(new GregorianCalendar(2019, 02, 17), "Событие 4"),
                new Evnt(new GregorianCalendar(2019, 02, 18), "Событие 5"),
                new Evnt(new GregorianCalendar(2019, 02, 19), "Событие 6")
        );

        Show(evnts, "Полный список мероприятий: ");
        EvntLast7days(evnts);
        tomorrowEvent(evnts);
        evntNext5days(evnts);
    }


    public static void Show(TreeSet<Evnt> evnt, String s) {
        System.out.println("********************************************************************");
        System.out.println(s);
        int i = 0;
        for (Evnt ev : evnt) {
            i++;
            // № события - название мероприятия - дата проведения
            System.out.print("Событие № " + i + " - " + ev.getName() + ", дата проведения ");
            System.out.printf("%s", ev.getData().get(DAY_OF_MONTH) + "." + ev.getData().get(Calendar.MONTH) + "." + ev.getData().get(Calendar.YEAR));
            System.out.println();
        }
    }

    public static GregorianCalendar stringToCalendar(String date, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date d = format.parse(date);
        //Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return (GregorianCalendar) c;
    }

    public static GregorianCalendar CalendarNow() {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        return c;
    }

    // получаем все элементы до указанной даты
    public static TreeSet<Evnt> getAllBefore(TreeSet<Evnt> in, GregorianCalendar gregCalend) {
        TreeSet<Evnt> out = new TreeSet<Evnt>();
        int n = 0;
        for (Evnt ev : in) {
            if (ev.getData().before(gregCalend)) {
                out.add(ev);
                //System.out.println("В TreeSet добавлен элемент № "+ (++n));
            }
        }
        return out;
    }

    // получаем все элементы после указанной даты
    public static TreeSet<Evnt> getAllAfter(TreeSet<Evnt> in, GregorianCalendar gregCalend) {
        TreeSet<Evnt> out = new TreeSet<Evnt>();
        int n = 0;
        for (Evnt ev : in) {
            if (ev.getData().after(gregCalend)) {
                out.add(ev);
            }
        }
        return out;
    }

    // Список мероприятий за последние 7 дней
    public static void EvntLast7days(TreeSet<Evnt> in) {
        GregorianCalendar now = CalendarNow(); // первая временнАя метка
        GregorianCalendar boundLastDay = CalendarNow();
        boundLastDay.set(DAY_OF_MONTH, (CalendarNow().get(DAY_OF_MONTH) - 9)); // вторая временнАя метка

        TreeSet<Evnt> ev1 = new TreeSet<Evnt>();
        TreeSet<Evnt> res = new TreeSet<Evnt>();

        ev1 = getAllBefore(in, new GregorianCalendar(now.get(Calendar.YEAR), (now.get(Calendar.MONTH) + 1), now.get(DAY_OF_MONTH)));
        res = getAllAfter(ev1, new GregorianCalendar(boundLastDay.get(Calendar.YEAR), (boundLastDay.get(Calendar.MONTH) + 1), boundLastDay.get(DAY_OF_MONTH)));
        Show(res, "Список мероприятий за последние 7 дней: ");
    }

    // мероприятие на завтрашний день
    public static void tomorrowEvent(TreeSet<Evnt> in) {
        System.out.println("********************************************************************");
        boolean bool = true;
        GregorianCalendar now = CalendarNow();
        now.set(DAY_OF_MONTH, (CalendarNow().get(DAY_OF_MONTH) + 1)); // завтрашний день

        System.out.print("Мероприятие на завтрашний день: ");
        for (Evnt ev : in) {
            if ((ev.getData().get(DAY_OF_MONTH) == now.get(DAY_OF_MONTH)) &&
                    (ev.getData().get(Calendar.MONTH) == (now.get(Calendar.MONTH) + 1) &&
                            (ev.getData().get(Calendar.YEAR) == now.get(Calendar.YEAR)))) {
                System.out.println(ev.getName());
                bool = false;
            }
        }
        if (bool) System.out.println("отсутствует");
        System.out.println("завтра будет: " + now.get(DAY_OF_MONTH) + "." + (now.get(Calendar.MONTH) + 1) + "." + now.get(Calendar.YEAR));
    }

    // список мероприятий на ближайшие 5 дней, не включая сегодняшний и завтрашний дни
    public static void evntNext5days(TreeSet<Evnt> in) {
        GregorianCalendar now = CalendarNow(); // первая временнАя метка
        now.set(DAY_OF_MONTH, (CalendarNow().get(DAY_OF_MONTH) + 1));
        GregorianCalendar boundLastDay = CalendarNow();
        boundLastDay.set(DAY_OF_MONTH, (CalendarNow().get(DAY_OF_MONTH) + 5)); // вторая временнАя метка

        TreeSet<Evnt> ev1 = new TreeSet<Evnt>();
        TreeSet<Evnt> res = new TreeSet<Evnt>();

        ev1 = getAllBefore(in, new GregorianCalendar(boundLastDay.get(Calendar.YEAR), (boundLastDay.get(Calendar.MONTH) + 1), boundLastDay.get(DAY_OF_MONTH)));
        res = getAllAfter(ev1, new GregorianCalendar(now.get(Calendar.YEAR), (now.get(Calendar.MONTH) + 1), now.get(DAY_OF_MONTH)));
        Show(res, "список мероприятий на ближайшие 5 дней, не включая сегодняшний и завтрашний дни: ");
        if (res.size() == 0) System.out.println("отсутствует.");
    }
}
