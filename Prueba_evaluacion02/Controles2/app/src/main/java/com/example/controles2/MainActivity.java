package com.example.controles2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText text1, text3;
    private TextView salida, salida2, salida3;
    private CheckBox ch1, ch2, ch3, ch4, ch5;
    private String cod1="", cod2="", cod3="", cod4="", cod5="";
    private RadioButton ra1, ra2, ra3, ra4, ra5;
    private String fer1="", fer2="",fer3="", fer4="", fer5="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida = findViewById(R.id.tv1);
        salida2 = findViewById(R.id.tv2);
        salida3 = findViewById(R.id.tv3);

        text1 = findViewById(R.id.text1);
        text3 = findViewById(R.id.text3);

        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        ch4 = findViewById(R.id.ch4);
        ch5 = findViewById(R.id.ch5);

        ra1 = findViewById(R.id.ra1);
        ra2 = findViewById(R.id.ra2);
        ra3 = findViewById(R.id.ra3);
        ra4 = findViewById(R.id.ra4);
        ra5 = findViewById(R.id.ra5);




        }
        public void mostrar (View vista){
        String tvNombre_String = text1.getText().toString();
        String tvApellido_String = text3.getText().toString();

        String mostrar = "" ;
        String info = tvNombre_String + tvApellido_String;
        mostrar = " "+info;
        salida.setText(mostrar);

    }




    public void ch1(View view){

        if(ch1.isChecked()==true) {
            cod1 = "  Java    ";
        }
        else {
            cod1 = " ";
        }
        salida2.setText(cod1+cod2+cod3+cod4+cod5);

    }

    public void ch2(View view) {
        if(ch2.isChecked()==true) {
            cod2 = "  Php ";
        }
        else {
            cod2 = " ";
        }
        salida2.setText(cod1+cod2+cod3+cod4+cod5);
    }

    public void ch3(View view) {
        if(ch3.isChecked()==true) {
            cod3 = "  Python  ";
        }
        else {
            cod3 = " ";
        }
        salida2.setText(cod1+cod2+cod3+cod4+cod5);
    }

    public void ch4(View view) {
        if(ch4.isChecked()==true) {
            cod4 = "  C#  ";
        }
        else {
            cod4 = " ";
        }
        salida2.setText(cod1+cod2+cod3+cod4+cod5);
    }

    public void ch5(View view) {
        if (ch5.isChecked() == true) {
            cod5 = "    C++ ";
        }
        else {
            cod5 = " ";
        }
        salida2.setText(cod1 + cod2 + cod3 + cod4 + cod5);
    }
    public void ra1(View view) {
        if(ra1.isChecked()==true) {
            fer1 = "    Java    ";
        }
            else {
            fer1 = " ";
        }
        salida3.setText(fer1+fer2+fer3+fer4+fer5);
        }
        public void ra2(View view) {
            if(ra2.isChecked()==true) {
                fer2 = "    Php ";
            }
            else {
                fer2 = "    ";
            }
            salida3.setText(fer1+fer2+fer3+fer4+fer5);
            }
            public void Ra3(View view) {
                if (ra3.isChecked() == true) {
                    fer3 = "    Python ";
                } else {
                    fer3 = "    ";
                }
                salida3.setText(fer1+fer2+fer3+fer4+fer5);
            }

            public void Ra4(View view) {
                if (ra4.isChecked() == true) {
                fer4 = "    c# ";
                }
                else {
                fer4 = "    ";
                }
                salida3.setText(fer1+fer2+fer3+fer4+fer5);
            }
            public void Ra5(View view) {
                if (ra5.isChecked() == true) {
                    fer5 = "    c++ ";
                }
                    else {
                    fer5 = "    ";
                }
                salida3.setText(fer1+fer2+fer3+fer4+fer5);
            }


}
