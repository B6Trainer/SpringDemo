package com.bala.reactivate.demodi;

public class StartService {

    public static void main(String[] args) {

        PaymentService paymentService1 = new StripePaymentService();
        StripePaymentService paymentService = new StripePaymentService();

        PayPalPaymentService payPalPaymentService = new PayPalPaymentService();

        //Dependency Injection
        OrderService orderService = new OrderService(payPalPaymentService);

        orderService.processOrder("Laptop", 4);


    }
}
