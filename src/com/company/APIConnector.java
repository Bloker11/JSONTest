package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIConnector {
    public static final String API_KEY = "d6CTv2zv23oxcBi9NAW7zUqMdmiy3sKEJDWZjW49";
    public static final String url = "https://freecurrencyapi.net/api/v2/latest";

    public String getCurrencyData() throws Exception {
        URL urlForGetRequest = new URL(url + "?apikey=" + API_KEY);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new Exception("Error in API Call");
        }
    }
}

