package org.example;

public class PrintingThread extends Thread{

    // otro método para hilos, no recomendado, es crear una clase personalizada que herede de Thread
    // eso se debe a que, al heredar de es clase, no se podría heredar de otra
    // en este sentido, es innecesario, pudiendo usar Thread directamente


    @Override
    public void run() {
        Thread myTh = Thread.currentThread();
        System.out.println("Soy la que extiende");
        System.out.println("priority: "+myTh.getPriority());
    }
}

