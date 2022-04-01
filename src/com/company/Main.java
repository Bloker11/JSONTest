package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        APIConnector connector = new APIConnector();
        try {
           String data = connector.getCurrencyData();
           String[] array = data.split(",");

           String numberValue;
           Double plnValue;

           for (String s : array){
               if(s.contains("PLN")){
                   numberValue = s.split(":")[1];
                   plnValue = Double.parseDouble(numberValue);
                   System.out.println(plnValue);
               }
           }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
