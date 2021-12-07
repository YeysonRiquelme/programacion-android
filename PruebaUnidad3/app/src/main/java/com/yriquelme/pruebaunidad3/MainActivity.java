package com.yriquelme.pruebaunidad3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yriquelme.pruebaunidad3.model.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private List<Sensor> listsensores = new ArrayList<Sensor>();
    ArrayAdapter<Sensor> sensorArrayAdapterSensor;

    EditText sNombre, sTipo, sValor, sUbicacion, sFecha_Hora;
    ListView List_sensores;
    Sensor sensorSelected;

    String nombre_dispositivo;
    String publicar;
    boolean permiso_publicar = false;
    boolean intento_publicar=false;

    static String NQTTHOST = "";
    static String USERNAME = "Yeyson";


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obtener_nombre();


        sNombre = findViewById(R.id.edt_Nombre);
        sTipo = findViewById(R.id.edt_Tipo);
        sValor = findViewById(R.id.edt_Valor);
        sUbicacion = findViewById(R.id.edt_Ubicacion);
        sFecha_Hora = findViewById(R.id.edt_fecha_hora);

        List_sensores = (ListView) findViewById(R.id.lv_datosSensores);
        iniciarFirebase();
        listaDatos();

        List_sensores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sensorSelected = (Sensor) parent.getItemAtPosition(position);
                sNombre.setText(sensorSelected.getNombre());
                sTipo.setText(sensorSelected.getTipo());
                sValor.setText(sensorSelected.getValor());
                sUbicacion.setText(sensorSelected.getUbicacion());
                sFecha_Hora.setText(sensorSelected.getFecha_Hora());
            }
        });

    }

    private void listaDatos() {
        databaseReference.child("Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listsensores.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Sensor s = snapshot.getValue(Sensor.class);
                    listsensores.add(s);

                    sensorArrayAdapterSensor = new ArrayAdapter<Sensor>(MainActivity.this, android.R.layout.simple_list_item_1, listsensores);
                    List_sensores.setAdapter(sensorArrayAdapterSensor);

                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }






    private void obtener_nombre() {
        String fabricante = Build.MANUFACTURER;
        String modelo = Build.MODEL;
        nombre_dispositivo = fabricante + "" + modelo;
    }

    private void iniciarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        String Nombre = sNombre.getText().toString();
        String Tipo = sTipo.getText().toString();
        String Valor = sValor.getText().toString();
        String Ubicacion = sUbicacion.getText().toString();
        String Fecha_hora = sFecha_Hora.getText().toString();
        switch (item.getItemId()){

            case R.id.icon_add:{
                if(Nombre.equals("")||(Tipo.equals(""))||(Valor.equals(""))||(Ubicacion.equals(""))||Fecha_hora.equals("")){
                    Validacion();
                }
                else{
                    Sensor s = new Sensor();

                    s.setUid(UUID.randomUUID().toString());
                    s.setNombre(Nombre);
                    s.setTipo(Tipo);
                    s.setValor(Valor);
                    s.setUbicacion(Ubicacion);
                    s.setFecha_Hora(Fecha_hora);
                    databaseReference.child("Sensor").child(s.getUid()).setValue(s);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
                    Limpiar();

                }
                break;

            }
            case R.id.icon_delete:{
                Sensor s = new Sensor();
                s.setUid(sensorSelected.getUid());
                databaseReference.child("Sensor").child(s.getUid()).removeValue();
                Toast.makeText(this, "Eliminado", Toast.LENGTH_LONG).show();
                Limpiar();
                break;
            }
            case R.id.icon_save:{
                Sensor s = new Sensor();
                s.setUid(sensorSelected.getUid());
                s.setNombre(sNombre.getText().toString().trim());
                s.setTipo(sTipo.getText().toString().trim());
                s.setValor(sValor.getText().toString().trim());
                s.setUbicacion(sUbicacion.getText().toString().trim());
                s.setFecha_Hora(sFecha_Hora.getText().toString().trim());
                databaseReference.child("Sensor").child(s.getUid()).setValue(s);

                Toast.makeText(this, "Actualizado", Toast.LENGTH_LONG).show();
                Limpiar();
                break;
            }
            default:break;
        }
        return true;
    }



    private void Limpiar() {
            sNombre.setText("");
            sTipo.setText("");
            sValor.setText("");
            sUbicacion.setText("");
            sFecha_Hora.setText("");
        }


    private void Validacion() {
        String Nombre = sNombre.getText().toString();
        String Tipo = sTipo.getText().toString();
        String Valor = sValor.getText().toString();
        String Ubicacion = sUbicacion.getText().toString();
        String Fecha_hora = sFecha_Hora.getText().toString();

        if(Nombre.equals("")){
            sNombre.setError("Required");
        }
        else if(Tipo.equals("")){
            sTipo.setError("Required");
        }
        else if(Valor.equals("")){
            sValor.setError("Required");
        }
        else if(Ubicacion.equals("")){
            sUbicacion.setError("Required");
        }
        else if(Fecha_hora.equals("")){
            sFecha_Hora.setError("Required");
        }
    }
}







