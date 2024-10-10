import java.util.Random;
<<<<<<< HEAD:src/domain/RodandoApostador.java
=======

// codigo feito para provar a lei dos grandes numeros, o que prova que a casa de apostas nunca sai perdendo se tiver tempo o suficiente
// nesse caso, para meios meramente ilustrativos, o apostador sempre vai apostar tudo o que ele tem, podendo perder tudo ou duplicar o dinheiro
>>>>>>> parent of 0823e8f (atendendo aos principios do POO):src/Main.java

public class Main {
    public static void main(String[] args) { //


        for (int i = 1; i <= 10; i++) { //

            String nomeApostador = "Apostador " + i; // Nome do apostador baseado na iteração
            RodandoApostador rodandoApostador = new RodandoApostador(nomeApostador);
            Thread thread = new Thread(rodandoApostador); // Passando o Runnable para uma Thread
            thread.start(); // Iniciando a thread

        }
    }
}
