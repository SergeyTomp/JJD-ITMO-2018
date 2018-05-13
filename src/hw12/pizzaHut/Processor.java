package hw12.pizzaHut;

public class Processor {
    public static void main(String[] args){
        Order order = new Order();
        PizzaHut pizzHut = new PizzaHut(order);
        Customer customer1 = new Customer(order);
        Thread customerThread = new Thread(customer1);
        customerThread.start();
    }
}
