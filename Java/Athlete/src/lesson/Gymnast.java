package lesson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Gymnast extends Athlete{

    private float scoreForRings; // оценка за упражнения на кольцах
    private float scoreForBars;  // на брусьях
    private float scoreForVault; // за опорный прыжок

    public float getScoreForRings() {
        return scoreForRings;
    }

    public float getScoreForBars() {
        return scoreForBars;
    }

    public float getScoreForVault() {
        return scoreForVault;
    }

    public void setScoreForRings(float scoreForRings) {
        this.scoreForRings = scoreForRings;
    }

    public void setScoreForBars(float scoreForBars) {
        this.scoreForBars = scoreForBars;
    }

    public void setScoreForVault(float scoreForVault) {
        this.scoreForVault = scoreForVault;
    }

    // конструктор с параметрами
    public Gymnast(String name, int age, String sport) {
        super(name, age, sport);
    }

    @Override
    public float ThisResult() {
        return scoreForRings+scoreForBars+scoreForVault;
    }

    @Override
    public float bestResult(ArrayList<Athlete> athletes) {
        Collections.sort(athletes);
        Collections.reverse(athletes);
        if(athletes.get(0).ThisResult()>0) return athletes.get(0).ThisResult();
        return -1;
    }

    @Override
    public String toString() {
        return "Спортсмен: " + this.getName() + ", " + this.getAge() + " лет, вид спорта - "+ this.getSport() + "\nРезультаты: " +
                "кольца: " + scoreForRings +
                ", брусья: " + scoreForBars +
                ", прыжок: " + scoreForVault;
    }

    public static ArrayList<Athlete> selectByAge(ArrayList<Athlete> al) {

        ArrayList<Athlete> list = new ArrayList<Athlete>();
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i).getAge()>18)
                list.add(al.get(i));
        }
        return list;
    }
}
