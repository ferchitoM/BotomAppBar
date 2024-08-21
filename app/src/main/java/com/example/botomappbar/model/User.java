package com.example.botomappbar.model;

public class User {

    public String nombre;
    public String correo;
    public String contraseña;

    public User(){
        this.nombre = "";
        this.correo = "";
        this.contraseña = "";
    }

    public User(String nombre, String correo, String contraseña){
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }
}
