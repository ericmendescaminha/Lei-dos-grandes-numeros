package test;

import domain.RodandoApostador;

public class main {
    public static void main(String[] args) {


        for (int i = 1; i <= 10; i++) {

            String nomeApostador = "Apostador " + i;
            RodandoApostador rodandoApostador = new RodandoApostador(nomeApostador);
            Thread thread = new Thread(rodandoApostador);
            thread.start();

        }
    }
}
