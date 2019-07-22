package com.company;

public class School implements UO, GodZaDva {

    String vid;
    int age;
    String name;
    int countLern;


    public School(int age, String name, int countLern) {
        this.vid = String.valueOf(typeUO.SCHOOL);
        this.age = age;
        this.name = name;
        this.countLern = countLern;
    }

    // реализация метода интерфейса для школы(1)
    @Override
    public String getVid() {
        if(vid==String.valueOf(typeUO.SCHOOL))
            return "Школа";
        else
            return "----------"; }

    // реализация метода интерфейса для школы(2)
    @Override
    public int getAge() {
        return age;
    }

    // реализация метода интерфейса для школы(3)
    // общее количество преподавателей:
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String dop(){
        String[] messages = {
                "лучшая школа города",
                "здесь гениальный директор",
                "пожалейте своих детей!",
                "спецшкола (английский)",
                "спецшкола (информатика)",
                "гениев куют здесь!"
        };
        if(age <=2000) {
            return  "Год за два!";
        }
        else
            return  messages[randMessage()];
    }

    public int randMessage(){
        return ((int)(Math.random()*5)); // генератор индекса от 0 до 5
    }
}
