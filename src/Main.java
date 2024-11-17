
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha um personagem para iniciar o jogo:");
            System.out.println("1. Bruxa Poderosa");
            System.out.println("2. Slayer");
            System.out.println("3. Vampiro");
            System.out.println("4. Sair");
            System.out.print("Digite o número da opção: ");
            int choice = scanner.nextInt();

            Personagem personagemSelecionado = null;

            switch (choice) {
                case 1:
                    System.out.println("Você escolheu a Bruxa Poderosa!");
                    personagemSelecionado = criarPersonagem(scanner, "Bruxa Poderosa");
                    break;
                case 2:
                    System.out.println("Você escolheu o Slayer!");
                    personagemSelecionado = criarPersonagem(scanner, "Slayer");
                    break;
                case 3:
                    System.out.println("Você escolheu o Vampiro!");
                    personagemSelecionado = criarPersonagem(scanner, "Vampiro");
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    continue;
            }

            if (personagemSelecionado != null) {
                personagemSelecionado.displayStats();

                System.out.println("Deseja começar sua jornada com esse personagem? (S/N)");
                String iniciarJogo = scanner.next();
                if (iniciarJogo.equalsIgnoreCase("S")) {
                    personagemSelecionado.iniciarNarrativa();
                    break;
                } else {
                    System.out.println("Voltando à seleção de personagens...");
                }
            }
        }

        scanner.close();
    }

    public static Personagem criarPersonagem(Scanner scanner, String tipo) {
        System.out.print("Digite o nome do seu " + tipo + ": ");
        String nome = scanner.next();
        if (tipo.equals("Bruxa Poderosa")) {
            return new BruxaPoderosa(nome);
        } else if (tipo.equals("Slayer")) {
            return new Slayer(nome);
        } else if (tipo.equals("Vampiro")) {
            return new Vampiro(nome);
        }
        return null;
    }
}