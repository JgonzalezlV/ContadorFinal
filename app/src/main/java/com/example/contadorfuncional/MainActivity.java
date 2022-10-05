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
    private ArrayAdapter<CharSequence> adapter = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = 0;
        crearSpinner();



    }

    private void crearSpinner() {

        Spinner spinner = (Spinner) findViewById(R.id.menu);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.eleccion, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);



    }



    public void incrementaContador(View vista){


        contador++;

        if (contador>0){
            RadioButton positivos = (RadioButton) findViewById(R.id.positivo);
            if (!positivos.isChecked()){
                contador = 0;
            }
        }
        mostrarResultados();

    }

    public void restaContador(View vista){

        contador--;
        if (contador<0){
            RadioButton negativos = (RadioButton) findViewById(R.id.negativo);
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