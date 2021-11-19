package com.yriquelme.prueba_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add_sensor, btn_gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add_sensor = (Button) findViewById(R.id.btn_agregar_sensor);
        btn_add_sensor.setOnClickListener(this);

        btn_gps=(Button) findViewById(R.id.btn_mapa);
        btn_gps.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_agregar_sensor:
                Intent agregarSensorIntent = new Intent(this, agregar_sensor.class);
                startActivity(agregarSensorIntent);
                break;

            case R.id.btn_mapa:
                Intent mapActivityIntent = new Intent(this, MapsActivity.class);
                startActivity(mapActivityIntent);
                break;
        }
    }
}