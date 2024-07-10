import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do Jogador: ");
        String heroName = scanner.nextLine();

        int quantidadeDeVitorias = 0;
        boolean validate = false;

        while (!validate) {
            System.out.print("Digite a quantidade de vitórias desse Jogador: ");
            try {
                quantidadeDeVitorias = scanner.nextInt();
                validate = true;

            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número inteiro.");
                scanner.next(); 
            }
        }
        
        int quantidadeDeDerrotas = 0;
        validate = false;
        while (!validate) {
            System.out.print("Digite a quantidade de derrotas desse Jogador: ");
            try {
                quantidadeDeDerrotas = scanner.nextInt();
                validate = true;

            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número inteiro.");
                scanner.next(); 
            }
        }
        scanner.close();

        int winRate = calcularWinrate(quantidadeDeVitorias, quantidadeDeDerrotas);
        
        String classificacao = definirRank(winRate);

        System.out.println("O herói " + heroName + " tem a saldo de vitórias de: " + winRate + " e está na classificação: " + classificacao);

    }

    public static int calcularWinrate(int quantidadeDeVitorias, int quantidadeDeDerrotas){
        int resultado = quantidadeDeVitorias - quantidadeDeDerrotas;
        return resultado; 
    }

    public static String definirRank(int winRate){
        TreeMap<Integer, String> classificacao = new TreeMap<>();
        classificacao.put(0, "Ferro");
        classificacao.put(11, "Bronze");
        classificacao.put(21, "Prata");
        classificacao.put(51, "Ouro");
        classificacao.put(81, "Diamante");
        classificacao.put(91, "Lendário");
        classificacao.put(101, "Imortal");

        Map.Entry<Integer, String> entry = classificacao.floorEntry(winRate);
        
        String rank = (entry != null) ? entry.getValue() : "Ferro";
        
        return rank;
    }
}
