package hw4.Diary;

public class Week {

    int weekNumb;
    Day [] week;

    Week (int weekNumb){
        this.weekNumb = weekNumb;
        this.week = new Day[7];
        for (int i = 0; i < 7; i++){
            week [i] = new Day (i + 1);
        }

    }
    public Day getDay (int dayNum){
        return week [dayNum - 1];
    }
 }
