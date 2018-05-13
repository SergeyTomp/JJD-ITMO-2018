package hw12.pizzaHut;

import static hw12.pizzaHut.OrderStatus.*;


public class Order {
//    OrderStatus[] statArr = {IDLE, WAITING, ORDERED, IN_WORK, PREPARED, DELIVERY, RECEIPT};
    private OrderStatus[] statArr = {IDLE, WAITING, ORDERED, PREPARED, DELIVERY, RECEIPT};
    private int i = 0;
    private OrderStatus stat;
    Order(){
        stat  = statArr [0];
    }
    public void changeStatus(){
            i =  (i < (statArr.length-1)) ?  i+1 : 0;
//        if (i < statArr.length - 1){
//            i++;
//        }
//        else {
//            i = 0;
//        }
        stat = statArr [i];
    }

    public OrderStatus getStat() {
        return stat;
    }
}
