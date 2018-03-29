package hw3;

//немного не успел, доделаю в выходные, гдяньте краем глаза
// заселение пока по 1 чел.
// у человека один параметр - этаж
//очередь через LinkedList
//учёт свободных квартир через Hashtable, так, попробовать использование

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;

class House {
    int section;                            //количество подъездов
    int floors;                             //количество этажей
    int flatsPerFloor;                      //квартир на этаже
    String address;                         // условный адрес
    Hashtable <Integer, Integer> soldFlats; //число занятых квартир на этаже


    House (int section, int floors, int flatsPerFloor, String address) {
        this.section = section;
        this.floors = floors;
        this.flatsPerFloor = flatsPerFloor;
        this.address = address;
        soldFlats = new Hashtable <Integer, Integer>(floors * flatsPerFloor);
        for(int i = 1 ; i<= floors; i++) {
            soldFlats.put(i,0);
        }
    }
    String getAddress (){
        return address;
    }
    int getFloors (){
        return floors;
    }

    int getSoldFlats (){
        int sold =0;
        for(int i = 1 ; i<= floors; i++) {
            sold = sold + soldFlats.get(i);
        }
        return sold;
    }
    boolean checkToSell (Buer buer){
        int tmp = soldFlats.get(buer.bestFloor);
        if (tmp != 0){
            tmp -= 1;
            soldFlats.put (buer.bestFloor, tmp);
        }
        else{
            return false;
        }
    }
}

class Buer {
    int bestFloor;

    Buer(int bestFloor) {
        this.bestFloor = bestFloor;
    }
}

public class Building {

    public static void main (String [] args){
        LinkedList <Buer> queue = new LinkedList<>();
        Random bestFloor = new Random();        //склонность к этажу определяем как случайную
        House house = new House(5, 5, 5, "Алрес_1");
        for (int i = 0; i < 125; i++){
            queue.addFirst(new Buer (bestFloor.nextInt(5);
        }
        for (int i = 0; i < queue.size(); i++){
            if (house.checkToSell(queue.getLast())){
                house.soldFlats.put(i,(house.soldFlats.get(i)-1));
            }
            else {
                queue.addLast(queue.getLast());
                queue.removeFirst();
            }
        }
    }
}
