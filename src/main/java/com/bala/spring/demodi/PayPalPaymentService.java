package com.bala.spring.demodi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PayPalPaymentService implements PaymentService {

    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing payment with Paypal: " + amount);
    }

}
