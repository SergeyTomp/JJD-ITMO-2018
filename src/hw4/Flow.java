package hw4;

//класс, как постоянная группа учеников от поступления до окончания школы
public class Flow {

    private String classID;         // идентификатор класса, 1А, 9Б и т.д.
    private Teacher supervisor;     // классрук
    Journal flowJournal;            // журнал класса, он же "база данных" класса

    Flow(Teacher supervisor, String classID, Journal flowJournal) {
        this.supervisor = supervisor;
        this.classID = classID;
        this.flowJournal = flowJournal;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public Teacher getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }
}


