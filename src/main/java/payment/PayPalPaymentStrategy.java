package payment;

public class PayPalPaymentStrategy implements Payment {
    @Override
    public String pay(double price) {
        return "Payed with PayPal";
    }
}
