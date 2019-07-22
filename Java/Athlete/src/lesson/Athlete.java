package lesson;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Athlete implements Serializable, Comparable<Athlete>{
    // фамилия
    private String name;
    // возраст
    private int age;
    // вид спорта (гимнастика, бокс, плавание и т.д.)
    private String sport;

    // результат:
    private float result;

    public Athlete() {
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }


    public Athlete(String name, int age, String sport) {
        this.name = name;
        this.age = age;
        this.sport = sport;
        this.result = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return sport;
    }

    public abstract float ThisResult();
    public abstract float bestResult(ArrayList<Athlete> athletes);

    // сравнение по возрасту
    @Override
    public int compareTo(Athlete athlete){
        if(age < athlete.getAge()) return -1;
        else if(age<athlete.getAge()) return 1;
        else return 0;
    }
}
