package com.company;

public class Horse{
    private String name; // имя лошади
    private float resultRace; // время забега

    // конструктор с инициализацией "руками"
    public Horse(String name, float resultRace) {
        this.name = name;
        this.resultRace = resultRace;
    }
    // конструктор с полуавтоматической инициализацией:
    public Horse(String name) {
        this.name = name;
        initResult(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getResultRace() {
        return resultRace;
    }

    public void setResultRace(float resultRace) {
        this.resultRace = resultRace;
    }

    // инициализатор времени забега
    public void initResult(String name){
        float res = 1+(float)(Math.random()*180); // будем считать, что максимальное время забега 3 минуты
        //System.out.println("Лошадь " + getName() + " пришла к финишу за " + res + " секунд");
        setResultRace(res);
    }

    @Override
    public String toString() {
        return "[Лошадь " + this.name + ", результат: " + this.resultRace + " сек.]";
    }

}
