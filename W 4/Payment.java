public class Payment {

    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }

    static class CardPayment extends Payment {

        void payWithProcessingFee(double amount) {
            double total = amount + (amount * 0.02);

            System.out.println(
                "Charged (card, incl. fee): Rs " + total
            );
        }
    }

    static double totalCollected = 0;

    static void processTransaction(
            Payment payment, double amount) {

        if (payment instanceof CardPayment) {

            CardPayment card = (CardPayment) payment;

            card.payWithProcessingFee(amount);

            totalCollected += amount + (amount * 0.02);

        } else {

            payment.pay(amount);
            totalCollected += amount;
        }
    }

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        for (int i = 0; i < payments.length; i++) {
            processTransaction(payments[i], amounts[i]);
        }

        System.out.println(
            "Total Collected: Rs " + totalCollected
        );
    }
}