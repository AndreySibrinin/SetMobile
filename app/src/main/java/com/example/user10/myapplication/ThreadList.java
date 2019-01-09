package com.example.user10.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreadList extends  Thread {

         private  int token;
         private ArrayList<Card> allCards;


    public ThreadList(int token) {
        this.token = token;
    }


    public ArrayList<Card> getAllcards() {
        return allCards;
    }

    @Override
    public void run() {




        this.allCards = new ArrayList<>();

        try {
            String set_server_url = "http://194.176.114.21:8050/";
            String data = "{\"action\" : \"fetch_cards\", \"token\" :"  + this.token + "}";

            URL url = new URL(set_server_url);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);

            OutputStream out = urlConnection.getOutputStream();
            out.write(data.getBytes());

            Scanner in = new Scanner(urlConnection.getInputStream());

            if (in.hasNext()) {
                String response = in.nextLine();
                JSONObject resp = new JSONObject(response);
                JSONArray cards = resp.getJSONArray("cards");
                for (int k = 0; k < cards.length(); k++) {
                    JSONObject c = cards.getJSONObject(k);
                    int count = c.getInt("count");
                    int color = c.getInt("color");
                    int shape = c.getInt("shape");
                    int fill = c.getInt("fill");
                    allCards.add(new Card(count, fill, shape, color));

                }

            }
            urlConnection.disconnect();

        }
             catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
         catch (JSONException e) {
                e.printStackTrace();
            }


    }
}