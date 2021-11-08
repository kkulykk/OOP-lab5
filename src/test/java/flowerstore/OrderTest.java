package flowerstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.Receiver;
import user.Sender;
import user.User;


import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();

    }

    @Test
    void addItem() {
        Flower item1 = new Flower(12, 40, new int[]{123,23,23}, FlowerType.ROSE);
        Flower item2 = new Flower(12, 40, new int[]{123,23,23}, FlowerType.CHAMOMILE);
        order.addItem(item1);
        order.addItem(item2);
        assertEquals(order.orderSize(), 2);
    }

    @Test
    void removeItem() {
        Flower item1 = new Flower(12, 40, new int[]{123,23,23}, FlowerType.ROSE);
        Flower item2 = new Flower(12, 40, new int[]{123,23,23}, FlowerType.CHAMOMILE);
        order.addItem(item1);
        order.addItem(item2);
        order.removeItem(item1);
        assertEquals(order.orderSize(), 1);
    }

    @Test
    void calculateTotalPrice() {
        Flower item1 = new Flower(15, 40, new int[]{123,23,23}, FlowerType.ROSE);
        Flower item2 = new Flower(20, 40, new int[]{123,23,23}, FlowerType.CHAMOMILE);
        order.addItem(item1);
        order.addItem(item2);
        assertEquals(order.calculateTotalPrice(), 35);
    }

    @Test
    void addUser() {
        Receiver user1 = new Receiver();
        Sender user2 = new Sender();
        order.addUser(user1);
        order.addUser(user2);
        assertEquals(order.usersAmount(), 2);
    }

    @Test
    void removeUser() {
        Receiver user1 = new Receiver();
        order.addUser(user1);
        order.removeUser(user1);
        assertEquals(order.usersAmount(), 0);
    }

    @Test
    void notifyUser() {
        Receiver user1 = new Receiver();
        order.addUser(user1);
        order.notifyUser(user1);
        assertEquals("status1", user1.getStatus());
    }



    @Test
    void notifyUsers() {
        Receiver user1 = new Receiver();
        Sender user2 = new Sender();
        order.addUser(user1);
        order.addUser(user2);
        order.notifyUsers();
        assertEquals("status1", user1.getStatus());
        assertEquals("status1", user1.getStatus());
    }

}