package com.example;
public class BankserviceTd implements BankService{
    private boolean payMethodCalled = false;

    @Override
    public void pay(String id, double amount) {
        payMethodCalled = true;
    }

    public boolean isPayMethodCalled() {
        return payMethodCalled;
    }
}
