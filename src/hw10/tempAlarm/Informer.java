package hw10.tempAlarm;

interface Informer {
    public void addAlarm(TempAlarm sens);
    public void removeAlarm(TempAlarm sens);
    public void notifyAlarm();
}
