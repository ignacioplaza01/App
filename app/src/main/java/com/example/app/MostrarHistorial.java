package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.app.Modelo.Pulso;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MostrarHistorial extends AppCompatActivity {
    FirebaseDatabase database;
    ListView listaHistorial;
    ArrayList<Pulso> pulsos;
    ArrayAdapter<Pulso> adaptadorPulsos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_historial);
        listaHistorial = (ListView) findViewById(R.id.listaHistorial);
        pulsos = new ArrayList<Pulso>();
        cargarBD();
    }

    private void cargarBD() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference pulsosRef = database.getReference("Pulsos");
        ValueEventListener pulsosListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot d: snapshot.getChildren()) {
                    String key = d.child("key").getValue().toString();
                    String pulsoMin = d.child("pulsoMin").getValue().toString();
                    String pulsoMax = d.child("pulsoMax").getValue().toString();
                    String verFecha = d.child("verFecha").getValue().toString();
                    Pulso a = new Pulso(key,pulsoMin,pulsoMax,verFecha);
                    pulsos.add(a);

                }
                adaptadorPulsos = new ArrayAdapter<Pulso>(getApplicationContext(), android.R.layout.simple_list_item_1,pulsos);
                listaHistorial.setAdapter(adaptadorPulsos);
                listaHistorial.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Pulso a = (Pulso) adapterView.getItemAtPosition(i);
                        Intent intencion = new Intent(getApplicationContext(), actualizar_eliminar.class);
                        Gson gson = new Gson();
                        String Pulsos =gson.toJson(a);
                        intencion.putExtra("Pulsos",Pulsos);

                        startActivity(intencion);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Un error");

            }
        };
        pulsosRef.addValueEventListener(pulsosListener);

    }

}