import java.util.Random;
import java.util.Scanner;

public class Combate {
    Personagem jogador;
    Inimigo inimigo;

    public Combate(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void iniciarCombate() {
        Scanner scanner = new Scanner(System.in);
        while (jogador.hp > 0 && inimigo.hp > 0) {
            System.out.println("\nSua vez de agir!");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Itens");
            System.out.println("4. Fugir");
            System.out.print("Escolha uma ação: ");
            int escolha = scanner.nextInt();

            if (jogador instanceof Slayer) {
                Slayer slayer = (Slayer) jogador;
                switch (escolha) {
                    case 1:
                        System.out.println("Escolha um tipo de ataque:");
                        System.out.println("1. Ataque Poderoso");
                        System.out.println("2. Defesa Sólida");
                        System.out.println("3. Intimidação");
                        System.out.print("Digite sua escolha: ");
                        int ataqueEscolha = scanner.nextInt();
                        switch (ataqueEscolha) {
                            case 1:
                                slayer.ataquePoderoso(inimigo);
                                break;
                            case 2:
                                slayer.defesaSolida();
                                break;
                            case 3:
                                slayer.intimidacao(inimigo);
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("\nVocê se prepara para a defesa, aumentando sua chance de evitar o ataque.");
                        jogador.ac += 2;
                        break;
                    case 3:
                        if (jogador.temItem) {
                            System.out.println("\nVocê usa um item (Poção de Cura) e recupera 10 HP.");
                            jogador.hp += 10;
                            jogador.temItem = false;
                        } else {
                            System.out.println("\nVocê não tem itens para usar.");
                        }
                        break;
                    case 4:
                        tentarFugir();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } else if (jogador instanceof BruxaPoderosa) {
                BruxaPoderosa bruxa = (BruxaPoderosa) jogador;
                switch (escolha) {
                    case 1:
                        System.out.println("Escolha um tipo de ataque:");
                        System.out.println("1. Encantamento");
                        System.out.println("2. Necromancia");
                        System.out.println("3. Ilusão");
                        System.out.print("Digite sua escolha: ");
                        int ataqueBruxa = scanner.nextInt();
                        switch (ataqueBruxa) {
                            case 1:
                                bruxa.encantamento(inimigo);
                                break;
                            case 2:
                                bruxa.necromancia(inimigo);
                                break;
                            case 3:
                                bruxa.ilusao(inimigo);
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("\nVocê se prepara para a defesa, aumentando sua chance de evitar o ataque.");
                        jogador.ac += 2;
                        break;
                    case 3:
                        if (jogador.temItem) {
                            System.out.println("\nVocê usa um item (Poção de Cura) e recupera 10 HP.");
                            jogador.hp += 10;
                            jogador.temItem = false;
                        } else {
                            System.out.println("\nVocê não tem itens para usar.");
                        }
                        break;
                    case 4:
                        tentarFugir();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } else if (jogador instanceof Vampiro) {
                Vampiro vampiro = (Vampiro) jogador;
                switch (escolha) {
                    case 1:
                        System.out.println("Escolha um tipo de ataque:");
                        System.out.println("1. Golpe Vampírico");
                        System.out.println("2. Regeneração");
                        System.out.println("3. Hipnose");
                        System.out.print("Digite sua escolha: ");
                        int ataqueVampiro = scanner.nextInt();
                        switch (ataqueVampiro) {
                            case 1:
                                vampiro.golpeVampirico(inimigo);
                                break;
                            case 2:
                                vampiro.regeneracao();
                                break;
                            case 3:
                                vampiro.hipnose(inimigo);
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("\nVocê se prepara para a defesa, aumentando sua chance de evitar o ataque.");
                        jogador.ac += 2;
                        break;
                    case 3:
                        if (jogador.temItem) {
                            System.out.println("\nVocê usa um item (Poção de Cura) e recupera 10 HP.");
                            jogador.hp += 10;
                            jogador.temItem = false;
                        } else {
                            System.out.println("\nVocê não tem itens para usar.");
                        }
                        break;
                    case 4:
                        tentarFugir();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }

            inimigoAtacar();
            System.out.println("Inimigo: " + inimigo.hp + " HP restantes.");
            System.out.println("Você: " + jogador.hp + " HP restantes.");
        }

        if (jogador.hp <= 0) {
            System.out.println("\nVocê foi derrotado... Tente novamente.");
        } else if (inimigo.hp <= 0) {
            System.out.println("\nVocê derrotou o inimigo!");
        }
    }

    public void inimigoAtacar() {
        Random rand = new Random();
        int dano = rand.nextInt(6) + 4;
        System.out.println("O inimigo ataca e causa " + dano + " de dano!");
        jogador.hp -= dano;
    }

    public void tentarFugir() {
        Random rand = new Random();
        int chance = rand.nextInt(2);
        if (chance == 0) {
            System.out.println("\nVocê conseguiu fugir com sucesso!");
        } else {
            System.out.println("\nVocê falhou em fugir e o inimigo continua atacando!");
            inimigoAtacar();
        }
    }
}
