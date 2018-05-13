package hw12.pizzaHut;

class PizzaHut {

    private Thread waiterThread,cookerThread;
    private Waiter waiter1;
    private Cooker cooker1;

    PizzaHut (Order order){

        waiter1 = new Waiter(order);
        cooker1 = new Cooker(order);
        waiterThread = new Thread(waiter1);
        cookerThread = new Thread(cooker1);
        waiterThread.start();
        cookerThread.start();
    }
}
