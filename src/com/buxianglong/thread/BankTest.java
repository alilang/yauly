package com.buxianglong.thread;

public class BankTest {

    public static void main(String[] args) {
        Bank bank = new Bank();
        for(int i=0;i<1000;i++)
        {
            new Thread(new BankThread(bank)).start();
        }
        System.out.println(bank.getAccount());
    }

}
