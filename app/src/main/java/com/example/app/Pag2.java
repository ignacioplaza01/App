package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Pag2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag2);
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