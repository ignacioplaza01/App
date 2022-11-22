package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.Modelo.Pulso;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Pag2 extends AppCompatActivity {
    FirebaseDatabase database;
    Button registrar_pulso,mostrar_historial,eliminar_historial;
    EditText min,max,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag2);

        min = (EditText) findViewById(R.id.min);
        max = (EditText) findViewById(R.id.max);
        fecha = (EditText) findViewById(R.id.fecha);
        registrar_pulso = (Button) findViewById(R.id.registrar_pulso);
        registrar_pulso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pag2.this, "si", Toast.LENGTH_SHORT).show();
                insertar();

            }
        });
        llamadoActivityMostrarFecha();


    }
    private void llamadoActivityMostrarFecha() {
        mostrar_historial = (Button) findViewById(R.id.mostrar_historial);
        mostrar_historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MostrarHistorial.class);
                startActivity(i);

            }
        });
    }



    public void insertar() {
        String pulsoMin = min.getText().toString();
        String pulsoMax = max.getText().toString();
        String verFecha = fecha.getText().toString();
        String key = UUID.randomUUID().toString();
        Pulso a = new Pulso(key,pulsoMin,pulsoMax,verFecha);

        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Pulsos");
        myRef.child(key).setValue(a);

    }

    public void alert(View v) {
        Toast.makeText(this, "Pulso registrado", Toast.LENGTH_SHORT).show();
    }

    public void pulsoAuto(View v) {
        Intent w = new Intent(this,Pag3.class);
        startActivity(w);
    }

    public void not(View v) {
        Intent q = new Intent(this,Pag4.class);
        startActivity(q);
    }
}