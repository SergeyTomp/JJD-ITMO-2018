package hw12.pizzaHut;

public enum OrderStatus {
    IDLE ("Заказ не оформлен"),
    WAITING ("Заказ в ожидании официанта"),
    ORDERED ("Заказ принят официантом у клиента"),
    IN_WORK ("Заказ передан официантом повару"),
    PREPARED ("Готовый заказ передан поваром официанту"),
    DELIVERY ("Готовый заказ на пути к клиенту"),
    RECEIPT ("Заказ получен клиентом");

    String status;
    OrderStatus(String str) {
        status = str;
    }

    public String getStatus() {
        return status;
    }
}
