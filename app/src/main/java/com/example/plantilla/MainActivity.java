package com.example.plantilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA = "com.example.plantilla";
    private static final String nipCorrecto = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.IrAOtraAplicacion); // DECLARAR EL BOTON PARA IR A OTRA APLICACION
        EditText nip = findViewById(R.id.ingresaNip);
        EditText usuario = findViewById(R.id.ingresaNumeroCuenta);

        boton.setOnClickListener(view ->
        {
            
            String nipIngresado = nip.getText().toString();
            
            if (nipCorrecto.equals(nipIngresado))
            {

                Intent Ir = new Intent(this, OtraAplicacion.class);
                Ir.putExtra(EXTRA, usuario.getText().toString());
                startActivity(Ir);
                
            }
            else
            {

                Toast.makeText(this, "Estas mal pendejo", Toast.LENGTH_SHORT).show();
                
            }

        });



    }
}