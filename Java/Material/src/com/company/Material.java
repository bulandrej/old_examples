package com.company;

public class Material {
    private String name; // название
    private double density; // плотность

    // конструктор по-умолчанию
    public Material(){};

    // конструктор с параметрами
    public Material(String name, double density){
       this.name = name;
       this.density = density;
    };

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    //@Override
    public String toString(){
        return getName() + ";" + getDensity();
     }
}
