package org.example;

public class InfoRunnable implements Runnable {
    // para lanzar un thread es necesario crear una implementacion de Runnable
    // 1 implementamos la interfaz runnable
    // 2 obliga a sobreescribir el método Run
    // en este caso, identificamos el hilo concreto usando los métodos estáticos de la clase thread

    @Override
    public void run() {
        System.out.println("opa ahí hilillo molón! Te llamas: " + Thread.currentThread().getName());
    }
}
