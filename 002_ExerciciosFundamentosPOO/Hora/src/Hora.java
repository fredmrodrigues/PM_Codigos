import java.util.Scanner;

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    public Hora(int horas, int minutos, int segundos) {
        if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59 || segundos < 0 || segundos > 59) {
            throw new IllegalArgumentException("Horário inválido.");
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Hora adicionarMinutos(int m) {
        int novaHora = (this.horas + (this.minutos + m) / 60) % 24;
        int novoMinuto = (this.minutos + m) % 60;
        return new Hora(novaHora, novoMinuto, this.segundos);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
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

        int horas = solicitarInteiro("Digite a hora (0-23): ", scanner, 0, 23);
        int minutos = solicitarInteiro("Digite os minutos (0-59): ", scanner, 0, 59);
        int segundos = solicitarInteiro("Digite os segundos (0-59): ", scanner, 0, 59);

        Hora horaAtual = new Hora(horas, minutos, segundos);
        System.out.println("Hora definida: " + horaAtual);

        while (true) {
            System.out.println("\n1 - Adicionar minutos");
            System.out.println("2 - Sair");
            int opcao = scanner.nextInt();

            if (opcao == 2) {
                System.out.println("Programa encerrado.");
                break;
            }

            if (opcao == 1) {
                int min = solicitarInteiro("Quantos minutos deseja adicionar? ", scanner, 1, 1440);
                horaAtual = horaAtual.adicionarMinutos(min);
                System.out.println("Nova hora: " + horaAtual);
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

}
