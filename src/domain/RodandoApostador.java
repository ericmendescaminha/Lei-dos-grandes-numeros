package domain;

import java.util.Random;

// codigo feito para provar a lei dos grandes numeros, o que prova que a casa de apostas nunca sai perdendo se tiver tempo o suficiente
// nesse caso, para meios meramente ilustrativos, o apostador sempre vai apostar tudo o que ele tem, podendo perder tudo ou duplicar o dinheiro
// posso alterar o valor da aposta depois

public class RodandoApostador implements Runnable {

    private String nome; // Atributo para armazenar o nome do apostador
    private double saldoApostador = 300; // Saldo inicial do apostador
    private Random random = new Random(); // Instância do gerador de números aleatórios
    private static double saldoBanca = 0;  // Atributo estático compartilhado por todas as threads para o saldo da banca

    public RodandoApostador(String nome) { // Construtor que aceita o nome do apostador
        this.nome = nome;
    }

    private synchronized void atualizarBanca(double valor) { // Método sincronizado para atualizar o saldo da banca de forma segura
        saldoBanca += valor;
    }

    @Override
    public void run() {

        while (saldoApostador >= 1) {

            int numeroAleatorio = random.nextInt(100) + 1; // todo loop novo é gerado um novo numero

            if (numeroAleatorio > 49){ //quando ele perde
                System.out.print(nome + " perdeu uma, saldo era " + saldoApostador + " agora é ");

                atualizarBanca(+saldoApostador); // Atualiza o saldo da banca quando o apostador perde

                //saldoApostador =- saldoApostador;
                saldoApostador -= saldoApostador;
                //saldoApostador = saldoApostador- saldoApostador;

                System.out.println(saldoApostador);

                System.out.println("Saldo da banca atualizado: " + saldoBanca);
            }

            if (numeroAleatorio <= 49){ // quando ele ganha

                System.out.print(nome + " ganhou uma, saldo era " + saldoApostador + " agora é ");

                atualizarBanca(-saldoApostador); // Atualiza o saldo da banca quando o apostador ganha

                //saldoApostador = saldoApostador + saldoApostador;
                saldoApostador += saldoApostador;
                //saldoApostador =+ saldoApostador;

                System.out.println(saldoApostador);

                System.out.println("Saldo da banca atualizado: " + saldoBanca);
            }
        }

        if (saldoApostador <= 0) {
            System.out.println(nome + " perdeu tudo");
        }
    }}