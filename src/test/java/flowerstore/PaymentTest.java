package flowerstore;

import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentTest {
    PayPalPaymentStrategy paypal;
    CreditCardPaymentStrategy card;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        paypal = new PayPalPaymentStrategy();
        card = new CreditCardPaymentStrategy();
    }

    @org.junit.jupiter.api.Test
    void pay() {
        assertEquals("Payed with PayPal", paypal.pay(20));
        assertEquals("Payed with credit card", card.pay(20));
    }
}
