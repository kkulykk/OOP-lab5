package flowerstore;

import delivery.DHLDeliveryStrategy;
import delivery.Delivery;
import lombok.Getter;
import lombok.Setter;
import payment.Payment;
import user.User;

import java.util.LinkedList;

@Getter @Setter
public class Order {
    private LinkedList<User> users;
    private LinkedList<Item> items;
    private Payment payment;
    private Delivery delivery;

    public Order() {
        items = new LinkedList<>();
        users = new LinkedList<>();
    }

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }
    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public int orderSize() {return items.size();}

    public double calculateTotalPrice() {
        double result = 0;
        for (Item item : items) {
            result += item.getPrice();
        }
        return result;
    }

    public void processOrder() {
        payment.pay(150);
        delivery.deliver(items);
        notifyUsers();
    }

    public void addUser(User user) {
        users.add(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }
    public int usersAmount() {return users.size();}
    public void notifyUser(User user) {
        user.update("status1");
    }
    public void notifyUsers() {
        for (User user : users) {
            user.update("status1");
        }
    }
    public void order() {
        notifyUsers();
    }
}
