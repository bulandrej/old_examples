package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 4-1:\n" +
                "Записать информацию о домашних питомцах (вид, кличка, возраст, фамилия владельца)  \n" +
                "в коллекцию ArrayList.  Вывести информацию в виде таблицы. Определить количество \n" +
                "питомцев каждого вида. Записать в отдельную коллекцию фамилии владельцев тех животных, \n" +
                "возраст которых больше заданного с указанием вида питомца (для этого написать метод \n" +
                "в главном классе).\n");


        ArrayList<Pet> pets = new ArrayList<>();

        // Pet(String type, String nickname, int age, String nameOwner)
        // собака, кошка, корова, лошадь, утка, кролик
        pets.add(new Pet("собака","Шарик",8,"Иванов"));
        pets.add(new Pet("кошка","Мурка",7,"Пеликанов"));
        pets.add(new Pet("лошадь","Роза",6,"Штраус"));
        pets.add(new Pet("корова","Машка",10,"Дробышевич"));
        pets.add(new Pet("кошка","Люська",4,"Иванова"));
        pets.add(new Pet("утка","Кряква",1,"Годлевская"));
        pets.add(new Pet("кошка","Лушка",5,"Лямзин"));
        pets.add(new Pet("кролик","Арчи",6,"Мануров"));
        //pets.add("","","","");
        //pets.add("","","","");

        CountTypePets ct = new CountTypePets();
        ArrayList<CountTypePets> ctps = ct.fillingTypeSheet(pets);

        // выводим типы животных из списка с их количеством
        ct.showNumTypePets(ctps);

        System.out.println("\nСводная таблица питомцев  и их владельцев:");
        Table T = new Table();
        int i = 0;
        T.Top();
        for (Pet p:pets) {
            T.ShowLine(p);
            T.Bot();
        }

        System.out.print("\n\nВведите возраст животных для отбора имён владельцев: ");

        Scanner sc = new Scanner(System.in);
        int AGE = sc.nextInt();
        System.out.print("\n");
        showNOP(pets, AGE);
    }

    public static ArrayList<String> namesOwnersPets(ArrayList<Pet> pets, int age){
        ArrayList<String> nop  = new ArrayList<>();

        for (Pet p:pets) {
         if(age<p.getAge()) nop.add(p.getNameOwner() + ": содержит питомца " + p.getType());
        }
        return nop;
    }

    public static void showNOP(ArrayList<Pet> pets, int age){
        for(String no:namesOwnersPets(pets, age)){
            System.out.println(no);
        }
        if(namesOwnersPets(pets, age).size()==0)
            System.out.println("Не нашлось владельцев, подходящих по критерию...");
    }
}
