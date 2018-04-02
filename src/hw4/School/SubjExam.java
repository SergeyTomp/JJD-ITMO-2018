package hw4.School;

import java.util.ArrayList;

public class SubjExam extends Exam {

    Flow examFlow;
    Subject examSubject;

    SubjExam (Flow examFlow, Subject examSubject){
        this.examFlow = examFlow;
        this.examSubject = examSubject;
        questions = new ArrayList<>();
    }
}
