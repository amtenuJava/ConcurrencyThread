package com.aman.concurrency;



public class MyFirstThread {
    public static void main(String[] args) {
        Task task=new Task();
        Thread thread=new Thread(task);
        thread.start();


        System.out.println("Inside main.....");
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside run .......");
        go();
    }

    private void go() {
        System.out.println("Inside method....");
        more();
    }

    private void more() {
        System.out.println("Inside method method");
    }


}