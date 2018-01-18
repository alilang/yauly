package com.buxianglong.thread;

public class Bank {
    private int account = 0;

    public int getAccount() {
        return account;
    }

    private void sleep() {
        double sleepTime = 2000 * Math.random();
        try {
            Thread.sleep((long) sleepTime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setAccount(int account) {
        sleep();
        this.account += account;
    }

}
