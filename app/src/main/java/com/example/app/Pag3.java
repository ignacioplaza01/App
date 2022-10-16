package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Pag3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag3);
    }

    public void back(View v) {
        Toast.makeText(this, "Registro automatico activado", Toast.LENGTH_SHORT).show();
        Intent e = new Intent(this, MainActivity.class);
        startActivity(e);
    }
}