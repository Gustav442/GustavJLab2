package com.example;

import java.util.List;

public class TestBankService implements BankService {



    @Override
    public void pay(String id, double amount) {
        if (id.equals("Gustav"))
        throw new RuntimeException();

    }
}
