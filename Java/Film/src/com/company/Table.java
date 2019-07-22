package com.company;


public class Table {

    public void Top(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("|   Название фильма     |     имя режиссёра    |     жанр фильма    | количество серий | затраты на съёмку (млн. $) |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    public void Bot(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    public void ShowLine(String name, String nameProducer, String genre, int countSeries, float costFilm){
            System.out.printf("|%-23s|%-22s|%-20s|%-18d|%-28.6f|", name, nameProducer, genre, countSeries, costFilm);
        System.out.println();
    }


}
