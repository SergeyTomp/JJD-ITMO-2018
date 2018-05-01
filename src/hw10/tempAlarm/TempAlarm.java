package hw10.tempAlarm;

public class TempAlarm implements Listener {

    private int temperature;
    private int alarmTemp;
    private Informer informer;
    private boolean showFlag = false;
    private String signal;

    public TempAlarm(Informer informer, int alarmTemp, String colour){
        this.informer = informer;
        informer.addAlarm(this);
        this.alarmTemp = alarmTemp;
        signal = colour;
    }
    @Override
    public void update(int temperature) {
        this.temperature = temperature;
        if (temperature > alarmTemp && !showFlag) {
            showFlag = true;
            show();
        }
        if (temperature < alarmTemp) {
            showFlag = false;
        }
    }

    void show (){
        System.out.println("        " + signal + ": T > " + alarmTemp + "deg C");
    }
}
