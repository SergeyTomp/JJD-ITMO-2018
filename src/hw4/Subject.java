package hw4;

// класс школьный предмет
public class Subject {
    private String title;   // название
    private int level;      //год изучения

    Subject (String title, int level){
        this.title = title;
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public int getLevel() {
        return level;
    }
}
