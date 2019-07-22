package com.company;

import java.util.ArrayList;

public class CountTypePets {

    String typePets;
    int count;

    public CountTypePets(){}

    public CountTypePets(String typePets, int count) {
        this.typePets = typePets;
        this.count = count;
    }

    public String getTypePets() {
        return typePets;
    }

    public int getCount() {
        return count;
    }

    public void setTypePets(String typePets) {
        this.typePets = typePets;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // проверка, есть ли тип животного уже в списке:
    public boolean ExistsInList(String type, ArrayList<CountTypePets> ctps){
        boolean b = false;
        for (CountTypePets ctp : ctps) {
            if(ctp.getTypePets()==type)
                b = true;
        }
        return b;
    }

    // добавление в лист животных вместе с количеством
    public ArrayList<CountTypePets> fillingTypeSheet(ArrayList<Pet> pets){
        ArrayList<CountTypePets> ctps = new ArrayList<>();
        if(ctps!=null){
            for (Pet p:pets) {
                if(!ExistsInList(p.getType(), ctps))
                    // вносим очередной элемент в массив подсчитанных типов
                    ctps.add(new CountTypePets(p.getType(),countTypePet(p.getType(), pets)));
            }
        }
        return ctps;
    }
    // подсчёт количества животных каждого типа в списке
    public int countTypePet(String type, ArrayList<Pet> pets) {
        int n = 0;
        for (Pet pet : pets) {
            if(pet.getType()==type) n++;
        }
        return n;
    }

    public void showNumTypePets(ArrayList<CountTypePets> ctps){
        System.out.println("В списке следующее количество животных:");
        for (CountTypePets ctp : ctps) {
            System.out.println(ctp.getTypePets() + " - " + ctp.getCount() + "шт.");;
        }
    }
}
