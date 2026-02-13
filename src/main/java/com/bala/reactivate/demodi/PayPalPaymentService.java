package com.bala.reactivate.demodi;

public class PayPalPaymentService implements PaymentService {

    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing payment with Paypal: " + amount);
    }

}
