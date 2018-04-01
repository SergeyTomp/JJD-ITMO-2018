package hw4;

import java.util.PrimitiveIterator;

public class Pupil extends Human{

    // класс ученика
    private int level;          // год обучения
    private String classID;     // класс
    private int performance;    // характеристика прилежности
    private int discipline;     // характеристика дисциплинированности

    Pupil (int level, String classID, int performance,int discipline,int age, String gender, String name){
        super.name = name;
        super.age = age;
        super.gender = gender;
        this.level = level;
        this.classID = classID;
        this.performance = performance;
        this.discipline = discipline;
    }

    public String getName(){
        return name;
    }

    public int getAge (){
        return age;
    }
    public void setAge(){
        super.age = age;
    }
    public int getLevel() {
        return level;
    }

    public String getClassID() {
        return classID;
    }

    public int getPerformance() {
        return performance;
    }

    public int getDiscipline() {
        return discipline;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }
}
