package com.company;

public class VUZ implements UO{

    String vid;
    int age; // год основания
    String name;
    int countProf;
    int countDoc;
    int countAssist;

    public VUZ(int age, String name, int countProf, int countDoc, int countAssist){
        this.vid = String.valueOf(typeUO.VUZ);
        this.age = age;
        this.name = name;
        this.countProf = countProf;
        this.countDoc = countDoc;
        this.countAssist = countAssist;
    }
    // реализация метода интерфейса (1)
    public String getVid() {
        if(vid==String.valueOf(typeUO.VUZ))
            return "ВУЗ";
        else
            return "----------";
    }
    // реализация метода интерфейса (2)
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    // реализация метода интерфейса (3)
    // общее количество преподавателей вуза:
    @Override
    public int getCount() {
        return (countProf + countDoc + countAssist);
    }

    // общее количество преподавателей вузов, открытых до 2000 года (дополнительный сведения)
    @Override
    public String dop(){
        if(this.age<=2000){
            return ("В " + getName() + " " + String.valueOf(getCount())) + " преподавателей";
        }
        return "Это современный ВУЗ!";
    }
}
