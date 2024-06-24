package com.javatest.javatest.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class UserData {

    @JsonProperty("Nombre")
    public String name;
    public String age;

    @JsonGetter("Campo_Extra")
    public String campo_extra(){
        return "Valo de Campo Extra";
    }

    @JsonValue
    public String info(){
        return "Devuelve este String en vez de los valores en un Json de Nombre: "+ name +" y Edad: " + age + "y el campo extra: " + campo_extra();
    }


    public UserData(String name, String age){
        this.name = name;
        this.age = age;
    }
}
