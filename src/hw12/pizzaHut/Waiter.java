package hw12.pizzaHut;

import java.util.ArrayList;
import static hw12.pizzaHut.OrderStatus.*;

public class Waiter implements Runnable {
    private ArrayList<OrderStatus> wakeUp = new ArrayList<>();
    private final Order order;

    Waiter(Order order){
        this.order = order;
        wakeUp.add(WAITING);
        wakeUp.add(PREPARED);
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                synchronized (order) {
                    order.wait();
                    if (wakeUp.contains(order.getStat())){
                        order.changeStatus();
                        System.out.println(order.getStat().getStatus());
                        order.notifyAll();
                        if (order.getStat() == DELIVERY){
                            Thread.currentThread().interrupt();
                        }

                    }
                }
            }
            catch (InterruptedException e){
                System.out.println("Smth wrong in Waiter");
            }
        }
    }
}
