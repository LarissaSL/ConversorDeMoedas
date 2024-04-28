package Models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double coinValue;
    private double resultado;

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public double getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(double coinValue) {
        this.coinValue = coinValue;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public static Conversor fazerConversao(String moedaBase, String moedaASerConvertida, double valor) {
        Conversor conversor = new Conversor();
        conversor.setBase_code(moedaBase);
        conversor.setTarget_code(moedaASerConvertida);

        String chaveApi = "31f4d0d05385def2e0f9551a";
        String endereco = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/pair/" + moedaBase + "/" + moedaASerConvertida;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                Conversor conversaoResponse = gson.fromJson(response.body(), Conversor.class);
                conversor.setConversion_rate(conversaoResponse.getConversion_rate());
                conversor.setCoinValue(valor);
                conversor.setResultado(valor * conversaoResponse.getConversion_rate());
                return conversor;
            } else {
                System.out.println("Não foi possível fazer a conversão. Código de status: " + response.statusCode());
            }
        } catch (IOException | InterruptedException error) {
            System.out.println("Não foi possível fazer a conversão.");
            System.out.println(error.getMessage());
        }

        return null;
    }

    public String obterSimboloMoeda(String codigoMoeda) {
        switch (codigoMoeda) {
            case "BRL":
                return "R$";
            case "USD":
                return "$";
            case "AUD":
                return "A$";
            case "EUR":
                return "€";
            case "TWD":
                return "NT$";
            case "ZAR":
                return "R";
            case "JPY":
                return "¥";
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        String simboloMoedaOrigem = obterSimboloMoeda(getBase_code());
        String simboloMoedaDestino = obterSimboloMoeda(getTarget_code());

        return "Conversão de: " + getBase_code() + " para " + getTarget_code() + "\n" +
                "Valor a ser convertido: " + simboloMoedaOrigem + " " + String.format("%.2f", getCoinValue()) + "\n" +
                "Resultado da Conversão: " + simboloMoedaDestino + " " + String.format("%.2f", getResultado()) + "\n";
    }
}
