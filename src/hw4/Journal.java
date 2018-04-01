package hw4;

import java.util.Hashtable;

public class Journal {
    Hashtable <String, Integer> dayMark;            // дата - оценка
    Hashtable <String, Hashtable> subjDayMark;      // предмет - дата - оценка
    Hashtable <String, Hashtable> pupilSubjDayMark;  // ученик - предмет - дата - оценка
}
