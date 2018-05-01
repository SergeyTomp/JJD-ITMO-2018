package hw10.tempAlarm;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements Informer {
    private List listeners;
    private int temperature;

    public Sensor() {
        listeners = new ArrayList();
    }

    @Override
    public void addAlarm(TempAlarm sens) {
        listeners.add(sens);
    }

    @Override
    public void removeAlarm(TempAlarm obs) {
        int i = listeners.indexOf(obs);
        if (i >= 0) {
            listeners.remove(i);
        }
    }

    @Override
    public void notifyAlarm() {
        for (int i = 0; i < listeners.size(); i++) {
            Listener obs = (Listener) listeners.get(i);
            obs.update(temperature);
        }
    }

    public void changeTemp(int temp) {
        this.temperature = temp;
        System.out.println("Temperature = " + temp + "deg C");
        notifyAlarm();
    }
}
