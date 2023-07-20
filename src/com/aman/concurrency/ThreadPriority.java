package com.aman.concurrency;

public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());//Main thread of System(Main)
        // output Thread[#1,main,5,main] ...Priority 5, name main

        Thread thread1 = new Thread(new EmailInvitation());
        Thread thread2 = new Thread(new DataAggrigator());

        thread1.setName("EmailInvitation");// Information purposes which is which
        thread2.setName("DataAggregator");

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();

    }
}

class EmailInvitation implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            if(i==5){
                Thread.yield();// influence the scheduler current thread willing to yield to threads priority of above and equal
            }
        }
    }
}

class DataAggrigator implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <=10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}


