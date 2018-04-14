package hw7;

//не уверен, что правильно понял само задание, но суть enum прояснилась
enum EnumPlanet {
    EARTH(12742, 59.72e20), MOON(3476, 74e18), MERCURY(4880, 3.2e22), VENUS(12104, 48.68e23);
    private int diameter;
    private double mass;
    EnumPlanet(int d, double m){
        mass = m;
        diameter = d;
    }
    double getMass(){
        return mass;
    }

    public int getDiameter() {
        return diameter;
    }
}
class EnumDemo{
    public static void main (String[]args){
        for (EnumPlanet e : EnumPlanet.values()){
            System.out.println(e + " Diameter = " + e.getDiameter() + " km;" + " Mass = " + e.getMass() + " tons");
        }
    }
}
