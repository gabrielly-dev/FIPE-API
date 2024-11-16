package br.com.alura.veiculo.servicos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("Erro na API: " + response.statusCode());
                return null;
            }
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao se conectar com a API: " + e.getMessage());
            return null;
        }
    }
}
