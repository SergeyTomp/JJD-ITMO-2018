package hw4;

// класс учитель
public class Teacher extends Human {
    private String subject;     // что преподаёт
    private int severity;       //типа строгость
    private int experience;     //сколько лет работает

    Teacher (String subject, int severity, int experience, int age, String gender, String name){
        super.name = name;
        super.age = age;
        super.gender = gender;
        this.subject = subject;
        this.severity = severity;
        this.experience = experience;
    }

    public String getName(){
       return name;
    }

    public int getAge (){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public void setAge (int age){
        this.age = age;
    }
    public String getSubject() {
        return subject;
    }

    public int getSeverity() {
        return severity;
    }

    public int getExperience() {
        return experience;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
