package Services;

import Entities.Coin;
import Utils.Util;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CoinServices {

    static String webservice = "https://economia.awesomeapi.com.br/json/last/";
    static int successCode = 200;

    public static Coin ConvertCoinFor(String convertionType) throws Exception{

        String callURL = webservice + convertionType;

        try {
            URL url = new URL(callURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != successCode){
                throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String jsonInString = Util.convertJsonInString(response);

            Gson gson = new Gson();
            Coin coin = gson.fromJson(jsonInString, Coin.class);
            return coin;
        } catch (Exception e){
            throw new Exception("ERROR: " + e);
        }
    }
}
