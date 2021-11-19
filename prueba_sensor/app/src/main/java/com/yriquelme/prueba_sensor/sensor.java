package com.yriquelme.prueba_sensor;

public class sensor {

    private String Nomnbre_sensor;
    private String Valor_sensor;

    public sensor(String nameSensor, String valueSensor) {
        this.Nomnbre_sensor = nameSensor;
        this.Nomnbre_sensor = valueSensor;
    }

    public sensor() {
    }

    public String getNameSensor(){
        return Nomnbre_sensor;
    }

    public void setNameSensor(String nameSensor){
        this.Nomnbre_sensor = nameSensor;
    }

    public String getValueSensor(){
        return Valor_sensor;
    }

    public void setValueSensor(String valueSensor){
        this.Valor_sensor = valueSensor;
    }
}
