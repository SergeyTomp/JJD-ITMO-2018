package hw10.tempAlarm;

public class TempAlarm implements Observer{

    private int temperature;
    private int prevTemp;
    private int alarmTemp;
    private Notifier notifier;
    private boolean showFlag = false;
    private String signal;

    public TempAlarm(Notifier notifier, int alarmTemp, String colour){
        this.notifier = notifier;
        notifier.addAlarm(this);
        this.alarmTemp = alarmTemp;
        signal = colour;
    }
    @Override
    public void update(int temperature) {
        prevTemp = this.temperature;
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
        System.out.println(signal + ": T > " + alarmTemp + "deg C");
    }
}
