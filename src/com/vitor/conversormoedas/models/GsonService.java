package com.vitor.conversormoedas.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class GsonService {

    ApiConnector apiConnector;

    public GsonService(ApiConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    public void jsonConverter(double valor) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

       String responseString = apiConnector.makeRequest();

       CurrencyDTO currencyDTO = gson.fromJson(responseString, CurrencyDTO.class);

        System.out.println("O valor " + valor + " [" + currencyDTO.base_code() + "]" + " corresponde ao valor final de ----> " + currencyDTO.conversion_result() + " [" + currencyDTO.target_code() + "]");


    }

}
