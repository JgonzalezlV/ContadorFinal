package com.example.contadorfuncional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity<ActivityMainBinding, AppBarConfiguration> extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    public int contador;
    private Spinner spinner;
    private String[] opciones = {"Positivo","Negativo"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = 0;
        crearSpinner();



    }

    private void crearSpinner() {

        spinner = (Spinner) findViewById(R.id.menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,opciones);
        spinner.setAdapter(adapter);


    }



    public void incrementaContador(View vista){


        /*if (contador>0){
            RadioButton positivos = (RadioButton) findViewById(R.id.positivo);
            if (!positivos.isChecked()){
                contador = 0;
            }
        }*/
        contador++;
        String seleccion = spinner.getSelectedItem().toString();
        if (contador>0){
            if (!seleccion.equals("Positivo")){
                contador = 0;
            }
        }
        mostrarResultados();

    }

    public void restaContador(View vista){

        contador--;
        /*if (contador<0){
            RadioButton negativos = (RadioButton) findViewById(R.id.negativo);
            if (!negativos.isChecked()){
                contador = 0;
            }
        }*/
        String seleccion = spinner.getSelectedItem().toString();
        if (contador<0){
            if (!seleccion.equals("Negativo")){
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