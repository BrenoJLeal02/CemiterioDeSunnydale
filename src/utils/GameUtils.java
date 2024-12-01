package utils;

import java.util.Random;
import java.util.Scanner;

public class GameUtils {

    public int rolarDados() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public int rolarDadosComExibicao() {
        Random random = new Random();
        printSeparador(20);
        System.out.println("Rolando os dados...");
        printSeparador(20);
        int resultado = random.nextInt(20) + 1;
        System.out.println("Resultado da rolagem: " + resultado);
        printSeparador(20);
        return resultado;
    }

    public static int readInt(String prompt, int userChoices) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());

            }catch(Exception e){
                input = -1;
                System.out.println("Por favor utilize um número inteiro!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    //Simula a limpeza do console
    public static void limparConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //separador com tamanho = n
    public static void printSeparador(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    // print do titulo
    public static void printTitulo(String title) {
        printSeparador(30);
        System.out.println(title);
        printSeparador(30);
    }

    public static void printMenu() {
        limparConsole();
        System.out.println("Escolha suas ações:");
        printSeparador(20);
        System.out.println("(1) Continuar jornada");
        System.out.println("(2) Status do Personagem");
        System.out.println("(3) Sair do jogo");
    }

    //Para o jogo até o usuário digitar algo e dar enter
    public static void continuarHistoria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite qualquer coisa e pressione enter para continuar...");
        scanner.next();
    }
}
