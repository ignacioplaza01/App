package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.app.Modelo.Pulso;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencia al Toolbar



    }








    //Conectar views
    public void star(View v) {
        Intent i = new Intent(this, Pag2.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.op1){

            Intent i = new Intent(this, Pag5.class);
            startActivity(i);

        }
        else if(id==R.id.op2){

            Intent i = new Intent(this, Pag3.class);
            startActivity(i);
        }
        else if(id==R.id.op3){

            Intent i = new Intent(this, Pag4.class);
            startActivity(i);
        }
        else if(id==R.id.op4){
            Toast.makeText(this, "Historial eliminado", Toast.LENGTH_SHORT).show();
        }

            return super.onOptionsItemSelected(item);
        }



}