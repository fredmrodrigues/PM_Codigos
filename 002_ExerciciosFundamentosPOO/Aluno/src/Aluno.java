import java.util.Scanner;

public class Aluno {
    private final double[] exercicios = new double[4];
    private final double[] provas = new double[2];
    private double trabalho;
    private int frequencia;

    public void inserirNotas(Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            exercicios[i] = solicitarDouble("Nota do exercício " + (i + 1) + ": ", scanner);
        }
        for (int i = 0; i < 2; i++) {
            provas[i] = solicitarDouble("Nota da prova " + (i + 1) + ": ", scanner);
        }
        trabalho = solicitarDouble("Nota do trabalho prático: ", scanner);
        frequencia = solicitarInteiro("Número de aulas assistidas (0-40): ", scanner, 0, 40);
    }

    public double calcularNotaFinal() {
        double mediaExercicios = (exercicios[0] + exercicios[1] + exercicios[2] + exercicios[3]) / 4 * 0.2;
        double mediaProvas = (provas[0] + provas[1]) / 2 * 0.6;
        return mediaExercicios + mediaProvas + trabalho;
    }

    public boolean aprovado() {
        return calcularNotaFinal() >= 60 && frequencia >= 30;
    }

    public static double solicitarDouble(String mensagem, Scanner scanner) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. " + mensagem);
            scanner.next();
        }
        return scanner.nextDouble();
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
        Aluno aluno = new Aluno();
        aluno.inserirNotas(scanner);

        System.out.println("Nota final: " + aluno.calcularNotaFinal());
        System.out.println(aluno.aprovado() ? "Aprovado!" : "Reprovado.");

        scanner.close();
    }

}
