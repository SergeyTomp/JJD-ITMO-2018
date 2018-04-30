package hw10.tempAlarm;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements Notifier {
    private List observers;
    private int temperature;

    public Sensor() {
        observers = new ArrayList();
    }

    @Override
    public void addAlarm(TempAlarm sens) {
        observers.add(sens);
    }

    @Override
    public void removeAlarm(TempAlarm obs) {
        int i = observers.indexOf(obs);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyAlarm() {
        for (int i = 0; i < observers.size(); i++) {
            Observer obs = (Observer) observers.get(i);
            obs.update(temperature);
        }
    }

    public void changeTemp(int temp) {
        this.temperature = temp;
        System.out.println("Temperature = " + temp + "deg C");
        notifyAlarm();
    }
}
