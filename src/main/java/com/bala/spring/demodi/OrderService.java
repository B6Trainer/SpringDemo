package com.bala.spring.demodi;

public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService initialized");
    }

    public void processOrder(String product, Integer quantity) {
        System.out.println("Processing order: " + product + " quantity " + quantity);

        double price = 120.0; // Assume a fixed price for simplicity
        double totalAmount = price * quantity;
        System.out.println("Total amount: " + totalAmount);

        paymentService.processPayment(totalAmount);

    }

    // Open for extension but closed for modification
}
