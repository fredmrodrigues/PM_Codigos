import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartidaBasquete {
    private final List<Integer> pontosEquipe1 = new ArrayList<>();
    private final List<Integer> pontosEquipe2 = new ArrayList<>();

    public PartidaBasquete() {
        for (int i = 0; i < 4; i++) {
            pontosEquipe1.add(0);
            pontosEquipe2.add(0);
        }
    }

    public void adicionarPontos(int quarto, int equipe, int pontos) {
        if (equipe == 1) {
            pontosEquipe1.set(quarto, pontosEquipe1.get(quarto) + pontos);
        } else {
            pontosEquipe2.set(quarto, pontosEquipe2.get(quarto) + pontos);
        }
    }

    public void adicionarProrrogacao(int equipe1, int equipe2) {
        pontosEquipe1.add(equipe1);
        pontosEquipe2.add(equipe2);
    }

    public String obterPlacarFinal() {
        int total1 = pontosEquipe1.stream().mapToInt(Integer::intValue).sum();
        int total2 = pontosEquipe2.stream().mapToInt(Integer::intValue).sum();
        return total1 > total2 ? "Equipe 1 venceu!" : total1 < total2 ? "Equipe 2 venceu!" : "Empate!";
    }

    public void exibirPlacar() {
        System.out.print("\nQ1  Q2  Q3  Q4");
        for (int i = 4; i < pontosEquipe1.size(); i++) {
            System.out.print("  P" + (i - 3));
        }
        System.out.println("  FINAL");

        System.out.print("Equipe1 ");
        pontosEquipe1.forEach(p -> System.out.print(p + "  "));
        System.out.println();

        System.out.print("Equipe2 ");
        pontosEquipe2.forEach(p -> System.out.print(p + "  "));
        System.out.println();
    }

    public static int solicitarInteiro(String mensagem, Scanner scanner) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensagem);
            scanner.next();
        }
        return scanner.nextInt();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PartidaBasquete partida = new PartidaBasquete();

        for (int i = 0; i < 4; i++) {
            System.out.println("Digite os pontos do  Q" + (i + 1));
            int pontos1 = solicitarInteiro("Equipe 1: ", scanner);
            int pontos2 = solicitarInteiro("Equipe 2: ", scanner);
            partida.adicionarPontos(i, 1, pontos1);
            partida.adicionarPontos(i, 2, pontos2);
        }

        while (partida.obterPlacarFinal().equals("Empate!")) {
            System.out.println("\nEmpate! Digite os pontos da prorrogação:");
            int pontos1 = solicitarInteiro("Equipe 1: ", scanner);
            int pontos2 = solicitarInteiro("Equipe 2: ", scanner);
            partida.adicionarProrrogacao(pontos1, pontos2);
        }

        partida.exibirPlacar();
        System.out.println("\n" + partida.obterPlacarFinal());

        scanner.close();
    }

}
