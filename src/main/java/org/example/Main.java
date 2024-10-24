package org.example;

public class Main {
    public static void main(String[] args) {

        // CREACIÓN DE HILOS BÁSICA

        // instanciamos nuestra clase que implementa la interfaz Runnable

        InfoRunnable ir = new InfoRunnable();

        // creamos varios hilos de prueba (le pasamos la Runnable como parámetro)

        Thread t1 = new Thread(ir);
        Thread t2 = new Thread(ir);

        // usamos start() para ejecutar los hilos

        t1.start();
        t2.start();

        // en la salida se observa que el orden de creación/ejecución no siempre es la misma
        // a veces se imprime primero el hilo del nombre de t1 y otras el de t2, depende del hilo que llegue primero

        //otra forma de lanzar hilos (la runnable + un nombre de proceso)

        Thread t3 = new Thread(ir, "T3");

        // UN DATO IMPORTANTE
        // si usamos run, se ejecuta siempre desde el "main", no se crea un nuevo hilo
        // lo observamos al imprimirse el nombre del proceso como main

        t3.run();

        // sin embargo, si usamos start() vemos que se crea un hilo
        // lo observamos al imprimir el nombre del proceso como el que indicamos al instanciar Thread

        t3.start();

        // en este caso, creamos una Runnable mediante una clase anónima

        Thread t4 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("yo, sin embargo, soy una runnable anonima");
                    }
                });

        t4.start();

        // ahora creamos un hilo e implementamos Runnable mediante Lambdas

        Runnable runny = ()->{
            System.out.println("Ahora soy una runnable con lambda");
        };

        Thread t5 = new Thread(runny);
        t5.start();

        // ahora usamos el ejemplo de la clase personalizada que hereda de thread

        Thread t6 = new PrintingThread();
        t6.start();

        // para saber si un hilo terminó o no
        // el método join() es equivalente a WaitFor en procesos, es espera no activa, no consume recursos

        try {
            t6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // en este caso, por ejemplo, el hilo está en espera activa, ya que el while está preguntando siempre si sigue activo
        // esto es una mala práctica, dado que consume recursos, NO HACER

        while (t5.isAlive()){
            try {
                System.out.println("seguimos esperando");
                Thread.sleep(2000L);
                // se puede ver que el sleep se lanza siempre y cuando el proceso siga vivo en este punto


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // otros métodos
        // setpriority>>> prioridad de 1 a 10, si no se especifica es un 5 por defecto

    }

}