import java.util.Scanner;

public class Cifra {

    public static String cifrar(String msg, int bloco) {
        StringBuilder cifrado = new StringBuilder();
        int linhas = (int) Math.ceil((double) msg.length() / bloco);
        char[][] matriz = new char[linhas][bloco];

        for (int i = 0, index = 0; i < linhas; i++) {
            for (int j = 0; j < bloco && index < msg.length(); j++, index++) {
                matriz[i][j] = msg.charAt(index);
            }
        }

        for (int j = 0; j < bloco; j++) {
            for (int i = 0; i < linhas; i++) {
                if (matriz[i][j] != '\0') {
                    cifrado.append(matriz[i][j]);
                }
            }
            cifrado.append("*");
        }

        return cifrado.toString();
    }

    public static String decifrar(String cifra, int bloco) {
        String[] partes = cifra.split("\\*");
        int linhas = partes.length;
        int maxColunas = partes[0].length();

        char[][] matriz = new char[linhas][maxColunas];

        for (int j = 0; j < linhas; j++) {
            char[] caracteres = partes[j].toCharArray();
            System.arraycopy(caracteres, 0, matriz[j], 0, caracteres.length);
        }

        StringBuilder mensagem = new StringBuilder();
        for (int i = 0; i < maxColunas; i++) {
            for (int j = 0; j < linhas; j++) {
                if (matriz[j][i] != '\0') {
                    mensagem.append(matriz[j][i]);
                }
            }
        }

        return mensagem.toString();
    }

    public static int solicitarInteiro(String mensagem, Scanner scanner, int min, int max) {
        int valor;
        do {
            System.out.print(mensagem);
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. " + mensagem);
                scanner.next();
            }
            valor = scanner.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - Cifrar mensagem");
            System.out.println("2 - Decifrar mensagem");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 3) {
                System.out.println("Programa encerrado.");
                break;
            }

            System.out.print("Digite a mensagem: ");
            String mensagem = scanner.nextLine();

            int bloco = solicitarInteiro("Digite o tamanho do bloco: ", scanner, 1, mensagem.length());

            switch (opcao) {
                case 1 -> System.out.println("Mensagem cifrada: " + cifrar(mensagem, bloco));
                case 2 -> System.out.println("Mensagem decifrada: " + decifrar(mensagem, bloco));
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

}
