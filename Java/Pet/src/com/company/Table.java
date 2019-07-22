package com.company;

public class Table {

    public void Top(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|    вид     |     кличка    |     возраст    |    имя владельца   |");
        System.out.println("--------------------------------------------------------------------");
    }

    public void ShowLine(Pet p){
        System.out.printf("|%-12s|%-15s|%-16d|%-20s|", p.getType(), p.getNickname(), p.getAge(), p.getNameOwner());
        System.out.println();
    }

    public void Bot(){
        System.out.println("--------------------------------------------------------------------");
    }

}