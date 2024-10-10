import java.util.Random;

public class Main {
    public static void main(String[] args) {//


        for (int i = 1; i <= 10; i++) {

            String nomeApostador = "Apostador " + i;
            RodandoApostador rodandoApostador = new RodandoApostador(nomeApostador);
            Thread thread = new Thread(rodandoApostador);
            thread.start();

        }
    }
}
class RodandoApostador implements Runnable {

    private String nome;
    private double apostador = 300;
    private Random random = new Random();
    private static double saldoBanca = 0;

    public RodandoApostador(String nome) {
        this.nome = nome;
    }

    private synchronized void atualizarBanca(double valor) {
        saldoBanca += valor;
    }

    @Override
    public void run() {

        while (apostador>=1){

            int numeroAleatorio = random.nextInt(100) + 1;

            if (numeroAleatorio > 49){
                System.out.print(nome + " perdeu uma, saldo era " + apostador + " agora é ");

                atualizarBanca(+apostador);
                apostador= apostador - apostador;

                System.out.println(apostador);

                System.out.println("Saldo da banca atualizado: " + saldoBanca);
            }

            if (numeroAleatorio <= 49){

                System.out.print(nome + " ganhou uma, saldo era " + apostador + " agora é ");

                atualizarBanca(-apostador);
                apostador= apostador + apostador;

                System.out.println(apostador);

                System.out.println("Saldo da banca atualizado: " + saldoBanca);
            }
        }

        if (apostador <= 0 ){
            System.out.println(nome + " perdeu tudo");
        }
    }}