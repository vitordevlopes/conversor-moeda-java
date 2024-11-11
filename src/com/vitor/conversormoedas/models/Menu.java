package com.vitor.conversormoedas.models;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void showMenu() throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        GsonService gsonService;


        double valor;
        int choice;

        while (true) {


            System.out.println("Bem vindo ao Conversor de Moedas!\n");

            System.out.println("1) Dólar --> Peso argentino");
            System.out.println("2) Peso argentino --> Dólar");
            System.out.println("3) Dólar --> Real brasileiro");
            System.out.println("4) Real brasileiro --> Dólar");
            System.out.println("5) Sair");

            System.out.print("Escolha uma das opções: ");

            choice = scanner.nextInt();

            if (choice == 5) {

                System.out.println("Saindo...");
                break;

            }

            System.out.println("Escolha o valor que deseja converter:");

            valor = scanner.nextDouble();

            switch (choice) {

                case 1:
                    gsonService = new GsonService(new ApiConnector("USD", "ARS", valor));
                    gsonService.jsonConverter(valor);
                        break;

                case 2:
                    gsonService = new GsonService(new ApiConnector("ARS", "USD", valor));
                    gsonService.jsonConverter(valor);
                        break;

                case 3:
                    gsonService = new GsonService(new ApiConnector("USD", "BRL", valor));
                    gsonService.jsonConverter(valor);
                        break;

                case 4:
                    gsonService = new GsonService(new ApiConnector("BRL", "USD", valor));
                    gsonService.jsonConverter(valor);
                        break;

                default:
                    System.out.println("Opção inválida");




            }

            }

        }

    }


