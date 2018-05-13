package hw12.pizzaHut;

import java.util.ArrayList;
import static hw12.pizzaHut.OrderStatus.*;

public class Cooker implements Runnable {
//    private ArrayList<OrderStatus> wakeUp = new ArrayList<>();
    private OrderStatus wakeUp = ORDERED;
    private final Order order;
    Cooker (Order order){
        this.order = order;
//        wakeUp.add(ORDERED);
//        wakeUp.add(IN_WORK);
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                synchronized (order) {
                    order.wait();
                    if (order.getStat() == wakeUp){
//                    if (wakeUp.contains(order.getStat())){
                        order.changeStatus();
                        System.out.println(order.getStat().getStatus());
                        order.notifyAll();
                        if (order.getStat() == PREPARED){
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
            catch (InterruptedException e){
                System.out.println("Smth wrong in Cooker");
            }
        }
    }
}
