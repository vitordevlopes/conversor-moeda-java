package com.vitor.conversormoedas.models;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiConnector {

    private String base;
    private String target;
    private  double valor;

    public ApiConnector(String base, String target, double valor) {
        this.base = base;
        this.target = target;
        this.valor = valor;
    }

    public String makeRequest() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/457e86fb06c30c1b6a57cf65/pair/" + base + "/" + target + "/" + valor))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }

}
