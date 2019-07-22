package com.company;

public class Film {
    private String name;
    private String nameProducer;
    private String genre;
    private int countSeries;
    //private float costSeries;

    static{

    }


    public Film() {}

    public Film(String name, String nameProducer, String genre, int countSeries) {
        this.name = name;
        this.nameProducer = nameProducer;
        this.genre = genre;
        this.countSeries = countSeries;
    }

    public String getName() {
        return name;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public String getGenre() {
        return genre;
    }

    public int getCountSeries() {
        return countSeries;
    }

    // затраты на фильм
    public float CostFilm(float costSeries){
        return costSeries*this.countSeries;
    }

    // сравнение затрат на съёмку
    public static int CompCostsFilms(Film f1, Film f2, float costPartF1, float costPartF2){
        if(f1.CostFilm(costPartF1)>(float)f2.CostFilm(costPartF2)) {
            return (1);
        } else if((float)f1.CostFilm(costPartF1)<(float)f2.CostFilm(costPartF2)) {
            return (-1);
        } else return (0);
    }

    public float increaseCost(float costPart){
        return costPart*2;
    }
}
