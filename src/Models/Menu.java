package Models;

import java.util.Scanner;

public class Menu {
    private Historico historico;

    public Menu() {
        this.historico = new Historico();
    }

    public void criaMenu() {
        Scanner ler = new Scanner(System.in);
        int opcaoBase = 0;
        double valor = 0;

        String opcoesPrimarias = """
            Selecione uma das Opções abaixo:
            1 - para Fazer Conversão
            2 - para Ver Histórico de Conversão
            3 - para Sair
            Opção desejada:
            """;

        do {
            System.out.println("|    Conversor de Moedas    |\n");
            System.out.println(opcoesPrimarias);
            opcaoBase = ler.nextInt();

            switch (opcaoBase) {
                case 1:
                    String moedaBase = definirMoeda(ler, "origem");

                    System.out.println("Digite o valor que deseja converter:");
                    valor = ler.nextDouble();

                    String moedaASerConvertida = definirMoeda(ler, "destino");

                    Conversor conversao = Conversor.fazerConversao(moedaBase, moedaASerConvertida, valor);

                    if (conversao != null) {
                        System.out.println(conversao);
                        historico.adicionarConversao(conversao);
                        historico.registrarNoHistorico();
                    } else {
                        System.out.println("Não foi possível realizar a conversão.");
                    }
                    break;
                case 2:
                    System.out.println("Histórico de Conversão:");
                    historico.exibirHistorico();
                    break;
                case 3:
                    System.out.println("Obrigada por usar o Sistema");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoBase != 3);
    }

    public String definirMoeda(Scanner ler, String textoBase) {
        int opcaoMoeda = 0;
        String opcoesDeMoeda = """
            1 - BRL (Real Brasileiro)
            2 - USD (Dólar Americano)
            3 - AUD (Dólar Australiano)
            4 - EUR (Euro)
            5 - TWD (Novo Dólar de Taiwan)
            6 - ZAR (Rand Sul-Africano)
            7 - JPY (Iene Japonês)
            """;

        String titulo = textoBase.equals("destino") ? "destino" : "origem";

        do {
            System.out.println("Selecione a Moeda de " + titulo + ": ");
            System.out.println(opcoesDeMoeda);
            opcaoMoeda = ler.nextInt();
            if (opcaoMoeda < 1 || opcaoMoeda > 7) {
                System.out.println("Opção de moeda inválida. Por favor, selecione uma opção válida.");
            }
        } while (opcaoMoeda < 1 || opcaoMoeda > 7);

        return retornaSiglaMoeda(opcaoMoeda);
    }

    public String retornaSiglaMoeda(int opcao) {
        switch (opcao) {
            case 1:
                return "BRL";
            case 2:
                return "USD";
            case 3:
                return "AUD";
            case 4:
                return "EUR";
            case 5:
                return "TWD";
            case 6:
                return "ZAR";
            case 7:
                return "JPY";
            default:
                return "Opção inválida.";
        }
    }
}