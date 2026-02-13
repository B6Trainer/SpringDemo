package com.bala.reactivate.demodi;

public class StripePaymentService implements PaymentService {

    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing payment with Stripe: " + amount);
    }

    public void processSpecialPayment(Double amount) {
        System.out.println("Processing special payment with Stripe: " + amount);
    }
}
