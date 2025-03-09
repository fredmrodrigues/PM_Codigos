import java.util.Scanner;

public class Retangulo {
    private final int altura;
    private final int largura;
    private char borda;
    private int deslocamento;

    public Retangulo(int altura, int largura, char borda, int deslocamento) {
        this.altura = altura;
        this.largura = largura;
        this.borda = borda;
        this.deslocamento = deslocamento;
    }

    public void setBorda(char borda) {
        this.borda = borda;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public void desenhar() {
        for (int i = 0; i < altura; i++) {
            System.out.print(" ".repeat(deslocamento));

            for (int j = 0; j < largura; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == largura - 1) {
                    System.out.print(borda);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static int solicitarInteiro(String mensagem, Scanner scanner) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensagem);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static char solicitarCaractere(String mensagem, Scanner scanner) {
        System.out.print(mensagem);
        return scanner.next().charAt(0);
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int altura = solicitarInteiro("Informe a altura do retângulo: ", scanner);
        int largura = solicitarInteiro("Informe a largura do retângulo: ", scanner);
        char borda = solicitarCaractere("Informe o caractere para a borda: ", scanner);
        int deslocamento = solicitarInteiro("Informe o deslocamento do retângulo: ", scanner);

        Retangulo retangulo = new Retangulo(altura, largura, borda, deslocamento);
        
        OUTER:
        while (true) {
            retangulo.desenhar();
            System.out.println("\nOpções:");
            System.out.println("1 - Alterar caractere de borda");
            System.out.println("2 - Alterar deslocamento");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = solicitarInteiro("", scanner);
            switch (opcao) {
                case 1 -> {
                    borda = solicitarCaractere("Informe o novo caractere de borda: ", scanner);
                    retangulo.setBorda(borda);
                }
                case 2 -> {
                    deslocamento = solicitarInteiro("Informe o novo deslocamento: ", scanner);
                    retangulo.setDeslocamento(deslocamento);
                }
                case 3 -> {
                    System.out.println("Programa encerrado.");
                    break OUTER;
                }
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
