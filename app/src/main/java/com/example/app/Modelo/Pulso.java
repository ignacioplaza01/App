package com.example.app.Modelo;

public class Pulso {
    public String key;
    public String pulsoMin;
    public String pulsoMax;
    public String verFecha;

    public Pulso() {
    }

    public Pulso(String key, String pulsoMin, String pulsoMax, String verFecha) {
        this.key = key;
        this.pulsoMin = pulsoMin;
        this.pulsoMax = pulsoMax;
        this.verFecha = verFecha;
    }


    @Override
    public String toString() {
        return

                " Pulso.Min=   " + pulsoMin + '\'' +
                " Pulso.Max=   " + pulsoMax + '\'' +
                " Fecha=   " + verFecha + '\''

                ;

    }
}