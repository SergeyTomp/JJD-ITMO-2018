package hw4.Diary;

public class Year {
    private Week [] year;
    private int yearNumb;

    Year(int yearNumb){
        this.yearNumb = yearNumb;
        this.year = new Week [52];
        for (int i = 0; i < 52; i++){
            year [i] = new Week (i+1);
        }
    }
    public int getYearNumb (Year year){
        return yearNumb;
    }
    public Week getWeek (int weekNumb){
        return year [weekNumb - 1];
    }
}
