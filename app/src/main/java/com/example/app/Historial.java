package com.example.app;

public class Historial {

    public String pulsoMin;
    public String pulsoMax;



    public Historial() {
    }

    public Historial(  String pulsoMin, String pulsoMax) {

        this.pulsoMin = pulsoMin;
        this.pulsoMax = pulsoMax;

    }

    public String getPulsoMin() {
        return pulsoMin;
    }

    public void setPulsoMin(String pulsoMin) {
        this.pulsoMin = pulsoMin;
    }

    public String getPulsoMax() {
        return pulsoMax;
    }

    public void setPulsoMax(String pulsoMax) {
        this.pulsoMax = pulsoMax;
    }

    @Override
    public String toString() {
        return

                " Pulso.Min=   " + pulsoMin + '\'' +
                        " Pulso.Max=   " + pulsoMax + '\''



                ;

    }
}
