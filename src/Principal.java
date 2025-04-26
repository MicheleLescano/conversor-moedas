
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiService api = new ApiService();
        Conversor conversor = new Conversor(api);

        while (true) {
            System.out.println("\n===== Seja bem-vindo(a) ao Conversor de Moedas =====\n");
            System.out.println("1 - Dólar Americano (USD) → Real Brasileiro (BRL)");
            System.out.println("2 - Euro (EUR) → Real Brasileiro (BRL)");
            System.out.println("3 - Peso Argentino (ARS) → Real Brasileiro (BRL)");
            System.out.println("4 - Real Brasileiro (BRL) → Dólar Americano (USD)");
            System.out.println("5 - Real Brasileiro (BRL) → Euro (EUR)");
            System.out.println("6 - Real Brasileiro (BRL) → Peso Argentino (ARS)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            System.out.println("\n**********************************");
            int opcao = scanner.nextInt();
            System.out.println("\n**********************************");
            if (opcao == 0) break;

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            conversor.converter(opcao, valor);
        }

        System.out.println("Encerrando o conversor. Até mais!");
    }
}
