package com.example.plantilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

public class OtraAplicacion extends AppCompatActivity {

    private static double cuentaDinero = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra_aplicacion);

        Intent llegar = getIntent(); // PARA PODER LLEGAR A LA APLICACION ES !NECESARIO!
        String usuario = llegar.getStringExtra(MainActivity.EXTRA);

        EditText dato1 = findViewById(R.id.dato1),
                 dato2 = findViewById(R.id.dato2),
                 dato3 = findViewById(R.id.dato3);

        TextView mostrarDato1 = findViewById(R.id.mostrarDato1),
                 mostrarDato2 = findViewById(R.id.mostrarDato2),
                 mostrarDato3 = findViewById(R.id.mostrarDato3);

        Button mostrarDatos = findViewById(R.id.botonMostrar);

        AtomicReference<Double> cuantoTienes = new AtomicReference<>((double) 0);

        mostrarDatos.setOnClickListener(view ->
        {

           cuantoTienes.set(Double.parseDouble(dato1.getText().toString()));
           double cuantoSacas  = Double.parseDouble(dato2.getText().toString());
           double cuantoSobra  = cuantoTienes.get() - cuantoSacas;

           if (cuantoSobra < 0)
           {

               Toast.makeText(this, "Puto jodido", Toast.LENGTH_SHORT).show();

           }
           else
           {

               mostrarDato1.setText(String.format(String.valueOf(cuantoSobra)));
               mostrarDato2.setText("El pendejo que entro es el: "+ usuario);

           }



        });
    }
}