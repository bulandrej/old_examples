package com.company;

public class Gamer {
    String name; // имя игрока
    float betting; // ставка игрока
    String nameHorse; // лошадь, на которую поставил игрок в текущем забеге

    public String getName() {
        return name;
    }

    public float getBetting() {
        return betting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBetting(float betting) {
        this.betting = betting;
    }

    // конструктор с инициализацией "руками" - если сильно хочется
    public Gamer(String name, float betting) {
        this.name = name;
        this.betting = betting;
    }
    // конструктор игроков:
    public Gamer(String name) {
        this.name = name;
        initBet();
    }
    // инициализатор ставки + выбор лошади
    public void initBet(){
        float bet = 100+(float)(Math.random()*1000); // будем считать, что макс. ставка 1000 руб., минимальная - 100 руб.
        //System.out.println("ставка игрока " + getName() + ": " + bet + "руб.");
        setBetting(bet);
    }

}


