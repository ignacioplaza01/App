package com.example.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MostrarHistorial extends AppCompatActivity {
    DatabaseReference database;
    ListView listaHistorial;
    ArrayList<Historial> historial ;
    ArrayAdapter<Historial> adaptadorPulsos;
    Button eliminar_Historial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_historial);
        listaHistorial = (ListView) findViewById(R.id.listaHistorial);
        historial = new ArrayList<>();


        cargarBD();
        eliminarHistorial();
    }
    private void eliminarHistorial() {
        eliminar_Historial = (Button) findViewById(R.id.eliminar_Historial);
        eliminar_Historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance().getReference("Historial");

                database.removeValue();
                Toast.makeText(MostrarHistorial.this, "Historial eliminado", Toast.LENGTH_SHORT).show();

            }
        });

    }




    private void cargarBD() {
        database = FirebaseDatabase.getInstance().getReference("Historial");
        ValueEventListener pulsosListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot d : snapshot.getChildren()) {

                    String pulsoMin = d.child("pulsoMin").getValue().toString();
                    String pulsoMax = d.child("pulsoMax").getValue().toString();

                    Historial a = new Historial(pulsoMin, pulsoMax);
                    historial.add(a);

                }
                adaptadorPulsos = new ArrayAdapter<Historial>(getApplicationContext(), android.R.layout.simple_list_item_1, historial);
                listaHistorial.setAdapter(adaptadorPulsos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Un error");
            }
        };

        database.addValueEventListener(pulsosListener);

    }




}
