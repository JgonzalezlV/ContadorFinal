package com.example.contadorfuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity<ActivityMainBinding, AppBarConfiguration> extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    public int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = 0;


    }

    public void incrementaContador(View vista){

        contador++;
        mostrarResultados();

    }

    public void restaContador(View vista){

        contador--;
        if (contador<0){
            CheckBox negativos = (CheckBox) findViewById(R.id.checkBox);
            if (!negativos.isChecked()){
                contador = 0;
            }
        }
        mostrarResultados();

    }

    public void reseteaContador(View vista){


        contador = Integer.parseInt(reiniciarNumeros());
        mostrarResultados();

    }

    public void mostrarResultados(){

        TextView textoResultado = (TextView) findViewById(R.id.contadorTexto);
        textoResultado.setText("" + contador);

    }

    public String reiniciarNumeros(){

        TextView textoResultado = (TextView) findViewById(R.id.reseteaNumero);

        return textoResultado.getText().toString();
    }

}