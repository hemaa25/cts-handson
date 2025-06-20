public class StrategyPattern{

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using PayPal account: " + email);
        }
    }

    static class PaymentContext {
        private PaymentStrategy strategy;

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void payAmount(double amount) {
            if (strategy != null) {
                strategy.pay(amount);
            } else {
                System.out.println("No payment method selected.");
            }
        }
    }


    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234567812345678"));
        context.payAmount(2500.00);

        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.payAmount(1200.50);
    }
}
