import java.util.Scanner;

public class Calculadora {

    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não permitida.");
        }
        return a / b;
    }

    public static double solicitarDouble(String mensagem, Scanner scanner) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. " + mensagem);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        while (true) {
            System.out.println("\nEscolha a operação:");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 5) {
                System.out.println("Calculadora encerrada.");
                break;
            }

            double num1 = solicitarDouble("Digite o primeiro número: ", scanner);
            double num2 = solicitarDouble("Digite o segundo número: ", scanner);

            try {
                switch (opcao) {
                    case 1 -> System.out.println("Resultado: " + calc.somar(num1, num2));
                    case 2 -> System.out.println("Resultado: " + calc.subtrair(num1, num2));
                    case 3 -> System.out.println("Resultado: " + calc.multiplicar(num1, num2));
                    case 4 -> System.out.println("Resultado: " + calc.dividir(num1, num2));
                    default -> System.out.println("Opção inválida.");
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
