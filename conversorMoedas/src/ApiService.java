import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    private final String API_KEY = "995bfbde27333e9a6d2db84a";
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public double buscarTaxa(String de, String para) {
        try {
            URI uri = URI.create(BASE_URL + de);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ConversaoResponse dados = new Gson().fromJson(response.body(), ConversaoResponse.class);

            // Verifica se a resposta foi bem-sucedida
            if (!"success".equals(dados.getResult())) {
                throw new RuntimeException("Erro na resposta da API.");
            }

            Double taxa = dados.getConversion_rates().get(para);
            if (taxa == null) {
                throw new RuntimeException("Moeda de destino não encontrada: " + para);
            }

            return taxa;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao acessar a API: " + e.getMessage());
        }
    }
}

