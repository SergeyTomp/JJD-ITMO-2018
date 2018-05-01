package hw10.tempAlarm;

public class AlarmsTest {
    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        TempAlarm alarm100 = new TempAlarm (sensor, 100, "GREEN LIGHT");
        TempAlarm alarm300 = new TempAlarm (sensor, 300,"YELLOW LIGHT");
        TempAlarm alarm600 = new TempAlarm (sensor, 600,"RED LIGHT");
        System.out.println("\n" + "        T goes UP");
        int t = 100;
        for (; t < 800; t +=100){
            sensor.changeTemp(t);
        }
        System.out.println("\n" + "      T goes DOWN");
        for (; t > 0; t -=100) {
            sensor.changeTemp(t);
        }
        System.out.println("\n" + "        T goes UP");
        for (; t < 800; t +=100) {
            sensor.changeTemp(t);
        }
    }
}
