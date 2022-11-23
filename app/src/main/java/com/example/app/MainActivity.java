package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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