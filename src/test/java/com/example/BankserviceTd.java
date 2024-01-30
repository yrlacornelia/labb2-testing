package com.example;
public class BankserviceTd implements BankService {
    private boolean shouldThrowException = true;

    public void setShouldThrowException(boolean shouldThrowException) {
        this.shouldThrowException = shouldThrowException;
    }

    @Override
    public void pay(String id, double amount) {
        if (shouldThrowException) {
            throw new RuntimeException("Runtime Exception from BankService Stub");
        } else {
            System.out.println("Payment successful for employee with id: " + id);
        }
    }
}
