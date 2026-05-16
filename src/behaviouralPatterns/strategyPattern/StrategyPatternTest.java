package behaviouralPatterns.strategyPattern;

public class StrategyPatternTest {

    static void main() {
        PaymentProcessor2 paymentProcessor = new PaymentProcessor2(new CreditCardPayment());
        paymentProcessor.processPayment();

        paymentProcessor.setPaymentStrategy(new StripePayment());
        paymentProcessor.processPayment();


    }
}


/**
 * Class to show how bloated a class becomes when we need to introduce new types of behaviours
 */
class PaymentProcessor{

    public void processPayment(String paymentMethod){

        if(paymentMethod.equals("Credit Card")){
            System.out.println("Processing Payment with the credit card");
        }else if (paymentMethod.equals("PayPal")){
            System.out.println("Processing Payment with PayPal");
        } else if (paymentMethod.equals("Stripe")) {
            System.out.println("Processing Payment with Stripe");

            /*
             * Now if we need to keep adding payment methods we need to keep adding the if else blocks in this class
             * due to which we will be violating the open/closed principle.
             *
             */

        }else {
            System.out.println("Currently this payment method is not supported");
        }
    }
}


/**
 *  Payments with Strategy Pattern
*/

interface PaymentStrategy{
    void processPayment();
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing credit Card Payment");
    }
}

class PayPalPayment implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing Pay Pal Payment");
    }
}

class StripePayment implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing stripe payment");
    }
}


class PaymentProcessor2{
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor2(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(){
        paymentStrategy.processPayment();
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
}








