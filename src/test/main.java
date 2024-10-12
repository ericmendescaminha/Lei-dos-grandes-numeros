package test;

import domain.RodandoApostador;

public class main {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {

            String nomeApostador = "Apostador " + i;                                     // Nome do apostador baseado na iteração
            RodandoApostador rodandoApostador = new RodandoApostador(nomeApostador);     // instanciando a Thread
            Thread thread = new Thread(rodandoApostador);                                // Passando o Runnable para uma Thread
            thread.start();                                                              // Iniciando a thread

            // preciso estudar mais thread
        }
    }
}
