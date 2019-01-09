package com.example.user10.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private TextView textView;
    private Button button;
    private SharedPreferences sp;
    private static final String APP_PREFERENCES = "tokens";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        sp = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);





    }


    public void onclick(View v) throws IOException, JSONException, InterruptedException {

        int token;
        String name = editText.getText().toString();
        SharedPreferences.Editor  editor = sp.edit();



        if(sp.contains(name)) {
            textView.setText(String.valueOf(sp.getInt(name, 0)));
            token = sp.getInt(name,0);

        }
        else {

    ThreadNet threadNet = new ThreadNet(name);
    threadNet.start();
    threadNet.join();
    token = threadNet.getToken();

    editor.putInt(name, token);
    editor.apply();



        }

        textView.setText(String.valueOf(token));

        Intent intent = new Intent(this, TwoActivity.class);
        intent.putExtra("token", token);
         startActivity(intent);






        }

}