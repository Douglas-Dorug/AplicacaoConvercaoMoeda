import Entities.Coin;
import Services.CoinServices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Informe como deseja converter a moeda:");
        System.out.println("1 - Real Brasileiro para Dolar Americano \n2 - Dolar Americano para Real Brasileiro");
        int answer = new Scanner(System.in).nextInt();

        String coinType = "";
        if (answer == 1){
            coinType = "BRL-USD";
        }
        else if (answer == 2){
            coinType = "USD-BRL";
        }

        Coin coin = CoinServices.ConvertCoinFor(coinType);

        System.out.println("Informe a quantidade que deseja converter");
        Double money = new Scanner(System.in).nextDouble();

        Double convertedValue = Converter(money, coin.getBRLUSD());

        System.out.println("Total= " + convertedValue);


    }

    public static Double Converter(Double money, Double highJson) throws Exception {
        Double convertedValue = money * highJson;

        return convertedValue;
    }
}
