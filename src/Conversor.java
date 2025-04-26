public class Conversor {
    private final ApiService api;

    public Conversor(ApiService api) {
        this.api = api;
    }

    public void converter(int opcao, double valor) {
        String de = "", para = "";

        switch (opcao) {
            case 1 -> { de = "USD"; para = "BRL"; }
            case 2 -> { de = "EUR"; para = "BRL"; }
            case 3 -> { de = "ARS"; para = "BRL"; }
            case 4 -> { de = "BRL"; para = "USD"; }
            case 5 -> { de = "BRL"; para = "EUR"; }
            case 6 -> { de = "BRL"; para = "ARS"; }
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        double taxa = api.buscarTaxa(de, para);
        double convertido = valor * taxa;

        System.out.printf("→ %.2f %s = %.2f %s (taxa: %.4f)%n", valor, de, convertido, para, taxa);
    }
}

