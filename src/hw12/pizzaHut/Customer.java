package hw12.pizzaHut;

import java.util.ArrayList;
import static hw12.pizzaHut.OrderStatus.*;

public class Customer implements Runnable {
    private ArrayList<OrderStatus> wakeUp = new ArrayList<>();
    private final Order order;
    Customer (Order order){
        this.order = order;
        wakeUp.add(IDLE);
        wakeUp.add(DELIVERY);
    }
    @Override
    public void run(){
        synchronized (order){
            System.out.println(order.getStat().getStatus());
            order.changeStatus();
            System.out.println(order.getStat().getStatus());
            order.notifyAll();
        }
        while (!Thread.currentThread().isInterrupted()){
            try {
                synchronized (order){
                    order.wait();
                    if (wakeUp.contains(order.getStat())){
                        order.changeStatus();
                        System.out.println(order.getStat().getStatus());
                        order.changeStatus();
                        if (order.getStat() == IDLE){
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Smth wrong in Customer");
            }
        }
    }
}
