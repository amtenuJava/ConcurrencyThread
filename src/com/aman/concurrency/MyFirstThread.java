package com.aman.concurrency;


import java.util.concurrent.TimeUnit;

public class MyFirstThread {
    public static void main(String[] args)  {
        Task task=new Task();
        Thread thread=new Thread(task);
        thread.start(); //Once thread finishes , it changes to Terminted state so we cann't start or restart it

        try {
//            Thread.sleep(3000);   //main thread sleeps for 3 seconds , not to overburden resources
                                       // disadvantage is unit of measure is only milli seconds
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e){
         e.printStackTrace();
        }

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