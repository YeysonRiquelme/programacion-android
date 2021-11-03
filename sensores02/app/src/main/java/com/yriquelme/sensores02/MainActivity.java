package com.yriquelme.sensores02;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void adormir(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void Login(View v){
        Toast.makeText(this, "Ingresando datos", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=10; i++){
                    adormir();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                    }
                });

            }

        }).start();
        Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
    }
}