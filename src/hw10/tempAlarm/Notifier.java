package hw10.tempAlarm;

interface Notifier{
    public void addAlarm(TempAlarm sens);
    public void removeAlarm(TempAlarm sens);
    public void notifyAlarm();
}
