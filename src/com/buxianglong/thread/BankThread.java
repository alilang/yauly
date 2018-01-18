package com.buxianglong.thread;

public class BankThread implements Runnable {

    private Bank bank = null;
    
    public BankThread(Bank bank) {
        this.bank = bank;
    }
    @Override
    public void run() {
        for(int i = 0;i < 5; i++)
        {
            bank.setAccount(1);
        }

    }

}
