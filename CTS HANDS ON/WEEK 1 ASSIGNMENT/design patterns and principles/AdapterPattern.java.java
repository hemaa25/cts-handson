public class AdapterPattern {

    interface PaymentProcessor {
        void processPayment(double amount);
    }

   
    static class PayPalGateway {
        void makePayment(double amount) {
  
        }
    }

    static class StripeGateway {
        void stripeCharge(double value) {
         
        }
    }

    static class SquareGateway {
        void executeTransaction(double total) {
          
        }
    }
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPal;

        public PayPalAdapter(PayPalGateway payPal) {
            this.payPal = payPal;
        }

        public void processPayment(double amount) {
            payPal.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe;

        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }

        public void processPayment(double amount) {
            stripe.stripeCharge(amount);
        }
    }

    static class SquareAdapter implements PaymentProcessor {
        private SquareGateway square;

        public SquareAdapter(SquareGateway square) {
            this.square = square;
        }

        public void processPayment(double amount) {
            square.executeTransaction(amount);
        }
    }

  
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor square = new SquareAdapter(new SquareGateway());

        paypal.processPayment(1000.0);
        stripe.processPayment(2000.0);
        square.processPayment(1500.0);

    }
}
