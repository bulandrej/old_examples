package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 2\n" +
                "\n" +
                "Разработать класс «Фильм», который должен содержать следующие элементы: \n" +
                "\n" +
                "поле название, \n" +
                "статическое поле фамилия режиссера, \n" +
                "поле жанр (сериал, боевик, комедия и т.д.), \n" +
                "поле количество серий, \n" +
                "\n" +
                "конструктор с параметрами, \n" +
                "геттеры для чтения полей класса, \n" +
                "конструктор без параметров, \n" +
                "статический конструктор (статический логический блок), \n" +
                "\n" +
                "метод  для получения затрат на съемку фильма (параметр - затраты на съемку одной серии),  \n" +
                "\n" +
                "статический метод для сравнения, который принимает в качестве параметров объекты класса, \n" +
                "а в качестве результата возвращает -1, если затраты на первый фильм меньше второго, \n" +
                "ноль, если затраты равны, и 1, если первый фильм более затратный. \n" +
                "\n" +
                "В методе Main нужно создать два объекта класса «Фильм» с режиссером Люком Бессоном. \n" +
                "Данные для первого фильма вводить с клавиатуры, а для второго задавать в виде констант. \n" +
                "Вывести информацию о фильмах и сравнить затраты на их производство. \n" +
                "Увеличить в два раза затраты на съемку серии для второго фильма.\n\n"
        );


/*        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название фильма: ");
        String name  = sc.nextLine();
        System.out.print("Введите имя режиссёра: ");
        String nameProducer  = sc.nextLine();
        System.out.print("Введите название жанра: ");
        String genre  = sc.nextLine();
        System.out.print("Введите количество серий: ");
        int countSeries  = sc.nextInt();*/
        // public Film(String name, String nameProducer, String genre, int countSeries);
        Film f1 = new Film("Такси", "Люк Бессон", "боевик, комедия", 5);
        //Film f1 = new Film(name, nameProducer, genre, countSeries);
        Film f2 = new Film("Перевозчик", "Люк Бессон", "боевик, триллер", 4);

        float CostSeriesF2 = 28;

        float CostF1 = f1.CostFilm(16);
        float CostF2 = f2.CostFilm(CostSeriesF2);

        showCost("Затраты на фильмы, рассчитанные после ввода данных",f1.getName(), CostF1, f2.getName(), CostF2);
        showTable(f1, f2, CostF1, CostF2);
        // увеличение затрат на серию второго фильма
        CostF2 = f2.CostFilm(f2.increaseCost(CostSeriesF2));

        showCost("Пересчитанные затраты на фильмы",f1.getName(), CostF1, f2.getName(), CostF2);
        showTable(f1, f2, CostF1, CostF2);

    }

    public static void showCost(String title,String name1, float cost1, String name2, float cost2){
        System.out.println("\n" + title + ":");
        System.out.printf("Затраты на фильм %s: %28.6f", name1, cost1);
        System.out.printf("\nЗатраты на фильм %s: %28.6f\n", name2, cost2);
    }

    public static void showTable(Film f1, Film f2, float CostF1, float CostF2){
        Table T = new Table();

        T.Top();
        T.ShowLine(f1.getName(),f1.getNameProducer(),f1.getGenre(),f1.getCountSeries(),CostF1);
        T.ShowLine(f2.getName(),f2.getNameProducer(),f2.getGenre(),f2.getCountSeries(),CostF2);
        T.Bot();
    }
}
