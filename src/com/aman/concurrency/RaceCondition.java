package com.aman.concurrency;



//Race condition OutPut
//        aman is about to withdraw 75
//        Dani is about to withdraw 75
//        aman have withdrawn 75
//        Money overwithdrawn
//        Dani have withdrawn 75
//        Money overwithdrawn   //In this code 75 is withdrawn twice and Dani cannt withdraw
public class RaceCondition {
    public static void main(String[] args) {
        BankAccount bankAccountTask=new BankAccount(100);
        Thread aman=new Thread(bankAccountTask);// This thread is fine upto aman thread execution and running
        Thread Dani=new Thread(bankAccountTask);//

        aman.setName("aman");
        Dani.setName("Dani");

        aman.start();
        Dani.start();
    }

}

class BankAccount implements Runnable{
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        makeWithDrawal(75);
        if(balance<0){
            System.out.println("Money overwithdrawn ");
        }
    }

    private void makeWithDrawal(int amount) {
        if(balance>amount){
            System.out.println(Thread.currentThread().getName() + " is about to withdraw " + amount);
            balance-=amount;
            System.out.println(Thread.currentThread().getName() + " have withdrawn " + amount);
        } else {
            System.out.println("Sorry not enough amount " + Thread.currentThread().getName());
        }
    }
}
