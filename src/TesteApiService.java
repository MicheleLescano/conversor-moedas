import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;

public class TesteApiService {

    public static void main(String[] args) {
        // Instancia o serviço de API
        ApiService apiService = new ApiService();

        // Faz a requisição para obter a taxa de conversão
        double taxaConversao = apiService.buscarTaxa("BRL", "USD"); // Agora o valor é do tipo double

        // Exibindo a taxa de conversão no console
        System.out.println("Taxa de conversão BRL para USD: " + taxaConversao);

        // Analisando a resposta JSON com o JsonParser, simulando o JSON da API
        // JSON de exemplo para  ver como funciona a análise
        String jsonExemplo = "{ \"result\": \"success\", \"conversion_rates\": { \"USD\": 0.18, \"EUR\": 0.16 } }";

        // Analisar o JSON
        analisarJson(jsonExemplo);
    }

    public static void analisarJson(String json) {
        try {
            // Convertendo a resposta JSON para um objeto JsonObject
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            // Extraindo o campo "result" diretamente
            String resultado = jsonObject.get("result").getAsString();
            System.out.println("Resultado da resposta: " + resultado);

            // Extraindo as taxas de conversão
            JsonObject taxas = jsonObject.getAsJsonObject("conversion_rates");
            double usd = taxas.get("USD").getAsDouble();
            double eur = taxas.get("EUR").getAsDouble();

            // Exibindo as taxas no console
            System.out.println("Taxa USD: " + usd);
            System.out.println("Taxa EUR: " + eur);
        } catch (Exception e) {
            System.out.println("Erro ao analisar o JSON: " + e.getMessage());
        }
    }
}

