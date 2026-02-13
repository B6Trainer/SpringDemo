package com.bala.spring.demodi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements PaymentService {

    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing payment with Stripe: " + amount);
    }

    public void processSpecialPayment(Double amount) {
        System.out.println("Processing special payment with Stripe: " + amount);
    }
}
