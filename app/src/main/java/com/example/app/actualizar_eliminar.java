package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.Modelo.Pulso;
import com.google.gson.Gson;

public class actualizar_eliminar extends AppCompatActivity {
    Pulso a;
    Button eliminar,modificar;
    EditText min,max,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_eliminar);
        obtenerPulso();
        cargarPulso();
    }
    public void obtenerPulso() {
        Bundle b = this.getIntent().getExtras();
        String pulsoString = b.getString("Pulsos");
        Gson gson = new Gson();
        this.a = (Pulso) gson.fromJson(pulsoString,Pulso.class);
        System.out.println(this.a.pulsoMin);
    }
    public void cargarPulso() {
        min = (EditText) findViewById(R.id.editMin);
        max = (EditText) findViewById(R.id.editMax);
        fecha = (EditText) findViewById(R.id.editFecha);
        modificar = (Button) findViewById(R.id.modificar);
        eliminar = (Button) findViewById(R.id.eliminar);
        System.out.println("min: "+this.a.pulsoMin);
        min.setText(this.a.pulsoMin);
        max.setText(this.a.pulsoMax);
        fecha.setText(this.a.verFecha);
    }
}