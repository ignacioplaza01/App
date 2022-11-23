package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class Pag2 extends AppCompatActivity {
    DatabaseReference database;
    Button mostrar_historial,registrar_pulso;
    TextView pulso1,pulso2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag2);

        pulso1 = (TextView) findViewById(R.id.pulso1);
        pulso2 = (TextView) findViewById(R.id.pulso2);

        database = FirebaseDatabase.getInstance().getReference();
        database.child("Detector").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    String pulsoMinimo = snapshot.child("PulsoMin").getValue().toString();
                    String pulsoMaximo = snapshot.child("PulsoMax").getValue().toString();
                    pulso1.setText(pulsoMinimo);
                    pulso2.setText(pulsoMaximo);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        registrar_pulso = (Button) findViewById(R.id.registrar_pulso);
        registrar_pulso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pag2.this, "Pulso Registrado", Toast.LENGTH_SHORT).show();
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
        String key = UUID.randomUUID().toString();
        String pulsoMin = pulso1.getText().toString();
        String pulsoMax = pulso2.getText().toString();


        Historial a = new Historial(pulsoMin,pulsoMax);


        database = FirebaseDatabase.getInstance().getReference("Historial");
        database.child(key).setValue(a);

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