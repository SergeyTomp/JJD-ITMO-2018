package hw3;

// заселение по 1 чел.
// у человека один параметр - нужный этаж
// очередь покупателей через LinkedList с удалением элемента при успешном заселении, останутся только неудачники, перемещённые в конец
// учёт проданных квартир через Hashtable, так, попробовать использование
// предпочтения по этажу задаётся случайным образом
// адрес дома задаётся, но не используется, просто по сути задачи не нужен
// для проверки корректности кода в начале количество покупателей равно количеству квартир в доме,
// в итоге должно остатся равное кол-во свободных квартир и неудачников

import java.util.Hashtable;
import java.util.LinkedList;

class House {
    private int section;                            // количество подъездов
    private int floors;                             // количество этажей
    private int flatsPerFloor;                      // квартир на этаже
    private String address;                         // условный адрес, не используется
    Hashtable <Integer, Integer> soldFlats; // число занятых квартир на этаже


    House (int section, int floors, int flatsPerFloor, String address) {
        this.section = section;
        this.floors = floors;
        this.flatsPerFloor = flatsPerFloor;
        this.address = address;
        soldFlats = new Hashtable <Integer, Integer> (section * flatsPerFloor);
        for(int i = 1; i <= floors; i++) {
            soldFlats.put(i, 0);
        }
    }

    // кол-во проданных квартир в доме
    int getSoldFlats (){
        int sold = 0;
        for(int i = 1 ; i <= floors; i++) {
            sold = sold + soldFlats.get(i);
        }
        return sold;
    }
    // остаток квартир в доме для заселения
    int getFtatsForSale (){
        return (section * flatsPerFloor * floors - getSoldFlats ());
    }

    // проверка возможности заселения
    boolean checkToSell (Buyer buyer){
        int tmp = soldFlats.get(buyer.bestFloor);
        if ((section * flatsPerFloor - tmp) != 0){
            return true;
        }
        else{
            return false;
        }
    }
}
// класс покупателя
class Buyer {
    int bestFloor;		        // требуемый этаж
    private boolean tested; 	// проходил ли проверку на заселение

    Buyer(int bestFloor) {
        this.bestFloor = bestFloor;
        this.tested = false;
    }

    boolean getTested (){
        return this.tested;
    }

    void setTested (){
        tested = true;
    }
}

// класс дома
public class Building {

    public static void main (String [] args){
        int section = 5;                                    // количество подъездов
        int floors = 5;                                     // количество этажей
        int flatsPerFloor = 5;                              // квартир на этаже
        String address = "Адрес_1";
        int pretenders = section * floors * flatsPerFloor;  // количество покупателей условно равно количеству квартир в доме
        LinkedList <Buyer> queue = new LinkedList<>();      // связный список для очередников

        House house = new House(section, floors, flatsPerFloor, address);   // создаём дом из 5 этажей, 5 подъездов, 5 квартир на этаже на подъезд
        for (int i = 0; i < pretenders; i++){							    // заполняем очередь покупателей
            queue.addFirst(new Buyer ((int)(Math.random() * 5 + 1)));       // склонность к этажу определяем как случайную
        }

        while ((queue.size() > 0) && (!queue.getLast().getTested())){ 	// пока список некончился или не подошли к первому перемещённому в конец
            if (house.checkToSell(queue.getLast())){				    // делаем попытку заселения очередного
                int flr = queue.getLast().bestFloor;
                house.soldFlats.put(flr,(house.soldFlats.get(flr) + 1));// кол-во свободных квартир на этаже -=
                queue.getLast().setTested();						    // это лишнее, после цикла все пролетающие переместятся в конец списка
                queue.removeLast();									    // удаляем из списка, чтобы на след. итер. взять следующий крайний
            }
            else {
                queue.getLast().setTested();						    // отмечаем факт проверки
                queue.addFirst(queue.getLast());					    // перемещаем в начало
                queue.removeLast();
            }
        }
        System.out.println("Покупателей в очереди осталось " + queue.size());
        System.out.println("Свободных квартир осталось " + house.getFtatsForSale());
    }
}
