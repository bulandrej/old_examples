package com.company;

public class Subject extends Material {

    private String nameSubject; // название
    private double volume; // объём
    private Material material; // объект super-класса

    // конструктор по-умолчанию
    public Subject(){
        super();
    };

    // конструктор с параметрами
    public Subject(String nameSubject, String name, double density, double volume){
        super(name, density);
        this.volume = volume;
        this.nameSubject = nameSubject;
    };

    public double getVolume() {
        return volume;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double GetMass(){
        return volume*super.getDensity();
    }

    public String toString(){
        return getNameSubject() + ";" + super.getName() + ";" + super.getDensity() + ";" + getVolume() + ";" + GetMass();
    }
}
