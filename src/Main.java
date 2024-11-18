
import main.GameLogic;

public class Main {
    public static void main(String[] args) {
        GameLogic.startGame();
    }
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Escolha um personagem para iniciar o jogo:");
//            System.out.println("1. Bruxa Poderosa");
//            System.out.println("2. FactoryPersonagem.Slayer");
//            System.out.println("3. FactoryPersonagem.Vampiro");
//            System.out.println("4. Sair");
//            System.out.print("Digite o número da opção: ");
//            int choice = scanner.nextInt();
//
//            Personagem personagemSelecionado = null;
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Você escolheu a Bruxa Poderosa!");
//                    personagemSelecionado = criarPersonagem(scanner, "Bruxa Poderosa");
//                    break;
//                case 2:
//                    System.out.println("Você escolheu o FactoryPersonagem.Slayer!");
//                    personagemSelecionado = criarPersonagem(scanner, "FactoryPersonagem.Slayer");
//                    break;
//                case 3:
//                    System.out.println("Você escolheu o FactoryPersonagem.Vampiro!");
//                    personagemSelecionado = criarPersonagem(scanner, "FactoryPersonagem.Vampiro");
//                    break;
//                case 4:
//                    System.out.println("Saindo do jogo...");
//                    return;
//                default:
//                    System.out.println("Opção inválida, tente novamente.");
//                    continue;
//            }
//
//            if (personagemSelecionado != null) {
//                personagemSelecionado.displayStats();
//
//                System.out.println("Deseja começar sua jornada com esse personagem? (S/N)");
//                String iniciarJogo = scanner.next();
//                if (iniciarJogo.equalsIgnoreCase("S")) {
//                    personagemSelecionado.iniciarNarrativa();
//                    break;
//                } else {
//                    System.out.println("Voltando à seleção de personagens...");
//                }
//            }
//        }
//
//        scanner.close();
//    }
//
//    public static Personagem criarPersonagem(Scanner scanner, String tipo) {
//        System.out.print("Digite o nome do seu " + tipo + ": ");
//        String nome = scanner.next();
//        if (tipo.equals("Bruxa Poderosa")) {
//            return new Bruxa(nome);
//        } else if (tipo.equals("FactoryPersonagem.Slayer")) {
//            return new Slayer(nome);
//        } else if (tipo.equals("FactoryPersonagem.Vampiro")) {
//            return new Vampiro(nome);
//        }
//        return null;
//    }
}