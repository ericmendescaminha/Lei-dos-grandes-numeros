import java.util.Random;

// codigo feito para provar a lei dos grandes numeros, o que prova que a casa de apostas nunca sai perdendo se tiver tempo o suficiente
// nesse caso, para meios meramente ilustrativos, o apostador sempre vai apostar tudo o que ele tem, podendo perder tudo ou duplicar o dinheiro

public class Main {
    public static void main(String[] args) { //


        for (int i = 1; i <= 1_000; i++) {

            String nomeApostador = "Apostador " + i;
            RodandoApostador rodandoApostador = new RodandoApostador(nomeApostador);
            Thread thread = new Thread(rodandoApostador);
            thread.start();

        }
    }
}
class RodandoApostador implements Runnable {

    private String nome;
    private double apostador = 3_000; // Saldo inicial do apostador
    private Random random = new Random();
    private static double saldoBanca = 0;  // Atributo estático compartilhado por todas as threads para o saldo da banca

    public RodandoApostador(String nome) {
        this.nome = nome;
    }

    private synchronized void atualizarBanca(double valor) {
        saldoBanca += valor;
    }

    @Override
    public void run() {

        while (apostador>=1){ // enquanto o apostador ter dinheiro

            int numeroAleatorio = random.nextInt(100) + 1;

            if (numeroAleatorio > 49){ //quando ele perde
                System.out.print(nome + " perdeu uma, saldo era " + apostador + " agora é ");
                atualizarBanca(+apostador);
                apostador= apostador - apostador;
                System.out.println(apostador);
                System.out.println("Saldo da banca atualizado: " + saldoBanca);
            }

            if (numeroAleatorio <= 49){ // quando ele ganha
                System.out.print(nome + " ganhou uma, saldo era " + apostador + " agora é ");
                atualizarBanca(-apostador);
                apostador= apostador + apostador;
                System.out.println(apostador);
                System.out.println("Saldo da banca atualizado: " + saldoBanca);
            }
        }

        if (apostador <= 0 ){ // quando ele não tem mais nada
            System.out.println(nome + " perdeu tudo");
        }
    }}