package hw4;

//класс, как постоянная группа учеников от поступления до окончания школы
public class Flow {

    private String classID;
    private Teacher supervisor;
    Journal flowJournal;

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


